package gameObjects

import java.awt.Point

class Bishop(c: Color) : Piece(c) {

    val topRight = (1 until 7).map { i -> Point(i, i) }
    val topLeft = (1 until 7).map { i -> Point(-i, i) }
    val bottomRight = (1 until 7).map { i -> Point(i, -i) }
    val bottomLeft = (1 until 7).map { i -> Point(-i, -i) }

    init {
        strIcon = when (c) {
            Color.White -> "♗"
            else -> "♝"
        }
        possibleMoves = (topRight + topLeft + bottomRight + bottomLeft) as ArrayList<Point>
    }

    override fun canMove(board: Board, start: Square, end: Square): Boolean {
        val colMove = end.col - start.col
        val rowMove = end.row - start.row

        println("Bishop move distance in x:$colMove and y:$rowMove")

        // Cannot move on top of a friendly piece
        if (end.piece?.color == this.color)
            return false

        else if (possibleMoves.contains(Point(colMove, rowMove))) {
            val movesInRegion =
                    if (colMove > 0 && rowMove > 0) topRight
                    else if (colMove < 0 && rowMove > 0) topLeft
                    else if (colMove > 0 && rowMove < 0) bottomRight
                    else bottomLeft

            // Verify if there is a piece in the path towards the EndSquare
            for (point in movesInRegion) {
                // X and Y values are flipped
                val row = start.row + point.y
                val col = start.col + point.x

                if (row in 0..7 && col in 0..7) {
                    // If we have reached our destination
                    if (board.squares[row][col] == end)
                        return true

                    // Check if squares in between the start and end contain a piece
                    if (board.squares[row][col].piece != null) {
                        println("A piece is blocking the way.")
                        return false
                    }
                }
            }
        }
        return true
    }
}
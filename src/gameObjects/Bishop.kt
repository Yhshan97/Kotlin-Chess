package gameObjects

import java.awt.Point

class Bishop(c: Color) : Piece(c) {

    private val topRight = (1 until 7).map { i -> Point(i, i) }
    private val topLeft = (1 until 7).map { i -> Point(-i, i) }
    private val bottomRight = (1 until 7).map { i -> Point(i, -i) }
    private val bottomLeft = (1 until 7).map { i -> Point(-i, -i) }

    init {
        strIcon = when (c) {
            Color.White -> "♗"
            else -> "♝"
        }
        possibleMoves = (topRight + topLeft + bottomRight + bottomLeft) as ArrayList<Point>
    }

    override fun canMove(board: Board, start: Square, end: Square): Boolean {
        // Pre-checks identical to every piece
        if(!super.canMove(board, start, end)) return false

        val colMove = end.col - start.col
        val rowMove = end.row - start.row

        // Move contained in the array of all available moves
        if (possibleMoves.contains(Point(colMove, rowMove))) {

            val movesUntilEndSquare = when {
                colMove > 0 && rowMove > 0 -> topRight
                colMove < 0 && rowMove > 0 -> topLeft
                colMove > 0 && rowMove < 0 -> bottomRight
                else -> bottomLeft
            }

            // Verify if there is a piece in the path towards the EndSquare
            return noPieceOnPath(start, end, board, movesUntilEndSquare)
        }

        return false
    }

}
package gameObjects

import java.awt.Point

class Queen(c:Color) : Piece(c) {

    private val top = (1 until 7).map { i -> Point(0, i) }
    private val left = (1 until 7).map { i -> Point(-i, 0) }
    private val right = (1 until 7).map { i -> Point(i, 0) }
    private val bottom = (1 until 7).map { i -> Point(0, -i) }

    private val topRight = (1 until 7).map { i -> Point(i, i) }
    private val topLeft = (1 until 7).map { i -> Point(-i, i) }
    private val bottomRight = (1 until 7).map { i -> Point(i, -i) }
    private val bottomLeft = (1 until 7).map { i -> Point(-i, -i) }

    init {
        strIcon = when (c)
        {
            Color.White -> "♕"
            else -> "♛"
        }
        possibleMoves = (topRight + topLeft + bottomRight + bottomLeft + top + bottom + left + right) as ArrayList<Point>
    }

    override fun canMove(board: Board, start: Square, end: Square): Boolean {
        // Pre-checks identical to every piece
        if(!super.canMove(board, start, end)) return false

        val colMove = end.col - start.col
        val rowMove = end.row - start.row

        // Move contained in the array of all available moves
        if (possibleMoves.contains(Point(colMove, rowMove))) {
            val movesInRegion =
                    // When either x and y pos are not 0, means the piece will move diagonally
                    if(colMove * rowMove != 0)  {
                        when {
                            colMove > 0 && rowMove > 0 -> topRight
                            colMove < 0 && rowMove > 0 -> topLeft
                            colMove > 0 && rowMove < 0 -> bottomRight
                            else -> bottomLeft
                        }
                    }

                    // Else they are moving in a straight line
                    else {
                        when {
                            colMove > 0 -> right
                            colMove < 0 -> left
                            rowMove > 0 -> top
                            else -> bottom
                        }
                    }

            // Verify if there is a piece in the path towards the EndSquare
            return noPieceOnPath(start, end, board, movesInRegion)
        }


        return false
    }
}
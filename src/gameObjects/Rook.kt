package gameObjects

import java.awt.Point

class Rook(c: Color) : Piece(c){

    private val top = (1 until 7).map { i -> Point(0, i) }
    private val left = (1 until 7).map { i -> Point(-i, 0) }
    private val right = (1 until 7).map { i -> Point(i, 0) }
    private val bottom = (1 until 7).map { i -> Point(0, -i) }

    init {
        strIcon = when (c)
        {
            Color.White -> "♖"
            else -> "♜"
        }
        possibleMoves = (top + bottom + left + right) as ArrayList<Point>
    }

    override fun canMove(board: Board, start: Square, end: Square): Boolean {
        // Pre-checks identical to every piece
        if(!super.canMove(board, start, end)) return false

        val colMove = end.col - start.col
        val rowMove = end.row - start.row

        // Move contained in the array of all available moves
        if (possibleMoves.contains(Point(colMove, rowMove))) {
            val movesInRegion =
                    when {
                        colMove > 0 -> right
                        colMove < 0 -> left
                        rowMove > 0 -> top
                        else -> bottom
                    }

            // Verify if there is a piece in the path towards the EndSquare
            return noPieceOnPath(start, end, board, movesInRegion)
        }

        return false
    }
}
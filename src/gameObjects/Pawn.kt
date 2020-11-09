package gameObjects

import java.awt.Point

class Pawn(c: Color) : Piece(c) {
    private var promoted = false
    private var captureMoves:ArrayList<Point>
    private var direction = 0

    init {
        strIcon = when (c)
        {
            Color.White -> "♙"
            else -> "♟"
        }
        direction = when (c)
        {
            Color.White -> 1
            else -> -1
        }

        possibleMoves = arrayListOf(Point(0,direction), Point(0,2*direction))
        captureMoves = arrayListOf(Point(1,direction), Point(-1,direction))
    }

    override fun canMove(board: Board, start: Square, end: Square): Boolean {
        val colMove = end.col - start.col
        val rowMove = end.row - start.row

        println("Pawn move distance in x:$colMove and y:$rowMove")

        if(end.piece?.color == color)
            return false
        else
            if(captureMoves.contains(Point(colMove,rowMove)))
                return true

        if(possibleMoves.contains(Point(colMove,rowMove))&& end.piece == null){
            if(Point(colMove,rowMove) == Point(0,2*direction))
                possibleMoves.remove(Point(0,2*direction))
            return true
        }

        return false
    }
}


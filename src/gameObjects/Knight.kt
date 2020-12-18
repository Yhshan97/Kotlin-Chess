package gameObjects

import java.awt.Point

class Knight(c: Color) : Piece(c){

    init {
        strIcon = when (c)
        {
            Color.White -> "♘"
            else -> "♞"
        }

        possibleMoves = arrayListOf(
                Point( 1, 2),  Point(-1, 2),  //Top
                Point( 1,-2),  Point(-1,-2),  //Down
                Point(-2, 1),  Point(-2,-1),  //Left
                Point( 2, 1),  Point( 2,-1))  //Right
    }

    override fun canMove(board: Board, start: Square, end: Square): Boolean {
        val colMove = end.col - start.col
        val rowMove = end.row - start.row

        println("Knight move distance in x:$colMove and y:$rowMove")

        // No ally piece at endPoint && move is contained in possible moves
        return super.canMove(board, start, end) && Point(colMove,rowMove) in possibleMoves
    }
}
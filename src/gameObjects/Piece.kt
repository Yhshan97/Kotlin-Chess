package gameObjects

import java.awt.Point

abstract class Piece(c: Color){
    lateinit var strIcon:String
    lateinit var possibleMoves:ArrayList<Point>
    var color = c

    // Pre-check if position has an ally piece
    open fun canMove(board: Board, start:Square, end:Square):Boolean = (end.piece?.color != this.color)

    fun noPieceOnPath(start:Square, end:Square, board:Board, squaresStartToEnd:List<Point>): Boolean {

        for (point in squaresStartToEnd) {
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
                    break
                }
            }
        }
        return false
    }

}

package gameObjects

import java.awt.Point

abstract class Piece(c: Color){
    lateinit var strIcon:String
    lateinit var possibleMoves:ArrayList<Point>
    var color = c


    abstract fun canMove(board: Board, start:Square, end:Square):Boolean
}

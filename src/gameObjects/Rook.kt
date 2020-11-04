package gameObjects

class Rook(c: Color) : Piece(c){

    init {
        strIcon = when (c)
        {
            Color.White -> "♖"
            else -> "♜"
        }
    }
}
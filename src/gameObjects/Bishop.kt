package gameObjects

class Bishop(c: Color) : Piece(c){

    init {
        strIcon = when (c)
        {
            Color.White -> "♗"
            else -> "♝"
        }
    }
}
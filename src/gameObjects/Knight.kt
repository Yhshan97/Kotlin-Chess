package gameObjects

class Knight(c: Color) : Piece(c){

    init {
        strIcon = when (c)
        {
            Color.White -> "♘"
            else -> "♞"
        }
    }
}
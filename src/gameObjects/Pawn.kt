package gameObjects

class Pawn(c: Color) : Piece(c) {

    init {
        strIcon = when (c)
        {
            Color.White -> "♙"
            else -> "♟"
        }
    }
}


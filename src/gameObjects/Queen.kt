package gameObjects

class Queen(c:Color) : Piece(c) {
    init {
        strIcon = when (c)
        {
            Color.White -> "♕"
            else -> "♛"
        }
    }
}
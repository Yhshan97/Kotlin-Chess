package gameObjects

class Queen(color:Color) : Piece() {
    init {
        super.color = color
        super.strIcon = when (color)
        {
            Color.White -> "♕"
            else -> "♛"
        }
    }
}
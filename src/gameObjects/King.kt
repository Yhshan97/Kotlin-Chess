package gameObjects

class King(color:Color) : Piece(){
    init {
        super.color = color
        super.strIcon = when (color)
        {
            Color.White -> "♔"
            else -> "♚"
        }
    }
}
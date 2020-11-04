package gameObjects

class Bishop(color: Color) : Piece(){
    init {
        super.color = color
        super.strIcon = when (color)
        {
            Color.White -> "♗"
            else -> "♝"
        }
    }
}
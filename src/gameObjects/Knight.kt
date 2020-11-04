package gameObjects

class Knight(color: Color) : Piece(){
    init {
        super.color = color
        super.strIcon = when (color)
        {
            Color.White -> "♘"
            else -> "♞"
        }
    }
}
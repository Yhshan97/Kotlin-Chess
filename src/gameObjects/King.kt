package gameObjects

class King(c:Color) : Piece(c){
    init {
        strIcon = when (c)
        {
            Color.White -> "♔"
            else -> "♚"
        }
    }
}
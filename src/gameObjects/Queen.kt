package gameObjects

class Queen(c:Color) : Piece(c) {
    init {
        strIcon = when (c)
        {
            Color.White -> "♕"
            else -> "♛"
        }
    }

    override fun canMove(board: Board, start: Square, end: Square): Boolean {
        TODO("Not yet implemented")
    }
}
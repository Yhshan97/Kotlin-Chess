package gameObjects

class King(c:Color) : Piece(c){
    init {
        strIcon = when (c)
        {
            Color.White -> "♔"
            else -> "♚"
        }
    }

    override fun canMove(board: Board, start: Square, end: Square): Boolean {
        if(!super.canMove(board, start, end)) return false

        val colMove = end.col - start.col
        val rowMove = end.row - start.row


        //TODO("Implement king and rook switch")

        //TODO("verify that he is not in check / other verifications")


        return colMove <= 1 && rowMove <= 1
    }
}
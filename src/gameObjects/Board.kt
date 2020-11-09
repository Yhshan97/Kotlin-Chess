package gameObjects

class Board {
    // Initialize squares with 8x8 of nulls
    var squares: Array<Array<Square>> = Array(8) { Array(8) { Square(0, 0, null) } }
    var capturedWhite: List<Piece> = emptyList()
    var capturedBlack: List<Piece> = emptyList()

    //
    // Initialize the board with default positions
    // Called when a new board is created
    //
    init {
        var template = arrayOf(
                arrayOf(2, 3, 4, 5, 6, 4, 3, 2),
                arrayOf(1, 1, 1, 1, 1, 1, 1, 1),
                arrayOf(0, 0, 0, 0, 0, 0, 0, 0),
                arrayOf(0, 0, 0, 0, 0, 0, 0, 0))

        template += template.reversedArray()    // Mirror one side of the board

        var c = Color.White

        for (row in template.indices) {
            if (row > 3) c = Color.Black

            for (col in template[row].indices) {

                val p = when (template[row][col]) {
                    1 -> Pawn(c)
                    2 -> Rook(c)
                    3 -> Knight(c)
                    4 -> Bishop(c)
                    5 -> Queen(c)
                    6 -> King(c)
                    else -> null
                }

                squares[row][col] = Square(row, col, p)
            }

        }

    }


    //
    // Returns the current board in gameplay text format
    //
    override fun toString(): String {
        var line = ""
        val end = "  Ⓐ Ⓑ Ⓒ Ⓓ Ⓔ Ⓕ Ⓖ Ⓗ"

        var captWhiteCopy: List<Piece> = capturedWhite.toList()
        var captBlackCopy: List<Piece> = capturedBlack.toList()

        // Start from Top to Bottom
        for (row in 8 downTo 1) {
            line += "$row "

            // This is still Left to Right
            for (col in 0..7) {
                val p = squares[row - 1][col].piece?.strIcon

                // Display Icon if available or empty square whose color depend on the square's position
                line += (p ?: if ((row + col) % 2 != 0) "■" else "□") + " "
            }

            line += "| "
            repeat(2) {
                if (captWhiteCopy.isNotEmpty()) {
                    line += captWhiteCopy[0].strIcon
                    captWhiteCopy = captWhiteCopy.drop(1)
                } else line += "  "
            }

            line += " | "
            repeat(2) {
                if (captBlackCopy.isNotEmpty()) {
                    line += captBlackCopy[0].strIcon
                    captBlackCopy = captBlackCopy.drop(1)
                } else line += "  "
            }

            line += "\n"
        }

        return line + end
    }

    fun addCaptured(piece: Piece?) {
        if (piece?.color == Color.White)
            capturedWhite = capturedWhite.plus(piece)
        else if (piece?.color == Color.Black)
            capturedBlack = capturedBlack.plus(piece)

    }
}
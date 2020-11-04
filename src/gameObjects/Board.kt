package gameObjects

class Board {
    // Initialize squares with 8x8 of nulls
    var squares: Array<Array<Square>> = Array(8) { Array(8) { Square(0, 0, null) } }


    //
    // Initialize the board with default positions
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
    // Returns the current board in text format
    //
    override fun toString(): String {
        var line = ""
        val end = "  Ⓐ Ⓑ Ⓒ Ⓓ Ⓔ Ⓕ Ⓖ Ⓗ"

        // Start from Top to Bottom
        for (row in 8 downTo 1) {
            line += "$row "

            // This is still Left to Right
            for (col in 0..7) {
                val p = squares[row - 1][col].piece

                // Display Icon if available or empty square whose color depend on the square's position
                line += (p?.toString() ?: if ((row + col) % 2 != 0) "■" else "□") + " "
            }

            line += "\n"
        }

        return line + end
    }
}
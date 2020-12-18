import gameObjects.Board
import gameObjects.Color
import java.awt.Point
import java.util.*

const val alphabet = "abcdefghijklmnopqrstuvwxyz"

fun main() {
    val b = Board()                 // Board object
    val inp = Scanner(System.`in`)  // Scanner obj for user input
    var turn = Color.White            // White side starts first


    println("Game start: White is on bottom and black is on top")

    do {
        //println("clear")
        println("\n" + b.toString())
        println("It is ${ when (turn) {
                Color.White -> "white's"
                else -> "black's"
            }} turn to play. \nEnter a move (ex:b2 b3): ")

        val input = inp.nextLine()
        val moves = input.split(" ")
        val startPoint = textToPoint(moves[0])
        val endPoint = textToPoint(moves[1])


        // If coordinates are within the board boundaries
        if (startPoint.x in 0..7 && startPoint.y in 0..7 && endPoint.x in 0..7 && endPoint.y in 0..7) {

            val startSquare = b.squares[startPoint.x][startPoint.y]
            val endSquare = b.squares[endPoint.x][endPoint.y]

            if (startSquare.piece?.color == turn) {

                // Multiple verifications on if the piece is able to move to endSquare
                val moveIsValid = startSquare.piece?.canMove(b, startSquare, endSquare)

                // debug text
                println("Move from (${startSquare.col},${startSquare.row}) to (${endSquare.col},${endSquare.row}) ")
                println("Can ${startSquare.piece?.strIcon} move?: ${moveIsValid!!}")

                if (moveIsValid) {
                    b.addCaptured(endSquare.piece)
                    endSquare.piece = startSquare.piece
                    startSquare.piece = null
                }

                // Change player at the end of successful turn
                turn = turn.switch()
            } else {
                println("It is not your turn to play.")
            }
        } else {
            println("Input out of bounds, please try again.")
        }

    } while (input != "q")

}

fun textToPoint(s: String): Point {
    val colStart = alphabet.indexOf(s[0])                // 'b'->1
    val rowStart = Character.getNumericValue(s[1]) - 1   // '2'->2-1 (array starts at 0)

    return Point(rowStart, colStart)
}

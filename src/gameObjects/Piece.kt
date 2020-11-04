package gameObjects

open class Piece(c: Color){
    lateinit var strIcon:String
    var color = c

    override fun toString(): String = strIcon
}

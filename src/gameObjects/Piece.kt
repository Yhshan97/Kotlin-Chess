package gameObjects

open class Piece (){
    lateinit var strIcon:String
    lateinit var color:Color

    override fun toString(): String {
        return strIcon
    }
}

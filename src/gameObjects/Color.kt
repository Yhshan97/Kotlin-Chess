package gameObjects

enum class Color(val color : Int) {
    White(0),
    Black(1);

    fun switch():Color{
        return when(this) { White -> Black else -> White}
    }
}
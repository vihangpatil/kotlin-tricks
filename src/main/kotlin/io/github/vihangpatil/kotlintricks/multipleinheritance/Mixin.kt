package io.github.vihangpatil.kotlintricks.multipleinheritance

//
// Interfaces
//
interface Color {
    fun getColorName(): String
}

interface Shape {
    fun getShapeName(): String
}

//
// Implementations
//
class Red : Color {
    override fun getColorName(): String = "Red"
}

object Blue : Color {
    override fun getColorName(): String = "Blue"
}


class Circle : Shape {
    override fun getShapeName(): String = "Circle"
}

object Square : Shape {
    override fun getShapeName(): String = "Square"
}

//
// Mixin's
//

/**
 * Here `RedCircle` is re-using `getColorName()` from `Red`, and `getShapeName()` from `Circle`.
 */
object RedCircle : Color by Red(), Shape by Circle() // using classes

object BlueSquare : Color by Blue, Shape by Square // using singleton objects

fun main(args: Array<String>) {

    println("I am ${RedCircle.getColorName()} ${RedCircle.getShapeName()}") // I am Red Circle

    println("I am ${BlueSquare.getColorName()} ${BlueSquare.getShapeName()}") // I am Blue Square

    println("I am ${RedSquare.getColorName()} ${RedSquare.getShapeName()}") // I am Red Square
}

/**
 * This is verbose edition of Mixin, if it was done in Java.
 */
object RedSquare : Color, Shape {

    private val red = Red()

    override fun getColorName(): String {
        return red.getColorName()
    }

    override fun getShapeName(): String {
        return Square.getShapeName()
    }
}
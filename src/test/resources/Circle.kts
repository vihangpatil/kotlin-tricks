import io.github.vihangpatil.kotlintricks.ktsengine.Shape

/**
  The last line of this script should be object of type [Shape].
  So, directly have an anonymous object implement [Shape].
  Or have a class such as `Circle` implement [Shape] and then have last line to be object of `Circle`
*/

object : Shape {
    override fun getArea(): Int {
        return 47
    }
}
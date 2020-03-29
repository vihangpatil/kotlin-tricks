package io.github.vihangpatil.kotlintricks.ktsengine

import io.github.vihangpatil.kotlintricks.ktsengine.engine.KtsServiceFactory
import io.github.vihangpatil.kotlintricks.ktsengine.reader.ClasspathResourceTextReader
import javax.script.ScriptEngineManager
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

interface Shape {
    fun getArea(): Int
}

class KtsEngineTest {

    @Test
    fun test() {

        assertNotNull(ScriptEngineManager().getEngineByExtension("kts"))

        val shape = KtsServiceFactory(
                serviceInterface = "io.github.vihangpatil.kotlintricks.ktsengine.Shape",
                textReader = ClasspathResourceTextReader(filename = "/Circle.kts") // from `src/test/resources`
        ).getKtsService<Shape>()

        assertEquals(expected = 47, actual = shape.getArea())
    }
}
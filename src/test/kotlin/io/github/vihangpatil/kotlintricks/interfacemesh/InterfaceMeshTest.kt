package io.github.vihangpatil.kotlintricks.interfacemesh

import io.github.vihangpatil.kotlintricks.interfacemesh.consumers.ConsumerA
import io.github.vihangpatil.kotlintricks.interfacemesh.consumers.ConsumerB
import io.github.vihangpatil.kotlintricks.interfacemesh.wiring.ConsumeA
import io.github.vihangpatil.kotlintricks.interfacemesh.wiring.ConsumeB
import kotlin.test.Test
import kotlin.test.assertEquals

class InterfaceMeshTest {

    @Test
    fun test() {

        // TODO use dependency injection instead of directly referring to implementations.
        val consumeA: ConsumerA = ConsumeA()
        val consumeB: ConsumerB = ConsumeB()

        assertEquals(expected = "A1", actual = consumeA.methodA1())
        assertEquals(expected = "A2", actual = consumeA.methodA2())

        assertEquals(expected = "B1", actual = consumeB.methodB1())
        assertEquals(expected = "B2", actual = consumeB.methodB2())
    }
}
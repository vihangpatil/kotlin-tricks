package io.github.vihangpatil.kotlintricks.interfacemesh.consumers

import io.github.vihangpatil.kotlintricks.interfacemesh.wiring.ConsumeA
import io.github.vihangpatil.kotlintricks.interfacemesh.wiring.ConsumeB

fun main() {

    // TODO use dependency injection instead of directly referring to implementations.
    val consumeA: ConsumerA = ConsumeA()
    val consumeB: ConsumerB = ConsumeB()

    consumeA.methodA1()
    consumeA.methodA2()

    consumeB.methodB1()
    consumeB.methodB2()
}
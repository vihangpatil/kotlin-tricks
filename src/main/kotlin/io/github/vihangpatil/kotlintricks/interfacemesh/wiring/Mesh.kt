package io.github.vihangpatil.kotlintricks.interfacemesh.wiring

import io.github.vihangpatil.kotlintricks.interfacemesh.consumers.ConsumerA
import io.github.vihangpatil.kotlintricks.interfacemesh.consumers.ConsumerB
import io.github.vihangpatil.kotlintricks.interfacemesh.providers.Provide1
import io.github.vihangpatil.kotlintricks.interfacemesh.providers.Provide2
import io.github.vihangpatil.kotlintricks.interfacemesh.providers.Provider1
import io.github.vihangpatil.kotlintricks.interfacemesh.providers.Provider2

//
// Mesh Links
//

interface A1 {
    fun methodA1(): String
}

interface A2 {
    fun methodA2(): String
}

interface B1 {
    fun methodB1(): String
}

interface B2 {
    fun methodB2(): String
}

//
// Wiring Consumers
//

// TODO use dependency injection instead of directly referring to implementations.
val provider1: Provider1 = Provide1()
val provider2: Provider2 = Provide2()

class ConsumeA : ConsumerA,
        A1 by provider1,
        A2 by provider2

class ConsumeB : ConsumerB,
        B1 by provider1,
        B2 by provider2


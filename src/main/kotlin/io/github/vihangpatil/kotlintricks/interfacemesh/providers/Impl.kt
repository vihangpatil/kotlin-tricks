package io.github.vihangpatil.kotlintricks.interfacemesh.providers

//
// Provider
//

// Implement all Ones
class Provide1 : Provider1 {

    override fun methodA1() = "A1"

    override fun methodB1()  = "B1"
}

// Implement all Twos
class Provide2 : Provider2 {

    override fun methodA2() = "A2"

    override fun methodB2() = "B2"
}
package io.github.vihangpatil.kotlintricks.interfacemesh.providers

//
// Provider
//

// Implement all Ones
class Provide1 : Provider1 {

    override fun methodA1() {
        println("A1")
    }

    override fun methodB1() {
        println("B1")
    }
}

// Implement all Twos
class Provide2 : Provider2 {

    override fun methodA2() {
        println("A2")
    }

    override fun methodB2() {
        println("B2")
    }
}
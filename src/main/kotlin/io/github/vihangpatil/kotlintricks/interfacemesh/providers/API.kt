package io.github.vihangpatil.kotlintricks.interfacemesh.providers

import io.github.vihangpatil.kotlintricks.interfacemesh.wiring.A1
import io.github.vihangpatil.kotlintricks.interfacemesh.wiring.A2
import io.github.vihangpatil.kotlintricks.interfacemesh.wiring.B1
import io.github.vihangpatil.kotlintricks.interfacemesh.wiring.B2

//
// Provider Interfaces
//

// Ones
interface Provider1 : A1, B1

// Twos
interface Provider2 : A2, B2
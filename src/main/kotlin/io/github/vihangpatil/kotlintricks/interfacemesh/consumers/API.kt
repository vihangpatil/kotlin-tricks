package io.github.vihangpatil.kotlintricks.interfacemesh.consumers

import io.github.vihangpatil.kotlintricks.interfacemesh.wiring.A1
import io.github.vihangpatil.kotlintricks.interfacemesh.wiring.A2
import io.github.vihangpatil.kotlintricks.interfacemesh.wiring.B1
import io.github.vihangpatil.kotlintricks.interfacemesh.wiring.B2

//
// Consumer Interfaces
//

// A's
interface ConsumerA : A1, A2

// B's
interface ConsumerB : B1, B2

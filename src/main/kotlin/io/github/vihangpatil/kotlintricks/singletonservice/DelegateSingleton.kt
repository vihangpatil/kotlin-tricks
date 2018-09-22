package io.github.vihangpatil.kotlintricks.singletonservice

import java.util.*

interface Service {
    fun doSomething()
}

object ServiceProviderSingleton : Service {
    override fun doSomething() {
        println("Doing something")
    }
}

class ServiceProvider : Service by ServiceProviderSingleton

fun main(args: Array<String>) {

    // Note: check the file in `src/main/resources/META-INF/services`.

    // ServiceProvider should print - Doing something
    // Tyring to do same on ServiceProviderSingleton would throw exception.
    ServiceLoader
            .load(Service::class.java)
            .forEach { it.doSomething() }
}
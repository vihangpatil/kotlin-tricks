package io.github.vihangpatil.kotlintricks.logger

import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * Here I'm using Kotlin's support for extending a class by adding extension functions.
 * Ref: https://kotlinlang.org/docs/reference/extensions.html
 *
 * This is a generic slf4j logger factory method using simple kotlin extension.
 * Simply calling createLogger() will create a logger using the class from where it is called.
 * @see {@link LazyDelegateKt} for similar method, but using lazy delegate along with extension.
 */
private fun <R : Any> R.createLogger(): Logger =
        LoggerFactory.getLogger(this::class.java)

class Foo {
    private val logger = createLogger()

    fun print() {
        logger.info("I am Foo")
    }
}

object Bar {
    private val logger = createLogger()

    fun print() {
        logger.info("I am Bar")
    }
}

fun main(args: Array<String>) {
    Foo().print()
    Bar.print()
}
package io.github.vihangpatil.kotlintricks.logger

import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * Here I'm using Kotlin's support for property delegates and extension functions.
 * Ref: https://kotlinlang.org/docs/reference/delegated-properties.html
 * Ref: https://kotlinlang.org/docs/reference/extensions.html
 *
 * This is a lazy delegate slf4j logger factory method using kotlin's property delegates and extension functions.
 */
private fun <R : Any> R.createLogger(): Lazy<Logger> = lazy {
    LoggerFactory.getLogger(this::class.java)
}

class Bizz {
    private val logger by createLogger()

    fun print() {
        logger.info("I am Bizz")
    }
}

object Buzz {
    private val logger by createLogger()

    fun print() {
        logger.info("I am Buzz")
    }
}

fun main(args: Array<String>) {
    Bizz().print()
    Buzz.print()
}
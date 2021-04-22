package io.github.vihangpatil.kotlintricks.coroutines

object CoroutineThrowable {

    private val coroutinePackages = listOf("kotlin.coroutines", "kotlinx.coroutines")

    fun filterStackTrace(e: Throwable) {
        e.stackTrace = e.stackTrace.filterNot { stackTraceElement ->
            coroutinePackages.any { stackTraceElement.className.startsWith(it) }
        }.toTypedArray()

        // recursively do the same for 'cause by' throwable
        e.cause?.let(::filterStackTrace)
    }
}
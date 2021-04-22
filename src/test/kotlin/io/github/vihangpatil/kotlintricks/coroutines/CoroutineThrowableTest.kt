package io.github.vihangpatil.kotlintricks.coroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlin.test.Test

suspend fun withLaunch() {
    coroutineScope {
        launch {
            withAsync()
        }
    }
}

suspend fun withAsync() {
    coroutineScope {
        val result = async {
            withContext()
        }
        result.await()
    }
}

suspend fun withContext() {
    withContext(Dispatchers.Default) {
        throw Exception()
    }
}

class CoroutineThrowableTest {

    @Test
    fun test() {

        runBlocking {
            try {
                withLaunch()
            } catch (e: Exception) {
                println("Original stacktrace")
                e.printStackTrace()
                CoroutineThrowable.filterStackTrace(e)
                println("Processed stacktrace")
                e.printStackTrace()
            }
        }
    }
}
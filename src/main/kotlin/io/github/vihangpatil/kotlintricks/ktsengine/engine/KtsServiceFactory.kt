package io.github.vihangpatil.kotlintricks.ktsengine.engine

import io.github.vihangpatil.kotlintricks.ktsengine.reader.TextReader

class KtsServiceFactory(
        private val serviceInterface: String,
        private val textReader: TextReader) {

    fun <T> getKtsService(): T = KtScriptProxy.newInstance(Class.forName(serviceInterface), textReader) as T
}
package io.github.vihangpatil.kotlintricks.ktsengine.script

import javax.script.ScriptEngineManager

/**
 * Run Kotlin Script as it is.
 */
class RunnableKotlinScript(private val scriptText: String) {

    private val scriptEngine = ScriptEngineManager().getEngineByExtension("kts")

    fun <T> eval(): T? {
        return scriptEngine.eval(scriptText) as T?
    }
}
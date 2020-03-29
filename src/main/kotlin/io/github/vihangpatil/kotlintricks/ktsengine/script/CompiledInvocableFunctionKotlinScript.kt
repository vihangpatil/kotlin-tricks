package io.github.vihangpatil.kotlintricks.ktsengine.script

import org.jetbrains.kotlin.script.jsr223.KotlinJsr223JvmLocalScriptEngine
import javax.script.CompiledScript
import javax.script.Invocable
import javax.script.ScriptEngineManager

/**
 * Compile and invoke a function defined in the Kotlin script
 */
class CompiledInvocableFunctionKotlinScript(private val scriptText: String) {

    private var compiledScript: CompiledScript =
            (ScriptEngineManager().getEngineByExtension("kts") as KotlinJsr223JvmLocalScriptEngine)
                    .apply {
                        eval(scriptText)
                    }
                    .compile(scriptText)

    fun <T> invoke(function: String, vararg args: Any): T {
        return (compiledScript.engine as Invocable).invokeFunction(function, *args) as T
    }
}
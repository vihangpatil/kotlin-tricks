package io.github.vihangpatil.kotlintricks.ktsengine.script

import org.jetbrains.kotlin.script.jsr223.KotlinJsr223JvmLocalScriptEngine
import javax.script.CompiledScript
import javax.script.Invocable
import javax.script.ScriptEngineManager

/**
 * Compile and invoke a method belonging to a class / object.
 */
class CompiledInvocableMethodKotlinScript(private val scriptText: String) {

    private var obj: Any? = null

    private var compiledScript: CompiledScript =
            (ScriptEngineManager().getEngineByExtension("kts") as KotlinJsr223JvmLocalScriptEngine)
                    .apply {
                        obj = eval(scriptText)
                    }
                    .compile(scriptText)

    fun <T> invoke(method: String, vararg args: Any): T {
        return (compiledScript.engine as Invocable).invokeMethod(obj, method, *args) as T
    }
}
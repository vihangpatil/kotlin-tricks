package io.github.vihangpatil.kotlintricks.apachebeam

import io.github.vihangpatil.kotlintricks.apachebeam.ParDoFn.transform
import org.apache.beam.sdk.transforms.DoFn
import org.apache.beam.sdk.transforms.ParDo

/**
 * Here I'm using Kotlin's support for custom DSL definition.
 * Ref: https://kotlinlang.org/docs/reference/type-safe-builders.html
 *
 * This DSL wraps a complicated Parallel-Do-Function into a simple transform DSL which take a lambda as parameter.
 * This lambda maps InputT to OutputT.
 */
object ParDoFn {
    fun <InputT, OutputT> transform(process: (input: InputT) -> OutputT): ParDo.SingleOutput<InputT, OutputT> {
        return ParDo.of(object : DoFn<InputT, OutputT>() {
            @ProcessElement
            fun processElement(c: ProcessContext) {
                c.output(process(c.element()))
            }
        })
    }
}

/**
 * Using this transform hides the complicated Apache Beam code.
 * @see {@link DSLTest} for its use in a Test Pipeline.
 */
val stringLengthFunction = transform<String, Int> { it.length }
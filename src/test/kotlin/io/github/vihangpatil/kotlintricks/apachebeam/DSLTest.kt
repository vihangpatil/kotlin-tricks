package io.github.vihangpatil.kotlintricks.apachebeam

import org.apache.beam.sdk.coders.StringUtf8Coder
import org.apache.beam.sdk.coders.TextualIntegerCoder
import org.apache.beam.sdk.testing.PAssert
import org.apache.beam.sdk.testing.TestPipeline
import org.apache.beam.sdk.testing.TestStream
import org.junit.Ignore
import org.junit.Rule
import org.junit.Test

class DSLTest {

    @Rule
    @JvmField
    val pipeline = TestPipeline.create()

    @Test
    @Ignore("Works only on JVM 8")
    fun testDSL() {

        val testStream: TestStream<String> =
                TestStream.create(StringUtf8Coder.of())
                        .addElements("Hi", "Hello", "Bye")
                        .advanceWatermarkToInfinity()



        val result = pipeline
                .apply(testStream)
                .apply(stringLengthFunction)
                .setCoder(TextualIntegerCoder.of())

        PAssert.that(result)
                .containsInAnyOrder(2, 5, 3)

        pipeline.run()
                .waitUntilFinish()
    }
}
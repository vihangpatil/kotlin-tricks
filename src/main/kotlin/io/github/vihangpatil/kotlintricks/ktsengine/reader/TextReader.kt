package io.github.vihangpatil.kotlintricks.ktsengine.reader

sealed class TextReader {
    abstract fun readText(): String
}

/**
 * Reads text contents of a class path resource.
 */
class ClasspathResourceTextReader(private val filename: String) : TextReader() {
    override fun readText(): String = {}.javaClass.getResource(filename).readText()
}

/**
 * Reads text contents of a file.
 */
class FileTextReader(private val filename: String) : TextReader() {
    override fun readText() = java.io.FileReader(filename).readText()
}
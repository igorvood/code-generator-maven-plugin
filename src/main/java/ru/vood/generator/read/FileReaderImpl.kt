package ru.vood.generator.read

import java.io.File
import java.util.*

class FileReaderImpl : FileReader {

    override fun readFile(path: String): String {
        val sb = StringBuilder(getResourceUrl(path))
        return sb.toString()
    }

    private fun getResourceUrl(filename: String): String {
        val resource = javaClass.classLoader.getResource(filename)
        Objects.requireNonNull(resource, "file $filename is not found!")
        val file = File(resource.path)
        if (!file.exists()) throw IllegalStateException("file ${file.absolutePath} not found")
        return file.readText()
    }

}
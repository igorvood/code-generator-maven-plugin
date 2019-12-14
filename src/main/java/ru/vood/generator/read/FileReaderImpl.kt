package ru.vood.generator.read

import java.util.*

class FileReaderImpl : FileReader {

    override fun readFile(path: String): String {
        val sb = StringBuilder(getResource(path))
        return sb.toString()
    }

    private fun getResource(filename: String): String {
        val resource = javaClass.classLoader.getResource(filename)
        Objects.requireNonNull(resource, "file is not found!")
        return resource.file
    }

}
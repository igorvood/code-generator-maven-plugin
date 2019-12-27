package ru.vood.generator.read

import java.io.File
import java.util.*

class FileReaderImpl : FileReader {

    override fun readFile(fileName: String): String {
        val resource = javaClass.classLoader.getResource(fileName)
        Objects.requireNonNull(resource, "file $fileName is not found!")
        val file = File(resource.path)
        if (!file.exists()) {
            throw IllegalStateException("file ${file.absolutePath} not found")
        } else return file.readText()

    }

}
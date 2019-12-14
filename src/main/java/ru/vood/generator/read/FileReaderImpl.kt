package ru.vood.generator.read

import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Paths

class FileReaderImpl : FileReader {
    override fun readFile(path: String): String {
        val sb = StringBuilder()
        Files.lines(Paths.get(path), StandardCharsets.UTF_8)
                .forEach { str: String -> sb.append(str) }
        return sb.toString()
    }
}
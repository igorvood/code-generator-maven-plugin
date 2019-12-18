package ru.vood.generator.read

interface FileReader {

    fun readFile(path: String): String
}
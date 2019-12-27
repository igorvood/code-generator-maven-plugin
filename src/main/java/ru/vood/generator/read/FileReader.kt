package ru.vood.generator.read

interface FileReader {

    fun readFile(fileName: String): String
}
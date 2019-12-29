package ru.vood.generator.generate.resolve

interface FileNameResolver {

    fun resolveFileByContent(typeFile: TypeFile, text: String): FilePropertyDto
}
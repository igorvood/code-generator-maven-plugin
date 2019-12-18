package ru.vood.generator.generate.resolve

interface FileNameResolver {

    fun resolveFileByContent(text: String): FileProperty
}
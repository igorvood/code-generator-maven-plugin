package ru.vood.generator.generate.resolve

class FileNameResolverException(s: String) : RuntimeException(s) {
    override val message: String
        get() = super.message!!
}
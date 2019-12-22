package ru.vood.generator.read.dto

data class GenerateParamDto(
        var templateEngine: TemplateEngine?
        , var templateFile: String?
        , var classSeparator: String?
) {
    constructor() : this(null, null, null)
}
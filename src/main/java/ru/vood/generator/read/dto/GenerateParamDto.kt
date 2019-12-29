package ru.vood.generator.read.dto

import ru.vood.generator.generate.runner.TemplateEngine

data class GenerateParamDto(
        var templateEngine: TemplateEngine
        , var templateFile: String
        , var classSeparator: String
) {
    constructor() : this(TemplateEngine.ERROR, "ERROR FILE", "ERROR SEPARATOR")
}
package ru.vood.generator.read.dto

import ru.vood.generator.generate.runner.TemplateEngine

data class GenerateParamDto(
        var templateEngine: TemplateEngine
        , var classType: TypeClass
        , var templateFile: String
        , var templateParamFile: String
        , var classSeparator: String
) {
    constructor() : this(TemplateEngine.ERROR, TypeClass.KOTLIN, "ERROR TEMPLATE FILE", "ERROR TEMPLATE PARAMETER FILE", "ERROR SEPARATOR")
}
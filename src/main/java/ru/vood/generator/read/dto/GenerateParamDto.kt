package ru.vood.generator.read.dto

import ru.vood.generator.generate.runner.TemplateEngine

data class GenerateParamDto(
        var templateEngine: TemplateEngine
        , var classType: TypeClass
        , var classSeparator: String
        , var templateParamFilesDto: List<ParamForTemplateFilesDto>
) {
    constructor() : this(TemplateEngine.ERROR, TypeClass.KOTLIN, "ERROR TEMPLATE PARAMETER FILE", arrayListOf<ParamForTemplateFilesDto>(ParamForTemplateFilesDto()))
}
package ru.vood.generator.generate

import ru.vood.generator.generate.runner.TemplateEngine
import ru.vood.generator.read.dto.ParamForTemplateFilesDto
import ru.vood.generator.read.dto.TemplateParamDto
import ru.vood.generator.read.dto.TypeClass

data class GenerateParamWithYamlDto(
        var templateEngine: TemplateEngine
        , var classType: TypeClass
        , var classSeparator: String
        , var templateParamFileFilesDto: ParamForTemplateFilesDto
        , val templateParam: TemplateParamDto
) {

//    var templateEngine: TemplateEngine
//    , var classType: TypeClass
//    , var classSeparator: String
//    , var templateParam: List<ParamForTemplate>


//    constructor() : this(GenerateParamDto(), TemplateParamDto())
}
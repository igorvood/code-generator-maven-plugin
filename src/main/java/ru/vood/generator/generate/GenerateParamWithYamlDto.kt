package ru.vood.generator.generate

import ru.vood.generator.read.dto.GenerateParamDto
import ru.vood.generator.read.dto.TemplateParamDto

data class GenerateParamWithYamlDto(val generateParam: GenerateParamDto, val templateParam: TemplateParamDto) {

//    constructor() : this(GenerateParamDto(), TemplateParamDto())
}
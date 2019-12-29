package ru.vood.generator.generate.runner

import ru.vood.generator.read.dto.TemplateParamDto

interface RunnerEngine {
    fun generateText(param: TemplateParamDto): String
}

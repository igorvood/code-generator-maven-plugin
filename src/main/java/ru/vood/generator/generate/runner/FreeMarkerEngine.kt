package ru.vood.generator.generate.runner

import ru.vood.freemarker.FtlProcessor
import ru.vood.generator.read.dto.TemplateParamDto
import java.io.File

class FreeMarkerEngine(val ftlProcessor: FtlProcessor) : RunnerEngine {

    override fun generateText(param: TemplateParamDto, templateFile: File): String {
        try {
            return ftlProcessor.processFile(templateFile, arrayOf<Any?>(param))
        } catch (e: Exception) {
            throw IllegalStateException("Error process template file ${templateFile.absolutePath} with param\n $param")
        }
    }
}
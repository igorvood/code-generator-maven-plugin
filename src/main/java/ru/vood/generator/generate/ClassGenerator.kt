package ru.vood.generator.generate

import ru.vood.generator.file.FileReaderImpl
import ru.vood.generator.file.getCanonicalPath
import ru.vood.generator.read.YamlReader
import ru.vood.generator.read.dto.PluginParamDto
import ru.vood.generator.read.dto.TemplateParamDto
import sun.plugin.dom.exception.InvalidStateException
import java.io.File
import kotlin.streams.toList

class ClassGenerator(val pluginPropertyYamlFile: String) {

    fun generate() {
        val genParam = getGenParam(pluginPropertyYamlFile)
        val textFiles = generateTextFiles(genParam)
        println(textFiles.size)
    }


    fun generateTextFiles(param: List<GenerateParamWithYamlDto>): List<Pair<GenerateParamWithYamlDto, String>> {
        return param.stream()
                .map { genrateText(it) }
                .peek { println(it.second) }
                .toList()
    }

    fun genrateText(p: GenerateParamWithYamlDto) =
            try {
                val file = File(p.generateParam.templateFile)
                if (!file.exists()) throw InvalidStateException("File '${p.generateParam.templateFile}' does no exits")
                Pair(p, p.generateParam.templateEngine.runner.generateText(p.templateParam, file))
            } catch (e: Exception) {
                throw IllegalStateException("Can not generate text for engine ${p.generateParam.templateEngine} file ${p.generateParam.templateFile}")
            }


    fun getGenParam(pluginPropertyYamlFile: String): List<GenerateParamWithYamlDto> {
        val fileReader = FileReaderImpl()
        val yamlReader = YamlReader(PluginParamDto::class.java, fileReader)
        val pluginParam = yamlReader.readTune(getCanonicalPath(File(pluginPropertyYamlFile)))


        val yamlTemplateParamDto = YamlReader(TemplateParamDto::class.java, fileReader)
        return pluginParam.generateParamDto.stream()
                .map { GenerateParamWithYamlDto(it, yamlTemplateParamDto.readTune(it.templateFile)) }
                .toList()
    }

}
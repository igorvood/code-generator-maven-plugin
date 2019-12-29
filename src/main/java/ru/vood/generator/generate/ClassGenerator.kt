package ru.vood.generator.generate

import ru.vood.generator.file.FileReaderImpl
import ru.vood.generator.file.getCanonicalPath
import ru.vood.generator.file.resolve.FileNameResolverImpl
import ru.vood.generator.file.resolve.FilePropertyDto
import ru.vood.generator.read.YamlReader
import ru.vood.generator.read.dto.PluginParamDto
import ru.vood.generator.read.dto.TemplateParamDto
import sun.plugin.dom.exception.InvalidStateException
import java.io.File
import java.util.*
import java.util.stream.Collectors
import kotlin.streams.toList


class ClassGenerator(val pluginPropertyYamlFile: String) {

    fun generate() {
        val genParam = getGenParam(pluginPropertyYamlFile)
        val textFiles = generateTextFiles(genParam)
        val fileNameResolver = FileNameResolverImpl()
        val files: List<Triple<GenerateParamWithYamlDto, String, FilePropertyDto>> = textFiles.stream()
                .map { p ->
                    p.second.split(p.first.classSeparator).stream()
                            .map { Triple(p.first, it, fileNameResolver.resolveFileByContent(p.first.classType, it)) }
                }
                .flatMap { it }
                .toList()
        val allItems = HashSet<FilePropertyDto>()

        val dublicate = files.stream()
                .filter { !allItems.add(it.third) }
                .map { Triple(it.first.templateParamFileFilesDto.templateFile, it.first.templateParamFileFilesDto.templateParamFile, it.third) }
                .collect(Collectors.toSet())
        if (dublicate.size > 0)
            throw IllegalStateException("Duplicate is found $dublicate")

        println(textFiles.size)
    }


    fun generateTextFiles(param: List<GenerateParamWithYamlDto>): List<Pair<GenerateParamWithYamlDto, String>> {
        return param.stream()
                .map { genrateText(it) }
//                .peek { println(it.second) }
                .toList()
    }

    fun genrateText(p: GenerateParamWithYamlDto): Pair<GenerateParamWithYamlDto, String> {
        val templateFile = p.templateParamFileFilesDto.templateFile
        val templateEngine = p.templateEngine

        try {
            val file = File(templateFile)
            if (!file.exists()) throw InvalidStateException("File '${templateFile}' does no exits")

            return Pair(p, templateEngine.runner.generateText(p.templateParam, file))
        } catch (e: Exception) {
            throw IllegalStateException("Can not generate text for engine $templateEngine file $templateFile")
        }
    }


    fun getGenParam(pluginPropertyYamlFile: String): List<GenerateParamWithYamlDto> {
        val fileReader = FileReaderImpl()
        val yamlReader = YamlReader(PluginParamDto::class.java, fileReader)
        val pluginParam = yamlReader.readTune(getCanonicalPath(File(pluginPropertyYamlFile)))
        val yamlTemplateParamDto = YamlReader(TemplateParamDto::class.java, fileReader)

        val toList = pluginParam.generateParamDto.stream()
                .map { p ->
                    p.templateParamFilesDto.stream()
                            .map {
                                GenerateParamWithYamlDto(
                                        p.templateEngine,
                                        p.classType,
                                        p.classSeparator,
                                        it,
                                        yamlTemplateParamDto.readTune(it.templateParamFile))
                            }
                }
                .flatMap { it }
                .toList()
        return toList
    }

}
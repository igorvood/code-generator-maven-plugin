package ru.vood.generator.read

import org.yaml.snakeyaml.Yaml
import org.yaml.snakeyaml.constructor.Constructor
import ru.vood.generator.read.dto.KeyValDto
import ru.vood.generator.read.dto.TemplateParamDto
import java.io.File


class YamlReader<T>(private val clazz: Class<T>
                    , private val fileReader: FileReader) : TuneReader<T> {

    private val yaml = Yaml(Constructor(clazz))

    override fun readTune(fileName: String): T {
        val readFile = fileReader.readFile(fileName)
        return try {
            yaml.load<T>(readFile)
        } catch (e: Exception) {
            throw IllegalStateException(
                    "The file format is not as expected. Example:\n${yaml.dump(yamlParamTemplateDto())}"
                    , e)
        }
    }

    override fun saveTune(pluginTune: T, file: File) {
        val text = yaml.dump(pluginTune)
        file.writeText(text)
    }

    private fun yamlParamTemplateDto(): TemplateParamDto {
        val yamlDto = TemplateParamDto()
        val listOf = listOf(KeyValDto("key1", "val2"), KeyValDto("key3", "val4"))
        yamlDto.map = listOf
        yamlDto.multiMaps = listOf(KeyValDto("key10", listOf(KeyValDto("key100", "val200"), KeyValDto("key300", "val400"))))
        return yamlDto
    }

}
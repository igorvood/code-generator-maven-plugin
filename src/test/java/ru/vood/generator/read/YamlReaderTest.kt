package ru.vood.generator.read

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.containsInAnyOrder
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import ru.vood.generator.read.dto.KeyValDto
import ru.vood.generator.read.dto.YamlParamTemplateDto
import java.io.File

internal class YamlReaderTest {

    lateinit var yamlReader: YamlReader<YamlParamTemplateDto>

    @BeforeEach
    fun setUp() {
        yamlReader = YamlReader(YamlParamTemplateDto::class.java, FileReaderImpl())
    }

    @Test
    fun readTune() {
        val yamlDto = yamlParamTemplateDto()

        val readTune = yamlReader.readTune("ru/vood/generator/read/YamlReaderTest/test1.yaml")
        val readYamlDto = readTune.map

        assertThat(yamlDto.map, containsInAnyOrder<KeyValDto<String>>(*readYamlDto!!.toTypedArray()))
    }

    @Test
    fun readTuneError() {
        try {
            yamlReader.readTune("ru/vood/generator/read/YamlReaderTest/test_error.yaml")
            Assertions.fail<String>("Test Fail")
        } catch (e: Exception) {
            Assertions.assertTrue(e.message!!.contains("The file format is not as expected. Example:"))
        }
    }


    @Test
    fun saveTune() {
        val yamlDto = yamlParamTemplateDto()
        val file = File("asd")
        yamlReader.saveTune(yamlDto, file)
        file.delete()
    }

    private fun yamlParamTemplateDto(): YamlParamTemplateDto {
        val yamlDto = YamlParamTemplateDto()
        val listOf = listOf(KeyValDto("1", "2"), KeyValDto("3", "4"))
        yamlDto.map = listOf
        yamlDto.multiMaps = listOf(KeyValDto("10", listOf(KeyValDto("100", "200"), KeyValDto("300", "400"))))
        return yamlDto
    }

}
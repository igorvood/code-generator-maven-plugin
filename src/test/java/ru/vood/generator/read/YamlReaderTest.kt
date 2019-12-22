package ru.vood.generator.read

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import ru.vood.generator.read.dto.KeyValDto
import ru.vood.generator.read.dto.YamlParamTemplateDto
import kotlin.test.assertEquals

internal class YamlReaderTest {

    lateinit var yamlReader: YamlReader<YamlParamTemplateDto>

    @BeforeEach
    fun setUp() {
        yamlReader = YamlReader(YamlParamTemplateDto::class.java, FileReaderImpl())
    }

    @Test
    fun readTune() {
        val yamlDto = YamlParamTemplateDto()
        val listOf = listOf(KeyValDto("1", "2"), KeyValDto("3", "4"))
        yamlDto.map = listOf
        yamlDto.multiMaps = listOf(KeyValDto("10", listOf(KeyValDto("100", "200"), KeyValDto("300", "400"))))

        val readyamlDto = yamlReader.readTune("ru/vood/generator/read/YamlReaderTest/test1.yaml")
        assertEquals(yamlDto, readyamlDto)

    }

    @Test
    fun saveTune() {
    }
}
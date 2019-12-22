package ru.vood.generator.read

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import ru.vood.generator.read.dto.YamlParamTemplateDto

internal class YamlReaderTest {

    lateinit var yamlReader: YamlReader<YamlParamTemplateDto>

    @BeforeEach
    fun setUp() {
        yamlReader = YamlReader(YamlParamTemplateDto::class.java, FileReaderImpl())
    }

    @Test
    fun readTune() {
        yamlReader.readTune("")
    }

    @Test
    fun saveTune() {
    }
}
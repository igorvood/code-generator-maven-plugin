package ru.vood.generator.read

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.yaml.snakeyaml.Yaml
import org.yaml.snakeyaml.constructor.Constructor
import ru.vood.generator.read.dto.jav.KeyMapDto
import ru.vood.generator.read.dto.jav.KeyValDto
import ru.vood.generator.read.dto.jav.YamlDto

internal class YamlReaderTestDelete {

    lateinit var yamlReader: YamlReader

    @BeforeEach
    fun setUp() {
        yamlReader = YamlReader()
    }

    @Test
    fun readTune() {

        val yaml = Yaml(Constructor(YamlDto::class.java))
        val yamlDto = YamlDto()
        val listOf = listOf(KeyValDto("1", "2"), KeyValDto("3", "4"))
        yamlDto.map = listOf
        yamlDto.multyMaps = listOf(KeyMapDto("10", listOf(KeyValDto("100", "200"), KeyValDto("300", "400"))))
        val dump = yaml.dump(yamlDto)
        println(dump)

        val load = yaml.load<YamlDto>(dump)
    }

    @Test
    fun saveTune() {
    }
}
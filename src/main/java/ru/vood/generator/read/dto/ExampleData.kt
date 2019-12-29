package ru.vood.generator.read.dto

import org.yaml.snakeyaml.Yaml
import org.yaml.snakeyaml.constructor.Constructor

enum class ExampleData(val clazz: Class<*>, val yaml: String) {
    TEMPLATE_PARAM(TemplateParamDto::class.java, yamlParamTemplateDto()),
    PLUGIN_PARAM(PluginParamDto::class.java, pluginParamDto());

}

fun yamlParamTemplateDto(): String {
    val yaml = Yaml(Constructor(TemplateParamDto::class.java))
    val yamlDto = TemplateParamDto()
    val listOf = listOf(KeyValDto("key1", "val2"), KeyValDto("key3", "val4"))
    yamlDto.map = listOf
    yamlDto.multiMaps = listOf(KeyValDto("key10", listOf(KeyValDto("key100", "val200"), KeyValDto("key300", "val400"))))
    yamlDto.multiList = listOf(
            KeyValDto("key1000", listOf("s1", "s2")),
            KeyValDto("key2000", listOf("s3", "s4"))
    )
    return yaml.dump(yamlDto)
}

private fun pluginParamDto(): String {
    val yaml = Yaml(Constructor(PluginParamDto::class.java))
    val yamlDto = PluginParamDto()

    yamlDto.generateParamDto = listOf(
            GenerateParamDto(TemplateEngine.FREE_MARKER, "file1", "sep1"),
            GenerateParamDto(TemplateEngine.FREE_MARKER_DATABASE, "file2", "sep2")
    )
    return yaml.dump(yamlDto)
}

package ru.vood.generator.read.dto

@Deprecated("use TemplateParamDto")
data class YamlParamDto(
        var map: List<KeyValDto<String>>
        , var multiMaps: List<KeyValDto<List<KeyValDto<String>>>>
) {
    constructor() : this(ArrayList<KeyValDto<String>>(), ArrayList<KeyValDto<List<KeyValDto<String>>>>())
}
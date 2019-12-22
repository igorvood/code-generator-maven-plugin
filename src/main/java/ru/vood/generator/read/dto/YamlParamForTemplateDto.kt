package ru.vood.generator.read.dto

data class YamlParamForTemplateDto(
        var map: List<KeyValDto<String>>?
        , var multiMaps: List<KeyValDto<List<KeyValDto<String>>>>?
) {
    constructor() : this(null, null)
}
package ru.vood.generator.read.dto

class YamlParamTemplateDto {
    var map: List<KeyValDto<String>>? = null
    var multiMaps: List<KeyValDto<List<KeyValDto<String>>>>? = null

    constructor()
    constructor(map: List<KeyValDto<String>>?, multiMaps: List<KeyValDto<List<KeyValDto<String>>>>?) {
        this.map = map
        this.multiMaps = multiMaps
    }

}
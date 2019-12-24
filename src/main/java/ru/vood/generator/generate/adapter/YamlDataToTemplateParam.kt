package ru.vood.generator.generate.adapter

import ru.vood.generator.read.dto.KeyValDto
import ru.vood.generator.read.dto.YamlParamForTemplateDto
import java.util.stream.Collectors.toMap

class YamlDataToTemplateParam : InputDataTypeToTemplateParam<YamlParamForTemplateDto> {
    override fun convert(param: YamlParamForTemplateDto): Pair<Map<String, String>, Map<String, Map<String, String>>> {
        val map = param.map.stream()
                .collect(
                        toMap(
                                { obj: KeyValDto<String> -> obj.key!! },
                                { obj: KeyValDto<String> -> obj.`val`!! }
                        )
                )
        val superMap = param.multiMaps.stream()
                .map {
                    Pair<String, Map<String, String>>(
                            it.key!!,
                            it.`val`!!
                                    .stream()
                                    .collect(
                                            toMap(
                                                    { obj: KeyValDto<String> -> obj.key!! },
                                                    { obj: KeyValDto<String> -> obj.`val`!! }
                                            )
                                    )!!
                    )
                }
                .collect(
                        toMap(
                                { obj: Pair<String, Map<String, String>> -> obj.first },
                                { obj: Pair<String, Map<String, String>> -> obj.second }
                        )
                )
        return Pair<Map<String, String>, Map<String, Map<String, String>>>(map, superMap)
    }
}
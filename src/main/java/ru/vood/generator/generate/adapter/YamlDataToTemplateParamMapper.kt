package ru.vood.generator.generate.adapter

import ru.vood.generator.read.dto.KeyValDto
import ru.vood.generator.read.dto.TemplateParamDto
import java.util.stream.Collectors.toMap

class YamlDataToTemplateParamMapper : AbstractInputDataTypeToTemplateParamMapper<TemplateParamDto>() {


    override fun map(param: TemplateParamDto): Pair<Map<String, String>, Map<String, Map<String, String>>> {
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
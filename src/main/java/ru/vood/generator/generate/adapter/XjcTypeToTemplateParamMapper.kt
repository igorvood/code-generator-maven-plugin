package ru.vood.generator.generate.adapter

import ru.vood.generator.read.dto.KeyValDto
import ru.vood.generator.read.dto.TemplateParamDto
import ru.vood.plugin.generated.from.xsd.TemplateParam
import kotlin.streams.toList

class XjcTypeToTemplateParamMapper : AbstractInputDataTypeToTemplateParamMapper<TemplateParam>() {

    override fun map(param: TemplateParam): TemplateParamDto {

        val simpleMap = param.params.simpleMap.entry
                .stream()
                .map { KeyValDto(it.key, it.value) }
                .toList()

        val superMap = param.params.superMap.entry
                .stream()
                .map {
                    KeyValDto<List<KeyValDto<String>>>(
                            it.key,
                            it.value.entry.stream()
                                    .map { KeyValDto<String>(it.key, it.value) }
                                    .toList()
                    )
                }
                .toList()
        return TemplateParamDto(simpleMap, superMap, ArrayList<KeyValDto<List<String>>>())
    }
}
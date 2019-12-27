package ru.vood.generator.generate.adapter

import ru.vood.plugin.generated.from.xsd.EntryType
import ru.vood.plugin.generated.from.xsd.TemplateParam
import java.util.stream.Collectors.toMap

class XjcTypeToTemplateParamMapper : AbstractInputDataTypeToTemplateParamMapper<TemplateParam>() {


    override fun map(param: TemplateParam): Pair<Map<String, String>, Map<String, Map<String, String>>> {

        var simpleMap: Map<String, String>?
        try {

            simpleMap = param.params.simpleMap.entry
                    .stream()
                    .collect(
                            toMap(
                                    { obj -> obj.key },
                                    { obj: EntryType -> obj.value }
                            )
                    )
        } catch (e: IllegalStateException) {
            throw ConvertException("""Can not convert data for simpleMap, reason=>${e.message!!}""", e)
        }
        val superMap = param.params.superMap.entry
                .stream()
                .map {
                    Pair<String, Map<String, String>>(
                            it.key,
                            it.value.entry.stream()
                                    .collect(
                                            toMap(
                                                    { obj -> obj.key },
                                                    fun(obj: EntryType): String {
                                                        return obj.value
                                                    }
                                            )
                                    )
                    )
                }
                .collect(
                        toMap(
                                { k -> k.first },
                                { k: Pair<String, Map<String, String>> -> k.second }
                        )
                )
        return simpleMap!! to superMap
    }
}
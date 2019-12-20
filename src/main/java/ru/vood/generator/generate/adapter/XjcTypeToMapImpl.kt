package ru.vood.generator.generate.adapter

import ru.vood.plugin.generated.from.xsd.EntryType
import ru.vood.plugin.generated.from.xsd.TemplateParam
import java.util.stream.Collectors.toMap

class XjcTypeToMapImpl : XjcTypeToMap {

    fun convert(param: TemplateParam): Pair<Map<String, String>, Map<String, Map<String, String>>> {
        val simpleMap = param.params.simpleMap.entry
                .stream()
                .collect(toMap(
                        { obj -> obj.key },
                        { obj: EntryType -> obj.value }
                ))
        val superMap = param.params.superMap.entry
                .stream()
                .map {
                    Pair<String, Map<String, String>>(it.key
                            , it.value.entry.stream()
                            .collect(toMap(
                                    { obj -> obj.key },
                                    fun(obj: EntryType): String {
                                        return obj.value
                                    }
                            )
                            )
                    )
                }
                .collect(toMap(
                        { k -> k.first }
                ) { k: Pair<String, Map<String, String>> -> k.second }
                )
        return Pair(simpleMap, superMap)
    }
}
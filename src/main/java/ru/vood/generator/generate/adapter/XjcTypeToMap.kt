package ru.vood.generator.generate.adapter

import ru.vood.plugin.generated.from.xsd.TemplateParam

interface XjcTypeToMap {

    fun convert(param: TemplateParam): Pair<Map<String, String>, Map<String, Map<String, String>>>
}
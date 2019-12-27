package ru.vood.generator.generate.adapter

abstract class AbstractInputDataTypeToTemplateParamMapper<T> : InputDataTypeToTemplateParam<T> {
    override fun convert(param: T): Pair<Map<String, String>, Map<String, Map<String, String>>> {
        return map(param)
    }

    protected abstract fun map(param: T): Pair<Map<String, String>, Map<String, Map<String, String>>>
}
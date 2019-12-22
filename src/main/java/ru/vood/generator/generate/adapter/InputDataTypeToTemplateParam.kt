package ru.vood.generator.generate.adapter

interface InputDataTypeToTemplateParam<T> {

    fun convert(param: T): Pair<Map<String, String>, Map<String, Map<String, String>>>
}
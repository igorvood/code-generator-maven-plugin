package ru.vood.generator.read

import ru.vood.plugin.generated.from.xsd.PluginTinesType

interface TuneReader {
    fun readTune(xml: String): PluginTinesType
}
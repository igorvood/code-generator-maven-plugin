package ru.vood.generator.read

import ru.vood.plugin.generated.from.xsd.PluginTines
import java.io.File

interface TuneReader {
    fun readTune(xmlText: String): PluginTines

    fun readTuneFromFile(fileName: String): PluginTines

    fun saveTune(pluginTune: PluginTines, file: File)

}
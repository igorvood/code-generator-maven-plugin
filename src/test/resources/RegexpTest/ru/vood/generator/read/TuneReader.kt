package ru.vood.generator.read

import ru.vood.plugin.generated.from.xsd.PluginTines
import java.io.File

interface TuneReader {
    fun readTune(fileName: String): PluginTines

    fun saveTune(pluginTune: PluginTines, file: File)

}
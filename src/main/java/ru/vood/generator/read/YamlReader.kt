package ru.vood.generator.read

import org.yaml.snakeyaml.Yaml
import java.io.File


class YamlReader : TuneReader<Any> {
    override fun readTune(fileName: String): Any {
        val yaml = Yaml()

    }

    override fun saveTune(pluginTune: Any, file: File) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
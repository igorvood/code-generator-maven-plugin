package ru.vood.generator.read

import org.yaml.snakeyaml.Yaml
import ru.vood.generator.read.dto.YamlDtoKt
import java.io.File


class YamlReader : TuneReader<Any> {
    override fun readTune(fileName: String): Any {
        val yaml = Yaml()
        val y = YamlDtoKt()
        val dump = yaml.dump(y)
        return dump
    }

    override fun saveTune(pluginTune: Any, file: File) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
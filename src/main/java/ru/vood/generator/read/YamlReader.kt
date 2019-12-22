package ru.vood.generator.read

import org.yaml.snakeyaml.Yaml
import org.yaml.snakeyaml.constructor.Constructor
import ru.vood.generator.generate.resolve.FileNameResolverException
import java.io.File


class YamlReader<T>(private val clazz: Class<T>
                    , private val fileReader: FileReader) : TuneReader<T> {

    private val yaml = Yaml(Constructor(clazz))

    override fun readTune(fileName: String): T {
        val file = File(fileName)
        if (!file.exists()) throw  FileNameResolverException("""file ${file.absolutePath} does not exists.""")
        val readFile = fileReader.readFile(fileName)
        return yaml.load<T>(readFile)
    }

    override fun saveTune(pluginTune: T, file: File) {
        file.writeText(yaml.dump(pluginTune))
    }
}
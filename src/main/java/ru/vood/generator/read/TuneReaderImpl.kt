package ru.vood.generator.read

import ru.vood.generator.xml.XMLValidator
import ru.vood.plugin.generated.from.xsd.PluginTines
import java.io.File
import javax.xml.bind.JAXBContext
import javax.xml.bind.Marshaller
import javax.xml.bind.Unmarshaller


class TuneReaderImpl(private val xmlValidator: XMLValidator
                     , private val fileReader: FileReader) : TuneReader {

    private val unmarshaller: Unmarshaller
    private val marshaller: Marshaller

    init {
        val jaxbContext = JAXBContext.newInstance(PluginTines::class.java)
        unmarshaller = jaxbContext.createUnmarshaller()
        marshaller = jaxbContext.createMarshaller()
    }

    override fun readTune(xmlText: String): PluginTines {
        xmlValidator.validate(xmlText)
        val unmarshal = unmarshaller.unmarshal(File(xmlValidator.getResource(xmlText)))
        return (unmarshal as PluginTines)
    }

    override fun readTuneFromFile(fileName: String) = readTune(fileReader.readFile(fileName))

    override fun saveTune(pluginTune: PluginTines, file: File) {
        marshaller.marshal(pluginTune, file)
    }
}
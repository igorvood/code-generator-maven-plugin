package ru.vood.generator.read

import ru.vood.plugin.generated.from.xsd.PluginTinesType
import java.io.StringReader
import javax.xml.bind.JAXBContext
import javax.xml.bind.Unmarshaller

class TuneReaderImpl() : TuneReader {

    private val unmarshaller: Unmarshaller

    init {
        val jaxbContext = JAXBContext.newInstance(PluginTinesType::class.java)
        unmarshaller = jaxbContext.createUnmarshaller()
    }

    override fun readTune(xml: String): PluginTinesType {
        val sr = StringReader(xml)
        return (unmarshaller.unmarshal(sr) as PluginTinesType)
    }
}
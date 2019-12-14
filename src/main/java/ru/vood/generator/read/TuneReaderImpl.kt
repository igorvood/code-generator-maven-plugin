package ru.vood.generator.read

import ru.vood.generator.xml.XMLValidator
import ru.vood.plugin.generated.from.xsd.PluginTinesType
import java.io.File
import java.io.StringReader
import javax.xml.bind.JAXBContext
import javax.xml.bind.Unmarshaller

class TuneReaderImpl(private val xmlValidator: XMLValidator
                     , private val fileReader: FileReader) : TuneReader {


    private val unmarshaller: Unmarshaller

    init {
        val jaxbContext = JAXBContext.newInstance(PluginTinesType::class.java)
        unmarshaller = jaxbContext.createUnmarshaller()
    }

    override fun readTune(xmlText: String): PluginTinesType {
//        val inputStream = InputStream(IOUtils.toInputStream(xmlText, "UTF-8"))
//        val unmarshal1 = unmarshaller.unmarshal(inputStream)
//        return (unmarshal1 as PluginTinesType)

        val sr = StringReader(xmlText)
        println("xml text -> $xmlText")
        xmlValidator.validate(xmlText)

        val unmarshal = unmarshaller.unmarshal(File(xmlValidator.getResource(xmlText)))
//        val unmarshal = unmarshaller.unmarshal(sr)File
        return (unmarshal as PluginTinesType)
    }

    override fun readTuneFromFile(fileName: String) = readTune(fileReader.readFile(fileName))
}
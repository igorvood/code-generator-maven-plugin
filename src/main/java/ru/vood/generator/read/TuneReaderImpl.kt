package ru.vood.generator.read

import ru.vood.generator.xml.XMLValidator
import ru.vood.generator.xml.XMLValidatorImpl
import ru.vood.plugin.generated.from.xsd.PluginTinesType
import java.io.StringReader
import javax.xml.bind.JAXBContext
import javax.xml.bind.Unmarshaller

class TuneReaderImpl : TuneReader {

    private val unmarshaller: Unmarshaller

    private val fileReader: FileReader

    private val xmlValidator: XMLValidator

    init {
        val jaxbContext = JAXBContext.newInstance(PluginTinesType::class.java)
        unmarshaller = jaxbContext.createUnmarshaller()
        fileReader = FileReaderImpl()
        xmlValidator = XMLValidatorImpl()
    }

    override fun readTune(xmlText: String): PluginTinesType {
        val sr = StringReader(xmlText)
        println("xml text $xmlText")
        xmlValidator.validate(sr.toString())
        return (unmarshaller.unmarshal(sr) as PluginTinesType)
    }

    override fun readTuneFromFile(fileName: String) = readTune(fileReader.readFile(fileName))
}
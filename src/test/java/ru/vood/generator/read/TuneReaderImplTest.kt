package ru.vood.generator.read

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import ru.vood.generator.xml.XMLValidatorImpl

internal class TuneReaderImplTest {

    private lateinit var tuneReader: TuneReader

    @BeforeEach
    fun setUp() {
        tuneReader = TuneReaderImpl(XMLValidatorImpl(), FileReaderImpl())
    }

    @Test
    fun readTune() {
        tuneReader.readTune("TuneReaderImplTest/ExampleParameters.xsd.xml")
//        tuneReader.readTune("TuneReaderImplTest/parameters.xsd.xml")
    }

    @Test
    fun readTuneFromFile() {
    }
}
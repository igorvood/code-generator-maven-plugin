package ru.vood.generator.read

import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class FileReaderImplTest {

    private lateinit var fileReaderImpl: FileReader

    @BeforeEach
    fun setUp() {
        fileReaderImpl = FileReaderImpl()
    }

    @Test
    fun readFile() {
        val readFile = fileReaderImpl.readFile("XMLValidatorImplTest/test.error.xml")
        assertNotNull(readFile)
    }
}
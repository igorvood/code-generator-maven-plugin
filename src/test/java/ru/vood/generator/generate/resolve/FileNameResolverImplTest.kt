package ru.vood.generator.generate.resolve

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.File
import java.io.InputStream
import java.util.*

internal class FileNameResolverImplTest {

    lateinit var fileNameResolver: FileNameResolver

    @BeforeEach
    fun setUp() {
        fileNameResolver = FileNameResolverImpl()
    }

    @Test
    fun resolveFileByContent() {
        val begPath = "src/test/resources/RegexpTest"
        val dir = File(begPath)
        Assertions.assertTrue(dir.exists())
        val lf: Set<File> = getListFiles(dir)
        lf.stream()
                .map { Pair<File, String>(it, readFile(it)) }
//                .filter{it.first.absolutePath.contains("VBdIndexedColomnsEntityTest")}
//                .peek { println("----->"+it.first) }
                .map { Pair(it.first.absolutePath.replace("\\", "."), fileNameResolver.resolveFileByContent(calculationTypeFile(it.first), it.second)) }
//                .peek { println(it.first.substring(it.first.indexOf("ru.vood"))) }
                .map { Pair(it.first.substring(it.first.indexOf("ru.vood")), it.second) }
                .peek { Assertions.assertTrue(it.first.contains(it.second.packageStr), "package for ${it.first} does not correct") }
                .peek { Assertions.assertTrue(it.first.contains(it.second.fileName + "." + it.second.type.extensionFile), "file name for ${it.first} does not correct") }
                .forEach { println(it) }
        println("total file ${lf.size}")
    }

    private fun getListFiles(dir: File): Set<File> {
        val lf = HashSet<File>()
        if (dir.isDirectory) {
            val listFiles = dir.listFiles()
            listFiles
                    .map { getListFiles(it) }
                    .forEach { lf.addAll(it) }
        } else {
            lf.add(dir)
        }
        return lf
    }

    private fun readFile(f: File): String {
        val inputStream: InputStream = f.inputStream()
        return inputStream.bufferedReader().use { it.readText() }
    }

    private fun calculationTypeFile(f: File) =
            TypeFile.values()
                    .filter { it.extensionFile == f.absolutePath.split(".")[1] }[0]


}


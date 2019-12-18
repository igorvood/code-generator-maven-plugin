package ru.vood.generator.generate.resolve

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.io.File
import java.util.*
import kotlin.streams.toList

internal class RegexpTest {

    @Test
    fun getExtensionFile() {
        val begPath = "src/test/resources/RegexpTest"
        val dir = File(begPath)
        val lf: Set<File> = getListFiles(dir)
        Assertions.assertTrue(dir.exists())
        lf.stream()
//                .map {begPath.replace("\\","/")  }
                .map { VoodFile(it.name, it.path) }
//                .map { it.toString().replace(begPath.replace("\\","/")) }
                .peek { println(it) }
                .toList()
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
}
package ru.vood.generator.file

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.StandardOpenOption

class GenerateFileImpl : GenerateFile {

    override fun generateFile(basePath: String, packageS: String, fileName: String, generatedCode: String): Path {
        val path = Paths.get("${createDirs(basePath, packageS)}\\$fileName")
        println("generateFile path -> $path")
        val pathRes = Files.write(path, generatedCode.toByteArray(), StandardOpenOption.CREATE)
        println("generateFile pathRes -> $pathRes")
        if (pathRes == null)
            throw IllegalStateException("Unable to write file $path")

        return pathRes
    }

    private fun createDirs(startPath: String, packageName: String): String {
        val dirs = """$startPath\${packageName.replace(".", "\\")}"""
        val dir = Files.createDirectories(Paths.get(dirs))
        return dir.toString()
    }


}
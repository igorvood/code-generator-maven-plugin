package ru.vood.generator.file

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.StandardOpenOption

class GenerateFileImpl : GenerateFile {

    override fun generateFile(basePath: String, packageS: String, fileName: String, generatedCode: String): Path {
        val packageName = "$packageS.generated"
        val path = Paths.get("${createDirs(basePath, packageName)}\\$fileName")
        val pack = "package $packageName;\n\n$generatedCode"
        return Files.write(path, pack.toByteArray(), StandardOpenOption.CREATE)
    }

    private fun createDirs(startPath: String, packageName: String): String {
        val dirs = """$startPath\${packageName.replace(".", "\\")}"""
        val dir = Files.createDirectories(Paths.get(dirs))
        return dir.toString()
    }


}
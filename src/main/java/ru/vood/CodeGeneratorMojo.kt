package ru.vood

import org.apache.maven.plugins.annotations.LifecyclePhase
import org.apache.maven.plugins.annotations.Mojo
import org.apache.maven.plugins.annotations.Parameter
import ru.vood.generator.file.getCanonicalPath

import ru.vood.generator.tjc.AbstractTjcMojo
import java.io.File

@Mojo(name = "generate", defaultPhase = LifecyclePhase.GENERATE_SOURCES, threadSafe = true)
class CodeGeneratorMojo : AbstractTjcMojo() {


    @Parameter(property = "baseDirectory", required = false, defaultValue = "\${project.build.directory}/generated-sources/tjc", readonly = true)
    private var baseDirectory: String = ""


    val code =
            "public class POI {\n" +
                    "}\n"
    /**
     * Location of the file.
     * @parameter expression="${project.build.directory}"
     * @required
     */
    private val outputDirectory: File? = null


    override fun execute() {
        println("BEGIN CodeGeneratorMojo")
        val wallpaperDirectory = File("$baseDirectory/ru/vood/")
        println(wallpaperDirectory.absolutePath)
        // have the object build the directory structure, if needed.
        val mkdirs = wallpaperDirectory.mkdirs()
        println("mkdirs = $mkdirs")

        val outputFile = File(wallpaperDirectory, "Test.kt")

        val createNewFile = outputFile.createNewFile()
        println("createNewFile = $createNewFile")
        outputFile.writeText("""package ru.vood

class Test{
    fun prn(){
        println(this.javaClass.canonicalName)
    }
} """)

        val canonicalPathToOutputDirectory = getCanonicalPath(File(baseDirectory))
        // Add the output Directory.
        println("canonicalPathToOutputDirectory=$canonicalPathToOutputDirectory")
        getProject().addCompileSourceRoot(canonicalPathToOutputDirectory)
        println("END CodeGeneratorMojo")
    }

//    private fun gen2() {
//        println("------> HELLOW generatorTuneXmlFile->$generatorTuneXmlFile")
//        val read: TuneReader<PluginTines> = XmlReader(XMLValidatorImpl())
//        val readTuneFromFile = read.readTune(generatorTuneXmlFile)
//        println("------> UNMARSHAL ->$readTuneFromFile.templateGenerateList.generate.size")
//    }
//
//    private fun staticGenerate() {
//        println("------> HELLOW baseDirectory->$baseDirectory")
//        val test = GenerateFileImpl()
//        val generateFile = test.generateFile(baseDirectory, packageS, fileName, code)
//        println("------>$generateFile")
//    }

}
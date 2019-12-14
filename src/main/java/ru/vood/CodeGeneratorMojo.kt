package ru.vood

import org.apache.maven.plugin.AbstractMojo
import org.apache.maven.plugins.annotations.LifecyclePhase
import org.apache.maven.plugins.annotations.Mojo
import org.apache.maven.plugins.annotations.Parameter
import ru.vood.generator.file.GenerateFileImpl
import ru.vood.generator.read.TuneReader
import ru.vood.generator.read.TuneReaderImpl
import java.io.File

@Mojo(name = "GenerateCode", defaultPhase = LifecyclePhase.GENERATE_SOURCES, threadSafe = true)
class CodeGeneratorMojo : AbstractMojo() {

    @Parameter(property = "generatorTuneXmlFile", required = true, readonly = true)
    private var generatorTuneXmlFile: String = ""

    @Parameter(property = "baseDirectory", required = false, defaultValue = "\${project.build.directory}/generated-sources", readonly = true)
    private var baseDirectory: String = ""

    @Parameter(property = "package", required = true)
    private var packageS: String = ""

    @Parameter(property = "fileName", required = true)
    private var fileName: String = ""

    @Parameter(property = "templateFileName", required = true)
    private var templateFileName: String = ""


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
        println("------> HELLOW generatorTuneXmlFile->$generatorTuneXmlFile")
        val read: TuneReader = TuneReaderImpl()
        val readTuneFromFile = read.readTuneFromFile(generatorTuneXmlFile)
        println("------> UNMARSHAL ->$readTuneFromFile.templateGenerateList.generate.size")

    }

    private fun staticGenerate() {
        println("------> HELLOW baseDirectory->$baseDirectory")
        val test = GenerateFileImpl()
        val generateFile = test.generateFile(baseDirectory, packageS, fileName, code)
        println("------>$generateFile")
    }

}
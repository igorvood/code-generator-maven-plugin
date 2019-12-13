package ru.vood

import org.apache.maven.plugin.AbstractMojo
import org.apache.maven.plugins.annotations.LifecyclePhase
import org.apache.maven.plugins.annotations.Mojo
import java.io.File

@Mojo(name = "GenerateCode", defaultPhase = LifecyclePhase.GENERATE_SOURCES, threadSafe = true)
class CodeGeneratorMojo : AbstractMojo() {
    /**
     * Location of the file.
     * @parameter expression="${project.build.directory}"
     * @required
     */
    private val outputDirectory: File? = null


    override fun execute() {
        println("------> HELLOW ")
//        val f = outputDirectory
//        if (!f!!.exists()) {
//            f.mkdirs()
//        }
//        val touch = File(f, "touch.txt")
//        var w: FileWriter? = null
//        try {
//            w = FileWriter(touch)
//            w.write("touch.txt")
//        } catch (e: IOException) {
//            throw MojoExecutionException("Error creating file $touch", e)
//        } finally {
//            if (w != null) {
//                try {
//                    w.close()
//                } catch (e: IOException) { // ignore
//                }
//            }
//        }
    }

}
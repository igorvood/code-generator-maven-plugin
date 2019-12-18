package ru.vood.generator.generate.resolve

import java.util.regex.Matcher
import java.util.regex.Pattern


class FileNameResolverImpl : FileNameResolver {

    override fun resolveFileByContent(typeFile: TypeFile, text: String): FileProperty {
        val patternPack: Pattern = Pattern.compile(typeFile.packageRegexp, Pattern.MULTILINE)
        val matcherPack: Matcher = patternPack.matcher(text)
        var pack: String? = null
        if (matcherPack.find()) {
            pack = matcherPack.group(1)
        }
        val patternClass: Pattern = Pattern.compile(typeFile.classNameRegexp, Pattern.MULTILINE)
        val matcherClass: Matcher = patternClass.matcher(text)
        var clazz: String? = null
//        while (matcherClass.find()) {
//            println("Full match: " + matcherClass.group(0))
//            for (i in 1..matcherClass.groupCount()) {
//                println("Group " + i + ": " + matcherClass.group(i))
//            }
//        }

        if (matcherClass.find()) {
            clazz = matcherClass.group(6)
        }
        if (clazz == null) clazz = "err"
        if (pack == null) pack = "err"
        return FileProperty(fileName = clazz, packageStr = pack, type = typeFile)
    }
}
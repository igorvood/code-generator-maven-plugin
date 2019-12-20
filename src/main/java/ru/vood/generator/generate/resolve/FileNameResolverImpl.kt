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

        if (matcherClass.find()) {
            clazz = matcherClass.group(6)
        }
        var err = ""
        if (pack == null) err = "Can not resolve package name, regexp=${typeFile.packageRegexp}."
        if (clazz == null) err += " Can not resolve class name, regexp=${typeFile.classNameRegexp}."
        if (err.isNotEmpty()) throw FileNameResolverException("$err. File text:\n$text")
        return FileProperty(fileName = clazz!!, packageStr = pack!!, type = typeFile)
    }
}
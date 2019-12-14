package ru.vood.generator.xml

interface XMLValidator {
    public val
            DEFAULT_XSD_SHEME: String
        get() = "resources\\XSDSchema\\parameters.xsd"

    fun validate(xmlFile: String, schemaFile: String = DEFAULT_XSD_SHEME)
}
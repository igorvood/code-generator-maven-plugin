package ru.vood.generator.generate.adapter

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import ru.vood.plugin.generated.from.xsd.*

internal class XjcTypeToMapImplTest {
    lateinit var xjcTypeToMap: InputDataTypeToTemplateParam<TemplateParam>

    @BeforeEach
    fun setUp() {
        xjcTypeToMap = XjcTypeToMapImpl()
    }

    @Test
    fun convert() {
        val templateParam = TemplateParam()
        templateParam.params = MapsType()
        templateParam.params.simpleMap = MapType()
        val superMapType = SuperMapType()
        templateParam.params.superMap = superMapType
        //-----------------------
        var element = EntryType()
        element.key = "elementKey1"
        element.value = "elementValue1"
        templateParam.params.simpleMap.entry.add(element)
        element = EntryType()
        element.key = "elementKey2"
        element.value = "elementValue2"
        templateParam.params.simpleMap.entry.add(element)

        //-----------------
        var set = SuperEntryType()
        set.key = "SuperEntryType1"
        set.value = templateParam.params.simpleMap
        templateParam.params.superMap.entry.add(set)
        set = SuperEntryType()
        set.key = "SuperEntryType2"
        set.value = templateParam.params.simpleMap
        templateParam.params.superMap.entry.add(set)

        val convert = xjcTypeToMap.convert(templateParam)
        Assertions.assertEquals("({elementKey1=elementValue1, elementKey2=elementValue2}, {SuperEntryType2={elementKey1=elementValue1, elementKey2=elementValue2}, SuperEntryType1={elementKey1=elementValue1, elementKey2=elementValue2}})", convert.toString())
    }

    @Test
    fun convertDuplicateError() {
        val templateParam = TemplateParam()
        templateParam.params = MapsType()
        templateParam.params.simpleMap = MapType()
        val superMapType = SuperMapType()
        templateParam.params.superMap = superMapType
        //-----------------------
        var element = EntryType()
        element.key = "elementKey1"
        element.value = "elementValue1"
        templateParam.params.simpleMap.entry.add(element)
        element = EntryType()
        element.key = "elementKey1"
        element.value = "elementValue2"
        templateParam.params.simpleMap.entry.add(element)

        try {
            xjcTypeToMap.convert(templateParam)
            Assertions.fail<String>("Test fail")
        } catch (e: ConvertException) {
            Assertions.assertTrue(e.message.contains("Can not convert data for simpleMap, reason=>"))
        } catch (e: Throwable) {
            Assertions.fail<String>("Test fail")
        }

    }

}
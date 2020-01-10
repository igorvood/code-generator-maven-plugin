package ru.vood.generator.generate.runner

import ru.vood.freemarker.FtlProcessor

fun resolveEngineRunner(templateEngine: TemplateEngine): RunnerEngine {
    return when (templateEngine.getaClass()) {
        FreeMarkerEngine::class.java -> FreeMarkerEngine(FtlProcessor())
        else -> throw IllegalStateException()
    }
}
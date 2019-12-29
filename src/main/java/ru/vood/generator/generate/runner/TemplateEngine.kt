package ru.vood.generator.generate.runner

import ru.vood.freemarker.FtlProcessorImpl

enum class TemplateEngine(val runner: RunnerEngine) {
    FREE_MARKER(FreeMarkerEngine(FtlProcessorImpl())),
    FREE_MARKER_DATABASE(FreeMarkerDatabaseEngine()),
    VELOCITY(VelocityEngine()),
    ERROR(ErrorEngine())
}

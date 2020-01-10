package ru.vood.generator.generate.runner

import ru.vood.freemarker.FtlProcessor


enum class TemplateEngine(val runner: RunnerEngine) {
    FREE_MARKER(FreeMarkerEngine(FtlProcessor())),
    FREE_MARKER_DATABASE(FreeMarkerDatabaseEngine()),
    VELOCITY(VelocityEngine()),
    ERROR(ErrorEngine())
}

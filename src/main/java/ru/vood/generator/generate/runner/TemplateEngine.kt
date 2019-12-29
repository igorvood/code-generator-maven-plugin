package ru.vood.generator.generate.runner

enum class TemplateEngine(val runner: RunnerEngine) {
    FREE_MARKER(FreeMarkerEngine()),
    FREE_MARKER_DATABASE(FreeMarkerDatabaseEngine()),
    VELOCITY(VelocityEngine()),
    ERROR(ErrorEngine())
}

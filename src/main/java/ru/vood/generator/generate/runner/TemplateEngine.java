package ru.vood.generator.generate.runner;

public enum TemplateEngine {

    FREE_MARKER(FreeMarkerEngine.class),
    FREE_MARKER_DATABASE(FreeMarkerDatabaseEngine.class),
    VELOCITY(VelocityEngine.class),
    ERROR(ErrorEngine.class);

    private final Class aClass;

    <T extends RunnerEngine> TemplateEngine(Class<T> runnerEngine) {
        aClass = runnerEngine;
    }

    public Class getaClass() {
        return aClass;
    }
}



package org.gradle.sample

import groovy.transform.CompileStatic
import org.gradle.api.Action
import org.gradle.api.Plugin
import org.gradle.api.Project

@CompileStatic
class MyPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        // Internal API
        def lockingConfiguration = {} as Action // Actions.doNothing()
        println project.gradle.gradleVersion
//        println(((GradleInternal)project.gradle).getServices().get(InjectedPluginClasspath).getClasspath())

        // 4.8-only API
        project.dependencyLocking(lockingConfiguration)
    }
}

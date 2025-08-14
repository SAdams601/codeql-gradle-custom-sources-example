import org.gradle.kotlin.dsl.register

group = "org.example"
version = "1.0"
description = "custom-sources-gradle"

plugins {
    java
}

sourceSets {
    create("customTest") {
        compileClasspath += sourceSets.main.get().output
        runtimeClasspath += sourceSets.main.get().output
    }
}

val customTestImplementation by configurations.getting {
    extendsFrom(configurations.implementation.get())
}

val customTestRuntimeOnly by configurations.getting

configurations["customTestRuntimeOnly"].extendsFrom(configurations.runtimeOnly.get())

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.13.4"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    customTestImplementation(platform("org.junit:junit-bom:5.13.4"))
    customTestImplementation("org.junit.jupiter:junit-jupiter")
    customTestRuntimeOnly("org.junit.platform:junit-platform-launcher")

}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }

}

val customTest = tasks.register<Test>("customTest") {
    description = "Tests on a custom path"
    group = "verification"

    testClassesDirs = sourceSets["customTest"].output.classesDirs
    classpath = sourceSets["customTest"].runtimeClasspath
    useJUnitPlatform()

    testLogging {
        events("passed", "skipped", "failed")
    }
}

tasks.check { dependsOn(customTest) }

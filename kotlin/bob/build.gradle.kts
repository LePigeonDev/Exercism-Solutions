import org.gradle.api.tasks.testing.logging.TestExceptionFormat

plugins {
    kotlin("jvm")                    // sans version
}

repositories { mavenCentral() }

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    testImplementation("junit:junit:4.13.2")
    testImplementation(kotlin("test-junit"))
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17)) // compatible anciennes versions
    }
}

tasks.withType<Test> {
    testLogging {
        exceptionFormat = TestExceptionFormat.FULL
        events("passed", "failed", "skipped")
    }
}

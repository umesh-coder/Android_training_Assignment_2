plugins {
    kotlin("jvm") version "1.9.23"
    kotlin("plugin.serialization") version "1.5.21"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.0")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(8)
}


plugins {
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.serialization") version "1.6.21"

    id("net.mamoe.mirai-console") version "2.11.0"
    id("net.mamoe.maven-central-publish") version "0.7.1"
}

group = "xyz.cssxsh"
version = "1.5.0-M1"

repositories {
    mavenLocal()
    mavenCentral()
}

mavenCentralPublish {
    useCentralS01()
    singleDevGithubProject("cssxsh", "bilibili-helper")
    licenseFromGitHubProject("AGPL-3.0", "master")
    publication {
        artifact(tasks.getByName("buildPlugin"))
        artifact(tasks.getByName("buildPluginLegacy"))
    }
}

dependencies {
    implementation("io.ktor:ktor-client-serialization:1.6.7") {
        exclude(group = "org.jetbrains.kotlin")
        exclude(group = "org.jetbrains.kotlinx")
        exclude(group = "org.slf4j")
        exclude(group = "io.ktor", module = "ktor-client-core")
    }
    implementation("io.ktor:ktor-client-encoding:1.6.7") {
        exclude(group = "org.jetbrains.kotlin")
        exclude(group = "org.jetbrains.kotlinx")
        exclude(group = "org.slf4j")
        exclude(group = "io.ktor", module = "ktor-client-core")
    }
    compileOnly("xyz.cssxsh.mirai:mirai-selenium-plugin:2.1.0")
    compileOnly("net.mamoe:mirai-core:2.11.0")
    compileOnly("net.mamoe:mirai-core-utils:2.11.0")

    testImplementation(kotlin("test", "1.6.21"))
    testImplementation("org.slf4j:slf4j-simple:1.7.36")
    testImplementation("xyz.cssxsh.mirai:mirai-selenium-plugin:2.1.0")
}

tasks {
    test {
        useJUnitPlatform()
    }
}
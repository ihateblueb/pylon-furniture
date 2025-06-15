import net.minecrell.pluginyml.bukkit.BukkitPluginDescription

plugins {
    java
    idea
    kotlin("jvm")
    id("com.gradleup.shadow") version "8.3.2"
    id("net.minecrell.plugin-yml.bukkit") version "0.6.0"
    id("xyz.jpenilla.run-paper") version "2.3.0"
    id("io.freefair.lombok") version "8.13.1"
}

group = "io.github.pylonmc"

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/") {
        name = "papermc"
    }
    maven("https://repo.xenondevs.xyz/releases")
}

val coreVersion = project.properties["pylon-core.version"] as String

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.21.4-R0.1-SNAPSHOT")
    compileOnly("io.github.pylonmc:pylon-core:$coreVersion")
    implementation(kotlin("stdlib-jdk8"))
}

idea {
    module {
        isDownloadJavadoc = true
        isDownloadSources = true
    }
}

java {
    toolchain.languageVersion = JavaLanguageVersion.of(21)
}

kotlin {
    jvmToolchain(21)
}

tasks.shadowJar {
    mergeServiceFiles()

    fun doRelocate(lib: String) {
        relocate(lib, "$group.shadowlibs.$lib")
    }

    archiveBaseName = project.name
    archiveClassifier = null
}

bukkit {
    name = "PylonFurniture"
    main = "io.github.pylonmc.pylon.furniture.PylonFurniture"
    version = project.version.toString()
    apiVersion = "1.21"
    depend = listOf("PylonCore")
    load = BukkitPluginDescription.PluginLoadOrder.STARTUP
}

tasks.runServer {
    downloadPlugins {
        github("pylonmc", "pylon-core", coreVersion, "pylon-core-$coreVersion.jar")
    }
    maxHeapSize = "4G"
    minecraftVersion("1.21.4")
}
import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  kotlin("jvm") version Version.kotlin
  id("com.github.ben-manes.versions") version Version.versionsPlugin
}

group = "io.github.vihangpatil"
version = "1.0.0-SNAPSHOT"

repositories {
  mavenCentral()
  jcenter()
}

dependencies {
  implementation(kotlin("stdlib-jdk8"))

  implementation("org.slf4j:slf4j-api:${Version.slf4j}")
  implementation("org.slf4j:slf4j-simple:${Version.slf4j}")

  // Apache Beam
  implementation("com.google.cloud.dataflow:google-cloud-dataflow-java-sdk-all:${Version.dataflow}")

  // KTS Engine
  implementation(kotlin("script-util"))
  implementation(kotlin("script-runtime"))
  implementation(kotlin("compiler-embeddable"))
  implementation(kotlin("scripting-compiler-embeddable"))
  implementation("net.java.dev.jna:jna:${Version.jna}")
  // implementation(kotlin("compiler"))
  // implementation(kotlin("scripting-compiler"))
  testImplementation(kotlin("test-junit"))
}

java {
  sourceCompatibility = JavaVersion.VERSION_15
  targetCompatibility = JavaVersion.VERSION_15
}

tasks.withType<KotlinCompile> {
  kotlinOptions {
    jvmTarget = JavaVersion.VERSION_15.majorVersion
  }
}

fun isNonStable(version: String): Boolean {
  val regex = "^[0-9,.v-]+$".toRegex()
  val isStable = regex.matches(version)
  return isStable.not()
}

tasks.withType<DependencyUpdatesTask> {
  // Example 1: reject all non stable versions
  rejectVersionIf {
    isNonStable(candidate.version)
  }

  // Example 2: disallow release candidates as upgradable versions from stable versions
  rejectVersionIf {
    isNonStable(candidate.version) && !isNonStable(currentVersion)
  }

  // Example 3: using the full syntax
  resolutionStrategy {
    componentSelection {
      all {
        if (isNonStable(candidate.version) && !isNonStable(currentVersion)) {
          reject("Release candidate")
        }
      }
    }
  }
}
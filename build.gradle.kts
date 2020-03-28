import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  kotlin("jvm") version("1.3.70")
}

group = "io.github.viahngpatil"
version = "1.0.0-SNAPSHOT"

repositories {
  mavenCentral()
  jcenter()
}

dependencies {
  implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

  implementation("org.slf4j:slf4j-api:1.7.25")
  implementation("org.slf4j:slf4j-simple:1.7.25")

  implementation("com.google.cloud.dataflow:google-cloud-dataflow-java-sdk-all:2.5.0")

  testImplementation("org.jetbrains.kotlin:kotlin-test-junit:1.2.70")
}

java {
  sourceCompatibility = JavaVersion.VERSION_13
  targetCompatibility = JavaVersion.VERSION_13
}

tasks.withType<KotlinCompile> {
  kotlinOptions {
    jvmTarget = JavaVersion.VERSION_13.majorVersion
  }
}

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
	repositories {
		mavenCentral()
		maven("https://repo.spring.io/milestone")
		maven("https://repo.spring.io/snapshot")
	}

	dependencies {
		classpath("org.springframework.boot:spring-boot-gradle-plugin:2.0.0.M4")
	}
}

plugins {
	val kotlinVersion = "1.1.50"
	id("org.jetbrains.kotlin.jvm") version kotlinVersion
	id("org.jetbrains.kotlin.plugin.spring") version kotlinVersion
	id("org.jetbrains.kotlin.plugin.noarg") version kotlinVersion
	id("io.spring.dependency-management") version "1.0.3.RELEASE"
}

apply {
	plugin("kotlin")
	plugin("kotlin-spring")
	plugin("kotlin-jpa")
	plugin("org.springframework.boot")
    //plugin("kotlin-noarg")
}

version = "0.0.1-SNAPSHOT"

tasks {
	withType<KotlinCompile> {
		kotlinOptions {
			jvmTarget = "1.8"
			freeCompilerArgs = listOf("-Xjsr305=strict")
			/**
			Kotlin 1.1.4 introduced initial experimental support for default nullability annotations, such as
			@ParametersAreNonnullByDefault as an opt-in feature. In Kotlin 1.1.50, nullability problems detected
            thanks to such annotations are by default reported as warnings. To convert them into errors, add the
            command line parameter -Xjsr305=strict.
			*/
		}
	}
}

repositories {
	mavenCentral()
    jcenter()
	maven("https://repo.spring.io/milestone")
	maven("https://repo.spring.io/snapshot")
}

dependencies {
	compile("org.jetbrains.kotlin:kotlin-stdlib")
	compile("org.jetbrains.kotlin:kotlin-reflect")
	compile("org.springframework.boot:spring-boot-starter-web")
	compile("org.springframework.boot:spring-boot-starter-data-jpa")
	compile("org.springframework.boot:spring-boot-starter-actuator")
	compile("com.h2database:h2")
	compile("com.fasterxml.jackson.module:jackson-module-kotlin")
	testCompile("org.springframework.boot:spring-boot-starter-test")
	testCompile("org.amshove.kluent:kluent:1.29")
	//compile("org.springframework.boot:spring-boot-starter-security")
	//testCompile("org.springframework.security:spring-security-test")
}

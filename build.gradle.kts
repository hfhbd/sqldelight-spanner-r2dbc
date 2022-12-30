plugins {
    kotlin("jvm") version "1.7.22"
    id("app.cash.sqldelight") version "2.0.0-alpha04"
    id("com.google.cloud.artifactregistry.gradle-plugin") version "2.2.0"
    application
}

dependencies {
    implementation("app.cash.sqldelight:r2dbc-driver:2.0.0-alpha04")
    implementation("app.cash.sqldelight:async-extensions:2.0.0-alpha04")
    
    implementation("com.google.cloud:cloud-spanner-r2dbc:1.2.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor:1.6.4")
    
    implementation("org.slf4j:slf4j-simple:2.0.6")
    testImplementation(kotlin("test"))
}

kotlin {
    jvmToolchain(17)
}

sqldelight {
    database("Spanner") {
        dialect("app.cash.sqldelight:postgresql-dialect:2.0.0-alpha04")
        packageName = "app.softwork.spanner"
        generateAsync = true
    }
}

application {
    mainClass.set("app.softwork.spanner.MainKt")
}

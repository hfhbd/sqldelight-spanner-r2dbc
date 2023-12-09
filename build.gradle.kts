plugins {
    kotlin("jvm") version "1.9.21"
    id("app.cash.sqldelight") version "2.0.1"
    // id("com.google.cloud.artifactregistry.gradle-plugin") version "2.2.0"
    id("application")
}

dependencies {
    implementation("app.cash.sqldelight:r2dbc-driver:2.0.1")
    implementation("app.cash.sqldelight:async-extensions:2.0.1")

    implementation("com.google.cloud:cloud-spanner-r2dbc:1.2.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor:1.7.1")

    implementation("org.slf4j:slf4j-simple:2.0.6")
    testImplementation(kotlin("test"))
}

kotlin {
    jvmToolchain(17)
}

sqldelight {
    databases.register("Spanner") {
        dialect("app.cash.sqldelight:postgresql-dialect:2.0.1")
        packageName.set("app.softwork.spanner")
        generateAsync.set(true)
    }
}

application {
    mainClass.set("app.softwork.spanner.MainKt")
}

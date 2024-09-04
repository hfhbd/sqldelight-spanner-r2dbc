plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.licensee)
    alias(libs.plugins.sqldelight)
    application
}

dependencies {
    implementation(libs.sqldelight.r2dbc.driver)
    implementation(libs.sqldelight.async.extensions)

    implementation(libs.cloud.spanner.r2dbc)
    implementation(libs.coroutines.reactor)

    implementation(libs.logback)
    testImplementation(kotlin("test"))
}

kotlin {
    jvmToolchain(21)
}

sqldelight {
    databases.register("Spanner") {
        dialect(libs.sqldelight.postgresql.dialect)
        packageName.set("app.softwork.spanner")
        generateAsync.set(true)
    }
}

application {
    mainClass.set("app.softwork.spanner.MainKt")
}

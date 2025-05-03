plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.licensee)
    alias(libs.plugins.sqldelight)
    id("application")
}

dependencies {
    implementation(libs.sqldelight.r2dbc.driver)
    implementation(libs.sqldelight.async.extensions)

    implementation(libs.cloud.spanner.r2dbc)
    implementation(libs.coroutines.reactor)

    runtimeOnly(libs.logback)
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

licensee {
    allow("Apache-2.0")
    allow("MIT")
    allow("MIT-0")
    allow("EPL-1.0")
    allow("BSD-3-Clause")
    allowUrl("https://github.com/googleapis/api-common-java/blob/main/LICENSE") {
        because("BSD-3-Clause")
    }
    allowUrl("https://github.com/googleapis/gax-java/blob/master/LICENSE") {
        because("BSD-3-Clause")
    }
    allowUrl("https://spdx.org/licenses/MIT.txt") {
        because("MIT")
    }
    allowUrl("https://golang.org/LICENSE")
    allowUrl("https://github.com/javaee/javax.annotation/blob/master/LICENSE")
    allowUrl("https://raw.githubusercontent.com/ThreeTen/threetenbp/main/LICENSE.txt")
}

testing.suites.named("test", JvmTestSuite::class) {
    useKotlinTest()
}

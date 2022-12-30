pluginManagement {
    repositories {
        maven(url = "https://oss.sonatype.org/content/repositories/snapshots/")
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        maven(url = "https://oss.sonatype.org/content/repositories/snapshots/")
        mavenCentral()
    }
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
enableFeaturePreview("STABLE_CONFIGURATION_CACHE")

rootProject.name = "sqldelight-spanner-r2dbc"

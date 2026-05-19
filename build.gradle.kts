plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(ktorLibs.plugins.ktor)
}

kotlin {
    jvmToolchain(21)
}
dependencies {
    implementation(ktorLibs.client.core)
    implementation(ktorLibs.client.mock)

    testImplementation(kotlin("test"))
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.11.0")
}

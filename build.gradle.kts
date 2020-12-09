// https://github.com/komputing/kethabi/issues/6
val kethereumVersion = "0.83.0"

apply {
    from("https://raw.githubusercontent.com/ligi/gradle-common/master/versions_plugin_stable_only.gradle")
}

buildscript {
    repositories {
        maven("https://jitpack.io")
    }

    dependencies {
        classpath("com.github.ben-manes:gradle-versions-plugin:0.36.0")
    }
}

repositories {
    jcenter()
    maven("https://www.jitpack.io")
}
plugins {
    id("org.jetbrains.kotlin.jvm") version "1.4.21"
    maven
}

tasks.withType<Test> {
    useJUnitPlatform()
}

dependencies {
    implementation(gradleApi())
    implementation(localGroovy())
    implementation("com.squareup:kotlinpoet:1.6.0")

    implementation("com.squareup.moshi:moshi-kotlin:1.9.3")

    implementation("com.github.komputing.kethereum:abi:$kethereumVersion")
    implementation("com.github.komputing.kethereum:abi_codegen:$kethereumVersion")

    testImplementation("org.assertj:assertj-core:3.16.1")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.6.2")

    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("io.mockk:mockk:1.10.0")

}

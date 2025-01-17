// https://github.com/komputing/kethabi/issues/6
val kethereumVersion = "0.85.7"

repositories {
    mavenCentral()
    maven("https://www.jitpack.io")
}
plugins {
    id("org.jetbrains.kotlin.jvm") version "1.5.20"
    id("maven-publish")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

configure<PublishingExtension> {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }
}

dependencies {
    implementation(gradleApi())
    implementation(localGroovy())
    implementation("com.squareup:kotlinpoet:1.9.0")

    implementation("com.squareup.moshi:moshi-kotlin:1.12.0")

    implementation("com.github.komputing.kethereum:abi:$kethereumVersion")
    implementation("com.github.komputing.kethereum:abi_codegen:$kethereumVersion")

    testImplementation("org.assertj:assertj-core:3.20.2")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.2")

    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("io.mockk:mockk:1.11.0")

}

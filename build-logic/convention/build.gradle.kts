import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

group = "cc.ioctl.tmoe.buildlogic"

repositories {
    google()
    gradlePluginPortal()
    mavenCentral()
}

dependencies {
    implementation("com.android.tools.build:gradle:4.2.2")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.21")
    implementation("org.eclipse.jgit:org.eclipse.jgit:5.12.0.202106070339-r")
}

java {
    targetCompatibility = JavaVersion.VERSION_11
    sourceCompatibility = JavaVersion.VERSION_11
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "11"
    }
}

// 引入公钥进行签名或其他操作
val publicKey: String? = System.getenv("PUBLIC_KEY")
if (publicKey != null) {
    println("Public Key is set")
    // 在这里您可以添加使用公钥的代码，例如进行文件签名等操作
    val publicKeyFile = file("$projectDir/app/public_key.pem")
    if (publicKeyFile.exists()) {
        println("Public Key File: ${publicKeyFile.readText()}")
        // 可以在这里使用公钥文件进行进一步的操作
    }
}

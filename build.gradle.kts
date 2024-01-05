/*
 * This file was generated by the Gradle 'init' task.
 */

plugins {
   id("org.brokenarrow.storage.java-conventions")
}

dependencies {
    compileOnly("org.spigotmc:spigot-api:1.18.2-R0.1-SNAPSHOT")
    compileOnly("org.jetbrains:annotations:20.1.0")
    compileOnly("com.github.broken1arrow.Utility-Library:Utility-Library:0.72")
}

group = "org.brokenarrow.storage.api"
description = "CustomContainersAndHoppersAPI"


java {
    withJavadocJar()
}

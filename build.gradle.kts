
plugins {
   id("org.brokenarrow.storage.java-conventions")
}
val utilityVersion = "0.125"

dependencies {
    implementation("org.bstats:bstats-bukkit:3.0.2")
    
    compileOnly("de.tr7zw:item-nbt-api-plugin:2.13.1")
    compileOnly("com.google.code.findbugs:jsr305:3.0.2")
    compileOnly("org.spigotmc:spigot-api:1.20.4-R0.1-SNAPSHOT")
    compileOnly("org.jetbrains:annotations:20.1.0")
    compileOnly("me.clip:placeholderapi:2.11.6")
    compileOnly("com.bgsoftware:WildStackerAPI:3.8.1")
    compileOnly("com.bgsoftware:WildChestsAPI:2022.7")
    compileOnly("com.griefcraft:lwc:2.2.9-dev")
    compileOnly("com.sk89q.worldguard:worldguard-bukkit:7.0.5-SNAPSHOT")
    compileOnly("net.essentialsx:EssentialsX:2.19.0")
    compileOnly("com.github.MilkBowl:VaultAPI:1.7")
    compileOnly("com.mojang:authlib:1.6.25")
    compileOnly("com.github.angeschossen:LandsAPI:5.15.2")
    compileOnly("org.popcraft:bolt-bukkit:1.1.68")


    // JetsHopper system dependency
    compileOnly(files("/media/broken/Ny volym/PluginsJarUseForAPI/JetsHoppers-3.2.12.jar"))
    // CMILib system dependency
    compileOnly(files("/media/broken/Ny volym/PluginsJarUseForAPI//CMILib-0.0.20.jar"))
}

group = "org.brokenarrow.storage.api"
description = "CustomContainersAndHoppersAPI"


java {
    withJavadocJar()
}

plugins {
    id("dev.slne.surf.surfapi.gradle.paper-plugin")
}

group = "dev.slne"
version = "1.21.1.0.0-SNAPSHOT"

surfPaperPluginApi {
    mainClass("dev.slne.smaller.Smaller")
    authors.add("ammo")

    generateLibraryLoader(false)
}
package dev.slne.smaller

import org.bukkit.plugin.java.JavaPlugin

val plugin: Smaller get() = JavaPlugin.getPlugin(Smaller::class.java)

class Smaller : JavaPlugin() {

    override fun onEnable() {
        smallerCommand()
    }
}

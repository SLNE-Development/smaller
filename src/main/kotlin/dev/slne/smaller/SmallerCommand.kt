package dev.slne.smaller

import com.github.shynixn.mccoroutine.folia.entityDispatcher
import com.github.shynixn.mccoroutine.folia.launch
import com.github.shynixn.mccoroutine.folia.ticks
import dev.jorel.commandapi.kotlindsl.*
import dev.slne.surf.surfapi.core.api.messages.adventure.sendText
import kotlinx.coroutines.delay
import org.bukkit.attribute.Attribute
import org.bukkit.entity.Player

fun smallerCommand() = commandAPICommand("smaller") {
    playerArgument("target")
    integerArgument("delayTicks")
    doubleArgument("startScale", 0.01, 10.0)
    doubleArgument("endScale", 0.01, 10.0)
    booleanArgument("resetAtEnd", false)

    playerExecutor { player, args ->
        val target: Player by args
        val delayTicks: Int by args
        val endScale: Double by args
        val startScale: Double by args
        val resetAtEnd: Boolean by args

        var currentScale = startScale

        plugin.launch(plugin.entityDispatcher(target)) {
            val attribute = target.getAttribute(Attribute.SCALE) ?: error("No attribute found")

            while (currentScale > endScale) {
                attribute.baseValue = currentScale
                delay(delayTicks.ticks)
                currentScale -= 0.01
            }

            if(resetAtEnd) {
                attribute.baseValue = 1.0
            }

            player.sendText {
                appendPrefix()

                success("Done")
            }
        }
    }
}
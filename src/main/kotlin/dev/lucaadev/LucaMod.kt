package dev.lucaadev

import com.mojang.brigadier.CommandDispatcher
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback
import net.minecraft.command.CommandRegistryAccess
import net.minecraft.server.command.CommandManager
import net.minecraft.server.command.CommandManager.literal
import net.minecraft.server.command.ServerCommandSource
import net.minecraft.text.Text
import org.slf4j.LoggerFactory


object LucaMod : ModInitializer {
    private val logger = LoggerFactory.getLogger("lucafabricmod")

	override fun onInitialize() {
		logger.info("Hello Fabric world!")
        CommandRegistrationCallback.EVENT.register(CommandRegistrationCallback { dispatcher: CommandDispatcher<ServerCommandSource?>, _: CommandRegistryAccess?, _: CommandManager.RegistrationEnvironment? ->
            dispatcher.register(literal("silly")
                .executes { context ->
                    context.source.sendMessage(Text.literal("bleh :P :3"))
                    1
                })
        })
	}
}
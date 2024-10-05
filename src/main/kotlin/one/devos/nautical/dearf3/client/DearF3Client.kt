package one.devos.nautical.dearf3.client

import com.mojang.blaze3d.platform.InputConstants
import gay.asoji.fmw.FMW
import gay.asoji.innerpastels.client.ImGuiClient.panels
import gay.asoji.innerpastels.misc.DevDisclaimer
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper
import net.minecraft.client.KeyMapping
import net.minecraft.client.Minecraft
import one.devos.nautical.dearf3.client.panels.*
import org.lwjgl.glfw.GLFW
import org.slf4j.Logger
import org.slf4j.LoggerFactory

object DearF3Client : ClientModInitializer {
    val MOD_ID: String = "dearf3"
    val MOD_VERSION: String = FMW.getVersionString(MOD_ID)
    val MOD_NAME: String = FMW.getName(MOD_ID)
    val LOGGER: Logger = LoggerFactory.getLogger(MOD_ID)

    var isImGuiRenderEnabled: Boolean = false
        private set

    val DEARF3_MAPPING = KeyMapping(
        "key.dearf3.mapping",
        InputConstants.Type.KEYSYM,
        GLFW.GLFW_KEY_F3,
        "category.dearf3"
    )

    fun initializeKeybinds() {
        val toggleImGuiKeybind = KeyBindingHelper.registerKeyBinding(DEARF3_MAPPING)

        ClientTickEvents.END_CLIENT_TICK.register(::onTick)
    }

    fun onTick(client: Minecraft) {
        while (DEARF3_MAPPING.consumeClick()) {
            if (client.player != null && client.screen == null) {
                isImGuiRenderEnabled = !isImGuiRenderEnabled
            }
        }
    }

    fun imGuiInitialization() {
        panels.addAll(
            listOf(
//                object : ImGuiPanel { // anything that doesnt extend `ImGuiPanel`, do this
//                    override fun render(open_: ImBoolean) {
//                        ImGui.showDemoWindow() // no more demo window for now
//                    }
//
//                    override fun theme() {
//
//                    }
//                },
//                    DevDebugSpace

                BlockInformation,
                ClientInfo,
                EntityDetails,
                GameInformation,
                PlayerDetails
            )
        )

        initializeKeybinds()
    }

    override fun onInitializeClient() {
        // initialize dearimgui panels
        imGuiInitialization()

        DevDisclaimer.init()
    }
}
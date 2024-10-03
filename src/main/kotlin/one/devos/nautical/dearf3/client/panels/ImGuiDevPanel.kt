package one.devos.nautical.dearf3.client.panels

import gay.asoji.innerpastels.client.imgui.ImGuiPanel
import imgui.ImGui
import imgui.ImGui.begin
import imgui.ImGui.end
import imgui.ImGuiIO
import imgui.type.ImBoolean
import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
import net.minecraft.client.Minecraft
import one.devos.nautical.dearf3.client.DearF3Client


@Environment(EnvType.CLIENT)
object ImGuiDevPanel : ImGuiPanel {
    override fun render(open_: ImBoolean) {
        val open: ImBoolean = open_
        var io: ImGuiIO = ImGui.getIO()
//        val windowFlags:  = none
        val mainViewport = ImGui.getMainViewport()
        val client = Minecraft.getInstance()
        val clientCamera = client.getCameraEntity()!!


        ImGui.setWindowSize(600F, 300F)
        DearF3Client.LOGGER.info("Dev Panel loaded")
        if (!begin("DearF3 - Dev Panel", open)) {
            // Early out if the window is collapsed, as an optimization.
            end()
            return
        }

        end()
    }

    override fun theme() {

    }
}
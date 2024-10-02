package one.devos.nautical.dearf3.client.panels

import imgui.ImGui
import imgui.ImGuiIO
import net.minecraft.client.Minecraft

object Constants {
    val client = Minecraft.getInstance()
    val clientCamera = client.getCameraEntity()!!
    var io: ImGuiIO = ImGui.getIO()
}
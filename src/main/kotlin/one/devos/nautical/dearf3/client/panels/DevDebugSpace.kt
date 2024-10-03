package one.devos.nautical.dearf3.client.panels

import gay.asoji.innerpastels.client.imgui.ImGuiPanel
import imgui.ImGui
import imgui.ImGui.*
import imgui.type.ImBoolean
import one.devos.nautical.dearf3.client.DearF3Client

object DevDebugSpace : ImGuiPanel {
    // work on later
    override fun render(open_: ImBoolean) {
        val isDebugPanelOpen: Boolean = false

        DearF3Client.LOGGER.info("DearF3 Debug Space loaded")
        if (!ImGui.begin("DearF3")) {

            end()
            return
        }

        if (ImGui.beginMenuBar()) {
            if (ImGui.beginMenu("Tools")) {
                ImGui.menuItem("Debug Panel", "", ImBoolean(isDebugPanelOpen))
                endMenu()
            }
            endMenuBar()
        }

        if (isDebugPanelOpen) {
            ImGuiDevPanel
        }

        end()
    }

    override fun theme() {

    }
}
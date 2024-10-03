package one.devos.nautical.dearf3.client.panels

import gay.asoji.innerpastels.client.imgui.ImGuiPanel
import imgui.ImColor
import imgui.ImGui
import imgui.ImGui.*
import imgui.flag.ImGuiCol
import imgui.flag.ImGuiCond
import imgui.type.ImBoolean
import net.minecraft.util.Mth
import one.devos.nautical.dearf3.client.DearF3Client
import one.devos.nautical.dearf3.client.panels.Constants.clientCamera

object PlayerDetails : ImGuiPanel {
    override fun theme() {
        if (!DearF3Client.isImGuiRenderEnabled) {
            return
        }

        val theme = ImGui.getStyle()

        theme.setColor(ImGuiCol.TitleBg, ImColor.rgb("#562105"))
        theme.setColor(ImGuiCol.TitleBgActive, ImColor.rgb("#f3722c"))

        pushItemWidth(50F)
    }

    override fun render(open_: ImBoolean) {
        if (!DearF3Client.isImGuiRenderEnabled) {
            return
        }

        DearF3Client.LOGGER.info("Player Details loaded")
        if (!ImGui.begin("Player Position", open_)) {
            end()
            return
        }

        setWindowSize(400F, 85F, ImGuiCond.FirstUseEver)
        setWindowPos(50F, 655F, ImGuiCond.FirstUseEver)

        pushItemWidth(200F)
        inputFloat3("Co-ordinates", floatArrayOf(clientCamera?.x?.toFloat() ?: return, clientCamera?.y?.toFloat() ?: return, clientCamera?.z?.toFloat() ?: return))
        inputFloat2("Facing X/Y", floatArrayOf(Mth.wrapDegrees(clientCamera?.rotationVector?.x?.toFloat() ?: return), Mth.wrapDegrees(clientCamera?.rotationVector?.y?.toFloat() ?: return)))

        end()
    }
}
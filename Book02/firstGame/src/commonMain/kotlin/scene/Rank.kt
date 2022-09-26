package scene

import com.soywiz.korge.input.*
import com.soywiz.korge.scene.*
import com.soywiz.korge.ui.*
import com.soywiz.korge.view.*
import com.soywiz.korge.view.onClick
import com.soywiz.korim.format.*
import com.soywiz.korio.async.*
import com.soywiz.korio.file.std.*
import com.soywiz.korma.geom.*

class Rank() : Scene() {
    val textPos = Point(128, 128)
    val buttonWidth = 256.0
    val buttonHeight = 32.0
    val buttonPos = Point(128, 128 + 32)

    override suspend fun SContainer.sceneInit() {
        //加入圖片
        image(resourcesVfs["KenneyArt/gameplay_bg_grasslands.png"].readBitmap()) {
            scaledWidth = ConfigModule.size.width.toDouble()
            scaledHeight = ConfigModule.size.height.toDouble()
        }
        //顯示目前的畫面
        text("I'm in ${Rank::class.simpleName}") {
            position(textPos)
        }
        // 更換新版的Button物件
        uiButton("Go to Menu", null, buttonWidth, buttonHeight) {
            position(buttonPos)
            onClick {
                launchImmediately { sceneContainer.changeTo<Menu>() }
            }
        }
    }
}

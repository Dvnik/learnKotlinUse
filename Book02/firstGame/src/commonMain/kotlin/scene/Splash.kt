package scene

import com.soywiz.korge.input.*
import com.soywiz.korge.scene.*
import com.soywiz.korge.ui.*
import com.soywiz.korge.view.*
import com.soywiz.korim.color.*
import com.soywiz.korio.async.*
import com.soywiz.korma.geom.*

class Splash() : Scene() {
    val textPos = Point(128, 128)
    val buttonWidth = 256.0
    val buttonHeight = 32.0
    val buttonPos = Point(128, 128 + 32)

    override suspend fun SContainer.sceneInit() {
        //顯示目前的畫面
        text("I'm in ${Splash::class.simpleName}") {
            position(textPos)
        }
        //進到menu畫面的觸發按鈕
//        uiTextButton(buttonWidth, buttonHeight) {
//            text = "Go to Menu"
//            position(buttonPos)
//            onClick {
//                launchImmediately { sceneContainer.changeTo<Menu>() }
//            }
//        }
        // 更換新版的Button物件
        uiButton("Go to Menu", null, buttonWidth, buttonHeight) {
            position(buttonPos)
            onClick {
                launchImmediately { sceneContainer.changeTo<Menu>() }
            }
        }
        //加入更多文字
        text("tap to start") {
            val screenWidth = ConfigModule.size.width.toDouble()
            val screenHeight = ConfigModule.size.height.toDouble()
            position((screenWidth - scaledWidth)/2, (screenHeight - scaledHeight)/4)
            textSize = 30.0
            color = Colors.BLUE
            onClick{
                launchImmediately { sceneContainer.changeTo<Menu>() }
            }
        }
    }
}

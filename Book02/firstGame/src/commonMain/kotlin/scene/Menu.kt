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

class Menu() : Scene() {
    val textPos = Point(128, 128)
    val buttonWidth = 256.0
    val buttonHeight = 32.0
    val buttonPos = Point(128, 128 + 32)

    override suspend fun SContainer.sceneInit() {
        //加入圖片
        image(resourcesVfs["sandCar.jpeg"].readBitmap()) {
            scaledWidth = ConfigModule.size.width.toDouble()
            scaledHeight = ConfigModule.size.height.toDouble()
            anchor(0.5, 0.5)//改變圖片定錨點的位置，值的範圍:0.0~1.0。0.5就是中心點的位置。
            //以定錨點為中心在座標點(0,0)呈現圖片，其結果會變成在左上角(默認座標點起始位置)呈現圖片中心點，部分圖片超出視窗
            //因此還要將圖片移動到畫面中心，才會再次填滿整個視窗
            position(scaledWidth/2, scaledHeight/2)
            //Angle的init現在是隱藏值，且rotation這個值的屬性是final
            //改成這樣才會旋轉
            rotation(Angle.fromRadians(45.0))
        }
        //顯示目前的畫面
        text("I'm in ${Menu::class.simpleName}") {
            position(textPos)
        }
        // 更換新版的Button物件
        uiButton("Go to GamePlay", null, buttonWidth, buttonHeight) {
            position(buttonPos)
            onClick {
                launchImmediately { sceneContainer.changeTo<GamePlay>() }
            }
        }
    }
}

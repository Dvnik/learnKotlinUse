package scene

import ConfigModule
import com.soywiz.klock.*
import com.soywiz.korev.*
import com.soywiz.korge.input.*
import com.soywiz.korge.scene.*
import com.soywiz.korge.tween.*
import com.soywiz.korge.ui.*
import com.soywiz.korge.view.*
import com.soywiz.korge.view.onClick
import com.soywiz.korim.format.*
import com.soywiz.korio.async.*
import com.soywiz.korio.file.std.*
import com.soywiz.korma.geom.*

class GamePlay() : Scene() {
    val textPos = Point(128, 128)
    val buttonWidth = 256.0
    val buttonHeight = 32.0
    val buttonPos = Point(128, 128 + 32)

    override suspend fun SContainer.sceneInit() {
        mouse {
            click {
                println("mouse click")
            }
            over {
                println("mouse over")
            }
            down {
                println("mouse down")
            }
            up {
                println("mouse up")
            }
        }

        keys {
            down(Key.SPACE) {
                println("key down")
            }
            up(Key.SPACE) {
                println("key up")
            }
        }
        //加入Sprite Animation圖片
        val spirteMap = resourcesVfs["green_alien_walk.png"].readBitmap()
        val alienWalkAnimation = SpriteAnimation(
            spriteMap = spirteMap,
            spriteWidth = 72,
            spriteHeight = 97,
            marginTop = 0,
            marginLeft = 0,
            columns = 11,
            rows = 1,
            offsetBetweenColumns = 0,
            offsetBetweenRows = 0
        )
        val alien = sprite( alienWalkAnimation )
        alien.spriteDisplayTime = 0.1.seconds
        alien.playAnimationLooped()

        //行走動畫
//        while (true) {
//            alien.tween(alien::x[0.0,512.0], time = 5.seconds)
//            delay(1.seconds)
//        }


        val input = views.input

        text("") {
            text = "Mouse Position:${input.mouse}"
            position(input.mouse.x, input.mouse.y)
        }

        text("").addUpdater {
            when {
                input.keys.justPressed(Key.SPACE) -> {
                    println("Key just pressed.")
                }
                input.keys.pressing(Key.SPACE) -> {
                    println("Key pressing.")
                }
                input.keys.justReleased(Key.SPACE) -> {
                    println("Key justReleased.")
                }
            }
        }
        //顯示目前的畫面
        text("I'm in ${GamePlay::class.simpleName}") {
            position(textPos)
        }
        // 更換新版的Button物件
        uiButton("Go to GameOver", null, buttonWidth, buttonHeight) {
            position(buttonPos)
            onClick {
                launchImmediately { sceneContainer.changeTo<GameOver>() }
            }
        }


    }
}

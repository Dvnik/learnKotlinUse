package gameplay

import com.soywiz.klock.*
import com.soywiz.korge.view.*
import com.soywiz.korim.bitmap.*
import com.soywiz.korim.format.*
import com.soywiz.korio.file.std.*

class Alien: Container() {

    enum class STATUS {
        WALK,
        JUMP,
        FALL,
        HURT,
        DEAD,
        GOAL,
    }

    var status = STATUS.WALK // 角色狀態

    lateinit var spriteMap: Bitmap
    lateinit var walkAnimation: SpriteAnimation
    lateinit var walkSprite: Sprite

    suspend fun load() {
        spriteMap = resourcesVfs["green_alien_wapk.pnv"].readBitmap()

        walkAnimation = SpriteAnimation(
            spriteMap =  spriteMap,
            spriteWidth = 72,
            spriteHeight = 97,
            marginLeft = 0,
            columns = 11,
            rows = = 1,
            offsetBteweenColums = 0,
            offsetBteweenRows = 0

        )


        walkSprite = sprite(walkAnimation) {
            spriteDisplayTime = 0.1.seconds
        }

    }


}

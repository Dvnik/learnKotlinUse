package gameplay

import com.soywiz.korge.view.*
import com.soywiz.korim.format.*
import com.soywiz.korio.file.std.*

class Obstacle :Item() {
    override suspend fun load() {
        mImage = image(resourcesVfs["rock.png"].readBitmap())
    }

    override suspend fun position(x: Int, y: Int) {
        defaultx = x * BASE_WIDTH + (BASE_WIDTH - (mImage?.width ?: 0.0)) / 2

        position(defaultx, y * BASE_HEIGHT + (BASE_HEIGHT - (mImage?.height ?: 0.0)) / 2)
    }
}

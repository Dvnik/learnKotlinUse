package gameplay

import com.soywiz.korge.view.*
import com.soywiz.korim.format.*
import com.soywiz.korio.file.std.*

class Background: Item() {
    override suspend fun load() {
        mImage = image (resourcesVfs["KenneyArt/gameplay_bg_shroom.png"] .readBitmap () )
    }

    override suspend fun position(x: Int, y: Int) {
    }
}

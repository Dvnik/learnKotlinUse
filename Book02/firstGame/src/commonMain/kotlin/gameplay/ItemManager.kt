package gameplay

import com.soywiz.korge.view.*

object ItemManager {
    var items = arrayListOf<Item?>()
    suspend fun init() {
        items.clear()
        val stageValue = listOf<Int>(
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 2, 2, 2, 3, 2, 2, 4, 2,
            1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
        )
        // add items
        for (y in 0..7) {
            for (x in 0..13) {
                val item = when (ItemType.values()[stageValue[y * 14 + x]]) {
                    ItemType.FLOOR -> {//地板物件
                        Floor().apply {
                            load()
                            position(x, y)
                        }
                    }
                    ItemType.COIN -> {//金幣物件
                        Coin().apply {
                            load()
                            position(x, y)
                        }
                    }
                    ItemType.OBSTACLE -> {//障礙物物件
                        Obstacle().apply {
                            load()
                            position(x, y)
                        }
                    }
                    ItemType.ENEMY -> {//敵人物件
                        Enemy().apply {
                            load()
                            position(x, y)
                        }
                    }
                    else -> {
                        null//空物件
                    }
                }// end item
            }//end for x
        }//end for y
    }


    fun load(parentView: Container) {
        items.forEach{
            it?.run {
                parentView.addChild(this)
            }
        }
    }


}

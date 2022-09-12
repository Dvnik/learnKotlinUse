//import com.soywiz.klock.*
import com.soywiz.korge.*
//import com.soywiz.korge.scene.*
//import com.soywiz.korge.tween.*
//import com.soywiz.korge.view.*
import com.soywiz.korim.color.*
//import com.soywiz.korim.format.*
//import com.soywiz.korio.file.std.*
import com.soywiz.korma.geom.*
//import com.soywiz.korma.interpolation.*
//import java.lang.Module
// add new import
import com.soywiz.korge.scene.Module
import com.soywiz.korinject.AsyncInjector
import scene.*



//改寫入口程式，以便導向Splash場景
suspend fun main() = Korge(Korge.Config(module = ConfigModule))
//可藉由Korge.Config來佈置畫面
object ConfigModule: Module() {
    override val bgcolor: RGBA = Colors["#2b2b2b"]
    override val size = SizeInt(512, 512)
    override val mainScene = Splash::class
    //KorGE先寫好的依賴注入，讓場景不用每次都額外建立物件
    override suspend fun AsyncInjector.configure() {
        mapPrototype { Splash() }
        mapPrototype { Menu() }
        mapPrototype { GamePlay() }
        mapPrototype { GameOver() }
        mapPrototype { Rank() }
    }

}

//suspend fun main() = Korge(width = 512, height = 512, bgcolor = Colors["#2b2b2b"]) {
//	val sceneContainer = sceneContainer()
//
//	sceneContainer.changeTo({ MyScene() })
//}
//class MyScene : Scene() {
//	override suspend fun SContainer.sceneMain() {
//		val minDegrees = (-16).degrees
//		val maxDegrees = (+16).degrees
////        val image = image(resourcesVfs["korge.png"].readBitmap()) {
//		val image = image(resourcesVfs["apple.jpg"].readBitmap()) {
//			rotation = maxDegrees
//			anchor(.5, .5)
//			scale(0.8)
//			position(256, 256)
//		}
//
//		while (true) {
//			image.tween(image::rotation[minDegrees], time = 1.seconds, easing = Easing.EASE_IN_OUT)
//			image.tween(image::rotation[maxDegrees], time = 1.seconds, easing = Easing.EASE_IN_OUT)
//		}
//	}
//}

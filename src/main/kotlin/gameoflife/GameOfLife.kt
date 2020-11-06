@file:JvmName("GameOfLife")

package gameoflife

import kotlin.concurrent.timer
import kotlin.random.Random.Default.nextInt

fun main() {
    val sizeX = nextInt(10)
    val sizeY = nextInt(10)
    var world = World.random(sizeX, sizeY)
    println("Initialized world of size $sizeX x $sizeY")
    timer(period = 5000, action = {
        println("Regeneration!")
        world = world.regenerate()
        world.cells.forEach(::println)
    })
}
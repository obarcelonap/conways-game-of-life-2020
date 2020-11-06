package gameoflife

import gameoflife.GameOfLife.Factory.gameOfLife
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class GameOfLifeSpec : StringSpec() { init {

    "it should create a random world of the specified size" {
        val world = gameOfLife(10, 10)
        world.size shouldBe 100
    }
}
}

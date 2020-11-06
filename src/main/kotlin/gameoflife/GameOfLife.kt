package gameoflife

import kotlin.random.Random

class GameOfLife {
    companion object Factory {
        fun gameOfLife(sizeX: Int, sizeY: Int): World =
                World(
                        generateSequence {
                            cellSequence()
                                    .take(sizeX)
                                    .toList()
                        }
                                .take(sizeY)
                                .toList()
                )

        private fun cellSequence() = generateSequence {
            if (Random.nextBoolean()) Alive else Dead
        }
    }
}
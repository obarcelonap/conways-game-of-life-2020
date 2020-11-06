package gameoflife

import gameoflife.World.Factory.world
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import io.kotlintest.tables.forAll
import io.kotlintest.tables.headers
import io.kotlintest.tables.row
import io.kotlintest.tables.table

class WorldSpec : StringSpec() { init {

    "it should count the alive neighbours in the world" {
        val testTable = table(
                headers("world", "coords", "aliveNeighbours"),
                row(world(listOf(Dead, Dead, Dead)), Coords(0, 0), 0),
                row(world(listOf(Dead, Dead, Dead)), Coords(1, 0), 0),
                row(world(listOf(Dead, Dead, Dead)), Coords(2, 0), 0),

                row(world(listOf(Alive, Dead, Dead)), Coords(0, 0), 0),
                row(world(listOf(Alive, Dead, Dead)), Coords(1, 0), 1),
                row(world(listOf(Alive, Dead, Dead)), Coords(2, 0), 0),

                row(world(listOf(Dead, Alive, Dead)), Coords(0, 0), 1),
                row(world(listOf(Dead, Alive, Dead)), Coords(1, 0), 0),
                row(world(listOf(Dead, Alive, Dead)), Coords(2, 0), 1),

                row(world(listOf(Dead, Dead, Alive)), Coords(0, 0), 0),
                row(world(listOf(Dead, Dead, Alive)), Coords(1, 0), 1),
                row(world(listOf(Dead, Dead, Alive)), Coords(2, 0), 0),

                row(world(
                        listOf(Dead),
                        listOf(Dead),
                        listOf(Dead)),
                        Coords(0, 0), 0),
                row(world(
                        listOf(Dead),
                        listOf(Dead),
                        listOf(Dead)),
                        Coords(0, 1), 0),
                row(world(
                        listOf(Dead),
                        listOf(Dead),
                        listOf(Dead)),
                        Coords(0, 2), 0),

                row(world(
                        listOf(Dead),
                        listOf(Alive),
                        listOf(Dead)),
                        Coords(0, 0), 1),
                row(world(
                        listOf(Dead),
                        listOf(Alive),
                        listOf(Dead)),
                        Coords(0, 1), 0),
                row(world(
                        listOf(Dead),
                        listOf(Alive),
                        listOf(Dead)),
                        Coords(0, 2), 1),

                row(world(
                        listOf(Dead),
                        listOf(Dead),
                        listOf(Alive)),
                        Coords(0, 0), 0),
                row(world(
                        listOf(Dead),
                        listOf(Dead),
                        listOf(Alive)),
                        Coords(0, 1), 1),
                row(world(
                        listOf(Dead),
                        listOf(Dead),
                        listOf(Alive)),
                        Coords(0, 2), 0),

                row(world(
                        listOf(Alive, Dead, Dead),
                        listOf(Dead, Dead, Dead),
                        listOf(Dead, Dead, Dead)),
                        Coords(0, 0), 0),
                row(world(
                        listOf(Alive, Dead, Dead),
                        listOf(Dead, Dead, Dead),
                        listOf(Dead, Dead, Dead)),
                        Coords(1, 0), 1),
                row(world(
                        listOf(Alive, Dead, Dead),
                        listOf(Dead, Dead, Dead),
                        listOf(Dead, Dead, Dead)),
                        Coords(2, 0), 0),
                row(world(
                        listOf(Alive, Dead, Dead),
                        listOf(Dead, Dead, Dead),
                        listOf(Dead, Dead, Dead)),
                        Coords(0, 1), 1),
                row(world(
                        listOf(Alive, Dead, Dead),
                        listOf(Dead, Dead, Dead),
                        listOf(Dead, Dead, Dead)),
                        Coords(1, 1), 1),
                row(world(
                        listOf(Alive, Dead, Dead),
                        listOf(Dead, Dead, Dead),
                        listOf(Dead, Dead, Dead)),
                        Coords(2, 1), 0),
                row(world(
                        listOf(Alive, Dead, Dead),
                        listOf(Dead, Dead, Dead),
                        listOf(Dead, Dead, Dead)),
                        Coords(0, 2), 0),
                row(world(
                        listOf(Alive, Dead, Dead),
                        listOf(Dead, Dead, Dead),
                        listOf(Dead, Dead, Dead)),
                        Coords(1, 2), 0),
                row(world(
                        listOf(Alive, Dead, Dead),
                        listOf(Dead, Dead, Dead),
                        listOf(Dead, Dead, Dead)),
                        Coords(2, 2), 0)
        )

        forAll(testTable) { world, (x, y), aliveNeighbours ->
            val count = world.countAliveNeighbours(x, y)
            count shouldBe aliveNeighbours
        }
    }
}
}
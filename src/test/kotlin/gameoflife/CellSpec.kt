package gameoflife

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import io.kotlintest.tables.forAll
import io.kotlintest.tables.headers
import io.kotlintest.tables.row
import io.kotlintest.tables.table

class CellSpec : StringSpec() { init {

    "it should regenerate considering number of alive neighbours" {
        val testTable = table(
                headers("cell", "neighbours", "result"),
                row(Alive, 1, Dead),
                row(Alive, 4, Dead),
                row(Alive, 2, Alive),
                row(Alive, 3, Alive),
                row(Dead, 3, Alive)
        )
        forAll(testTable) { cell, neighbours, result ->
            cell.regenerate(neighbours) shouldBe result
        }
    }
}
}
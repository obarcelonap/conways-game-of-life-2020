package gameoflife

class World(val cells: List<List<Cell>>) {
    val size: Int = cells.map { it.size }.sum()

    companion object Factory {
        fun world(vararg cells: List<Cell>) = World(cells.toList())
    }

    fun regenerate(): World = World(
            cells.mapIndexed { y, row ->
                row.mapIndexed { x, cell ->
                    cell.regenerate(countAliveNeighbours(x, y))
                }
            }
    )

    fun countAliveNeighbours(x: Int, y: Int): Int {
        return listOf(
                Coords(x - 1, y - 1), Coords(x, y - 1), Coords(x + 1, y - 1),
                Coords(x - 1, y), /* Coords(x, y), */ Coords(x + 1, y),
                Coords(x - 1, y + 1), Coords(x, y + 1), Coords(x + 1, y + 1)
        )
                .map(this::countIfAlive)
                .sum()
    }

    private fun countIfAlive(coords: Coords) = countIfAlive(coords.x, coords.y)

    private fun countIfAlive(x: Int, y: Int) =
            if (y >= 0
                    && y < cells.size
                    && x >= 0
                    && x < cells[y].size
                    && cells[y][x].alive)
                1
            else
                0

    override fun toString(): String {
        return "World(cells=$cells)"
    }
}

data class Coords(val x: Int, val y: Int)

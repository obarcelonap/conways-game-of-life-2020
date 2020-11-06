package gameoflife

abstract class Cell(val alive: Boolean) {
    abstract fun regenerate(neighbours: Int): Cell
}

object Alive : Cell(true) {
    override fun regenerate(neighbours: Int): Cell {
        if (neighbours == 2 || neighbours == 3) {
            return Alive
        }
        return Dead
    }
}

object Dead : Cell(false) {
    override fun regenerate(neighbours: Int): Cell {
        if (neighbours == 3) {
            return Alive
        }
        return Dead
    }
}

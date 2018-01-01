object AoC_Day3 {

    fun solvePt1(input: Int) : Int {
        val bottomRights = (1..(Math.sqrt(input.toDouble()).toInt()+2)).filter { it % 2 != 0 }.map { it * it }.asReversed()
        if (bottomRights.contains(input)) return (bottomRights.size-2)*2
        val width = (bottomRights[0] - bottomRights[1]) / 4
        val cartesians = (0..3).map { bottomRights[0] - width * it - width / 2 }
        return Math.abs(input - cartesians.first { Math.abs(input - it) < width/2 }) + bottomRights.size - 1
    }

    data class GridNode(val x: Int, val y: Int, val value: Int)

    data class State(val w: Int, val x: Int, val y: Int, val side: Int, val nodes: List<GridNode>)

    fun sumNeighbours(x: Int, y: Int, neighbours: List<GridNode>) : Int =
        (-1..1).fold(0) { accX, ix ->
            accX + (-1..1).fold(0) { accY, iy ->
                accY + (neighbours.firstOrNull { node -> node.x == x + ix && node.y == y + iy }?.value ?: 0)
            }
        }

    fun solvePt2(input: Int) : Int =
        generateSequence(State(1, 1, 0, 0, listOf(GridNode(0,0,1)))) {
            val newNodes = it.nodes.plus(GridNode(it.x, it.y, sumNeighbours(it.x, it.y, it.nodes)))
            val halfWidth = (it.w +1)/2
            when (it.side) {
                0 -> if (Math.abs(it.y+1) > halfWidth) State(it.w, it.x-1, it.y, it.side+1, newNodes) else State(it.w, it.x, it.y+1, it.side, newNodes)
                1 -> if (Math.abs(it.x-1) > halfWidth) State(it.w, it.x, it.y-1, it.side+1, newNodes) else State(it.w, it.x-1, it.y, it.side, newNodes)
                2 -> if (Math.abs(it.y-1) > halfWidth) State(it.w, it.x+1, it.y, it.side+1, newNodes) else State(it.w, it.x, it.y-1, it.side, newNodes)
                else -> if (Math.abs(it.x+1) > halfWidth) State(it.w+2, it.x+1, it.y, 0, newNodes) else State(it.w, it.x+1, it.y, it.side, newNodes)
            }
        }.takeWhileInclusive { it.nodes.last().value <= input }.last().nodes.last().value
}
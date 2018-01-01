object AoC_Day14 {

    val initialKnotState = (0..255).toList()

    fun parseHashes(input: String) : List<String> {
        val rows = (0 until 128).map { input + "-" + it }
        return rows.map { AoC_Day10.solvePt2(it, initialKnotState) }
    }



    fun solvePt1(input: String) : Int {
        val hashes =  parseHashes(input)
        val asd = hashes.flatMap { it.toCharArray().toList().map { char -> java.lang.Long.parseLong(char.toString(), 16).toString(2).padStart(4, '0') } }
        val count = asd.fold(0) {acc, value -> acc + value.toCharArray().count { it == '1'}}
        return count
    }

    fun findRowAndColOfUngrouped(input: List<List<Int>>) : Pair<Int, Int> {
        input.foldIndexed(0) {acc, rowIndex, row ->
            val firstIndex = row.indexOf(1)
            if (firstIndex >= 0) return Pair(rowIndex, firstIndex) else acc
        }
        return Pair(-1, -1)
    }

    fun validAdjacents(current: Pair<Int,Int>) : List<Pair<Int,Int>> =
        listOf(Pair(current.first-1, current.second), Pair(current.first+1, current.second), Pair(current.first, current.second-1), Pair(current.first, current.second+1)).filter { it.first in 0..127 && it.second in 0..127 }

    fun setGroupValue(grid: List<List<Int>>, targetRow: Int, targetCol: Int, group: Int) : List<List<Int>> {
        return grid.mapIndexed { rowIndex: Int, row: List<Int> ->  if (rowIndex == targetRow) row.mapIndexed { colIndex: Int, col: Int -> if (colIndex == targetCol) group else col } else row }
    }

    // TODO: Clean up this mess
    fun identifyCoordsOfGroup(grid: List<List<Int>>, current: Pair<Int, Int>, currentGroup: Int) : List<List<Int>> {
        var state = grid
        state = setGroupValue(state, current.first, current.second, currentGroup)
        val adj = validAdjacents(current)
        for (a in adj) {
            state =  if (state[a.first][a.second] == 1) identifyCoordsOfGroup(state, a, currentGroup) else state
        }
        return state
    }

    fun printGrid(grid: List<List<Int>>) {
        println()
        for (y in grid) {
            for (x in y) {
                print(x)
            }
            println()
        }
    }

    data class State(val current: Pair<Int, Int>, val currentGroup: Int, val bits: List<List<Int>>)

    fun solvePt2(input: String) : Int {
        val hashes =  parseHashes(input)
        val bits = hashes.map { it.toCharArray().toList().map { char -> java.lang.Long.parseLong(char.toString(), 16).toString(2).padStart(4, '0') }.joinToString("").toCharArray().map { it.toInt() - 48} }
        val startState = State(findRowAndColOfUngrouped(bits), 2, bits)
        return generateSequence(startState) { (current, currentGroup, state) ->
            val newBits = identifyCoordsOfGroup(state, current, currentGroup)
            State(findRowAndColOfUngrouped(newBits), currentGroup + 1, newBits)
        }.takeWhile { it.current.first != -1 }.last().bits.flatMap { it }.max()!!
    }
}
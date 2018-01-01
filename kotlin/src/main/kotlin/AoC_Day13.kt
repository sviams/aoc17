object AoC_Day13 {

    fun parseInput(input: List<String>) : Map<Int, List<Int>> =
        input.associate {
            val split = it.split(": ")
            val depth = split[1].trim().toInt()
            split[0].toInt() to (0 until depth).toList() + (depth-2 downTo 1).toList()
        }

    fun gotCaught(state: Map<Int, List<Int>>, delay: Int) : Boolean =
        state.any { (index, range) -> range[(index + delay) % range.size] == 0 }

    fun accumulatePenalty(state: Map<Int, List<Int>>) : Int =
        state.keys.fold(0) {acc, index ->
            val range = state[index]!!
            if (range[index % range.size] == 0) acc + (range.size/2 +1) * index else acc
        }

    fun solvePt1(input: List<String>) : Int = accumulatePenalty(parseInput(input))

    fun solvePt2(input: List<String>) : Int {
        val startState = parseInput(input)
        return generateSequence(0) { it + 1 }.takeWhileInclusive { gotCaught(startState, it) }.last()
    }

}
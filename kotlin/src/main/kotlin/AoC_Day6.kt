
object AoC_Day6 {

    data class State(val steps: Int, val work: Array<Byte>, val mem: MutableList<Array<Byte>>) {
        fun repeats() : Boolean = mem.count { it contentEquals work } > 1
    }

    fun solve2(input: Array<Byte>) : State {
        val width = input.size
        return generateSequence(State(0, input, mutableListOf(input.copyOf()))) { (steps, work, mem) ->
            val startIndex = work.indexOfFirst { it == work.max() }
            val toBeMovedValue = work[startIndex]
            work[startIndex] = 0
            (toBeMovedValue downTo 1).fold((startIndex+1) % width) { index, _ ->
                work[index]++
                (index + 1) % width
             }
            mem.add(work.copyOf())
            State(steps + 1, work, mem)
        }.takeWhileInclusive { !it.repeats() }.last()
    }

    fun solvePt1(work: Array<Byte>) : Int = solve2(work).steps

    fun solvePt2(work: Array<Byte>) : Int {
        val endState = solve2(work)
        return endState.mem.size - endState.mem.indexOfFirst { it contentEquals endState.mem.last() } - 1
    }
}


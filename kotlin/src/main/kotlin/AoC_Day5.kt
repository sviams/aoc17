
object AoC_Day5 {


    data class State(val steps: Int, val index: Int, val prev: Int, val mem: List<Int>)

    fun solvePt1(input: List<Int>) : Int =
        generateSequence(State(0,0,0, input)) { (steps, index, prev, mem) ->
            val newMem = mem.toMutableList().apply { this[prev]++ }
            State(steps+1, index + newMem[index], index, newMem)
        }.takeWhile { it.index < input.size }.last().steps + 2


    fun solvePt2(input: List<Int>) : Int =
        generateSequence(State(0,0,0, input)) { (steps, index, prev, mem) ->
            val newMem = mem.toMutableList().apply { this[prev] += if (this[prev] >= 3) -1 else 1 }
            State(steps+1, index + newMem[index], index, newMem)
        }.takeWhile { it.index < input.size }.last().steps + 2

    fun solvePt2Imperative(input: Array<Int>) : Int {
        val mem = input.copyOf()
        var steps = 0
        var index = 0
        var prev = 0
        while (index < input.size) {
            index += mem[index]
            mem[prev] += if (mem[prev] >= 3) -1 else 1
            prev = index
            steps++
        }
        return steps
    }

}
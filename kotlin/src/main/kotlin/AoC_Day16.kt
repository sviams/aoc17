import kotlin.streams.asStream

object AoC_Day16 {
    val startState = ('a'..'p').joinToString("").toCharArray()
    val size = startState.size

    fun parseMoves(instructions: List<String>) : List<(CharArray) -> CharArray> {
        return instructions.fold(listOf()) { acc, instruction -> acc + parseInstruction(instruction) }
    }

    fun parseInstruction(input: String) : (CharArray) -> CharArray {
        return when (input.first()) {
            's' -> spinFunc(input.substring(1 until input.length).toInt())
            'x' -> {
                val split = input.substring(1 until input.length).split("/")
                exchangeFunc(split[0].toInt(), split[1].toInt())
            }
            else -> {
                val chars = input.toCharArray()
                partnerFunc(chars[1], chars[3])
            }
        }
    }

    fun spinFunc(moves: Int) : (CharArray) -> CharArray =
        {state -> state.sliceArray(size-moves until size) + state.sliceArray(0 until size-moves)}

    fun exchangeFunc(first: Int, second: Int) : (CharArray) -> CharArray {
        val lower = Math.min(first, second)
        val upper = Math.max(first, second)
        return {state -> state.sliceArray(0 until lower) + state[upper] + state.sliceArray((lower+1) until upper) + state[lower] + state.sliceArray((upper+1) until size) }
    }

    fun partnerFunc(first: Char, second: Char) : (CharArray) -> CharArray =
        {state -> exchangeFunc(state.indexOf(first), state.indexOf(second))(state)}

    fun doAll(moves: List<(CharArray) -> CharArray>, initState: CharArray) : CharArray =
        moves.fold(initState) {state, move -> move(state)}

    fun solvePt1(input: Sequence<String>) : String {
        val moveOps = parseMoves(input.first().split(","))
        return doAll(moveOps, startState).joinToString("")
    }

    fun solvePt2(input: Sequence<String>) : String {
        val moveOps = parseMoves(input.first().split(","))
        val initial = doAll(moveOps, startState)
        val repeatCycle = generateSequence(initial) { doAll(moveOps, it) }.takeWhileInclusive { !(it contentEquals startState) }
        return repeatCycle.take(1000000000 % repeatCycle.count()).last().joinToString("")
    }
}
object AoC_Day25 {


    // Yet another concession to mutability...first effort with immutable tape took 27s :(
    data class CpuState(val tape: MutableMap<Int, Int>, val nextOp: Char, val cursor: Int, val pc: Long, val stopCond: Long)

    fun parseInput(input: List<String>) : Pair<CpuState, Map<Char, (CpuState) -> CpuState>> {
        val startOp = input.first().split(" ")[3].toCharArray().first()
        val stopCond = input.get(1).split(" ")[5].toLong()
        val opInput = input.drop(3).chunked(10).associate { it.first().split(" ")[2].toCharArray().first() to parseOp(it.drop(1)) }
        return Pair(CpuState(HashMap(5000), startOp, 0, 0, stopCond), opInput)
    }

    fun parseSetValue(line: String) : Int = line.trimStart().split(" ")[4].toCharArray().first().toString().toInt()

    fun parseDirectionValue(line: String) : Int = if (line.trimStart().split(" ")[6].contains("left")) -1 else 1

    fun parseNextStateValue(line: String) : Char = line.trimStart().split(" ")[4].toCharArray().first()

    fun parseOp(input: List<String>) : (CpuState) -> CpuState {
        val setIfZero = parseSetValue(input[1])
        val dirIfZero = parseDirectionValue(input[2])
        val nextIfZero = parseNextStateValue(input[3])
        val setIfOne = parseSetValue(input[5])
        val dirIfOne = parseDirectionValue(input[6])
        val nextIfOne = parseNextStateValue(input[7])
        return { s ->
            if (s.tape[s.cursor] == 1) {
                s.tape[s.cursor] = setIfOne
                CpuState(s.tape, nextIfOne, s.cursor + dirIfOne, s.pc + 1, s.stopCond)
            } else {
                s.tape[s.cursor] = setIfZero
                CpuState(s.tape, nextIfZero, s.cursor + dirIfZero, s.pc + 1, s.stopCond)
            }
        }
    }

    fun solvePt1(input: List<String>) : Int {
        val parsed = parseInput(input)
        val startState = parsed.first
        val ops : Map<Char, (CpuState) -> CpuState> = parsed.second
        val endState =  generateSequence(startState) {
            ops[it.nextOp]!!(it)
        }.takeWhile { it.pc < it.stopCond }.last()
        return endState.tape.values.sum()
    }

}
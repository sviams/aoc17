object AoC_Day18 {
    fun registers(pgId: Long) = mapOf<Char, Long>('a' to 0,'i' to 0, 'p' to pgId, 'b' to 0, 'f' to 0, 'x' to 0)

    data class State(val registers: Map<Char, Long>, val pc: Long, val isTerminated: Boolean, val sendQ: List<Long>, val recvQ: List<Long>, val isWaiting: Boolean)

    fun parseOps(instructions: List<String>) : List<(State) -> State> = instructions.fold(listOf()) { acc, instr -> acc + parseInstruction(instr) }

    fun parseInstruction(input: String) : (State) -> State {
        val split = input.split(" ")
        return when (split[0]) {
            "snd" -> sndFunc(split[1])
            "set" -> setFunc(split[1].first(), split[2])
            "add" -> addFunc(split[1].first(), split[2])
            "mul" -> mulFunc(split[1].first(), split[2])
            "mod" -> modFunc(split[1].first(), split[2])
            "rcv" -> rcvFunc(split[1].first())
            else -> jgzFunc(split[1], split[2])
        }
    }

    fun parseValue(str: String, state: State) : Long = if (str.first().isDigit() || str.first() == '-') str.toLong() else state.registers[str.first()]!!

    fun shouldStop(state: State, maxOps: Int) : Boolean = !(state.pc in 0..(maxOps - 1))

    fun sndFunc(valueStr: String) : (State) -> State = {
        State(it.registers.plus(Pair('x', it.registers['x']!! + 1)), it.pc + 1, false, it.sendQ + parseValue(valueStr, it), it.recvQ, false)
    }

    fun setFunc(register: Char, value: String) : (State) -> State = {
        State(it.registers.plus(Pair(register, parseValue(value, it))), it.pc + 1, false, it.sendQ, it.recvQ, false)
    }

    fun addFunc(register: Char, value: String) : (State) -> State = {
        State(it.registers.plus(Pair(register, it.registers[register]!! + parseValue(value, it))), it.pc + 1, false, it.sendQ, it.recvQ, false)
    }

    fun mulFunc(register: Char, value: String) : (State) -> State = {
        State(it.registers.plus(Pair(register, it.registers[register]!! * parseValue(value, it))), it.pc + 1, false, it.sendQ, it.recvQ, false)
    }

    fun modFunc(register: Char, value: String) : (State) -> State = {
        State(it.registers.plus(Pair(register, it.registers[register]!! % parseValue(value, it))), it.pc + 1, false, it.sendQ, it.recvQ, false)
    }

    fun rcvFunc(register: Char) : (State) -> State = {
        if (it.recvQ.any()) State(it.registers.plus(Pair(register, it.recvQ.first())), it.pc + 1, false, it.sendQ, it.recvQ.drop(1), false)
        else State(it.registers, it.pc, false, it.sendQ, it.recvQ, true)
    }

    fun jgzFunc(register: String, value: String) : (State) -> State = {
        if (parseValue(register, it) > 0) State(it.registers,it.pc + parseValue(value, it), false, it.sendQ, it.recvQ, false) else State(it.registers,it.pc + 1, false, it.sendQ, it.recvQ, false)
    }
    
    fun doOneOp(it: State, ops: List<(State) -> State>) : State = ops[it.pc.toInt()](it)

    fun incrementState(ops: List<(State) -> State>, one: State, two: State) : State = generateSequence(State(one.registers, one.pc, shouldStop(one, ops.size), emptyList(), two.sendQ, false)) { doOneOp(it, ops) }.takeWhileInclusive { !shouldStop(it, ops.size) && !it.isWaiting }.last()

    fun solvePt1(input: List<String>) : Long {
        val ops = parseOps(input)
        val startState = State(registers(0), 0,false, emptyList(), emptyList(), false)
        return generateSequence(startState) { doOneOp(it, ops) }.takeWhile { !shouldStop(it, ops.size) && !it.isWaiting }.last().sendQ.last()
    }

    fun solvePt2(input: List<String>) : Long {
        val ops = parseOps(input)
        val oneStateStart = State(registers(0), 0,false, emptyList(), emptyList(), false)
        val twoStateStart = State(registers(1), 0,false, emptyList(), emptyList(), false)
        val endState = generateSequence(Pair(oneStateStart, twoStateStart)) { (one, two) ->
            val firstUntilHalt = incrementState(ops, one, two)
            val secondUntilHalt = incrementState(ops, two, firstUntilHalt)
            Pair(firstUntilHalt, secondUntilHalt)
        }.takeWhile {
            !(it.first.isWaiting && it.second.isWaiting && it.first.sendQ.isEmpty() && it.second.sendQ.isEmpty()) &&
            !(it.first.isWaiting && it.second.isTerminated && it.second.sendQ.isEmpty()) &&
            !(it.second.isWaiting && it.first.isTerminated && it.first.sendQ.isEmpty()) &&
            !(it.first.isTerminated && it.second.isTerminated)
        }.last()
        return endState.second.registers['x']!!
    }
}
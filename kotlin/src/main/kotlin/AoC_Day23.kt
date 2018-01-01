object AoC_Day23 {
    fun registers(aVal: Long) = mapOf<Char, Long>('a' to aVal,
            'b' to 0, 'c' to 0, 'd' to 0, 'e' to 0, 'f' to 0, 'g' to 0, 'h' to 0, 'x' to 0)

    data class State(val registers: Map<Char, Long>, val pc: Long, val isTerminated: Boolean)

    fun parseOps(instructions: List<String>) : List<(State) -> State> = instructions.fold(listOf()) { acc, instr -> acc + parseInstruction(instr) }

    fun parseInstruction(input: String) : (State) -> State {
        val split = input.split(" ")
        return when (split[0]) {
            "set" -> setFunc(split[1].first(), split[2])
            "sub" -> subFunc(split[1].first(), split[2])
            "mul" -> mulFunc(split[1].first(), split[2])
            else -> jnzFunc(split[1], split[2])
        }
    }

    fun parseValue(str: String, state: State) : Long = if (str.first().isDigit() || str.first() == '-') str.toLong() else state.registers[str.first()]!!

    fun shouldStop(state: State, maxOps: Int) : Boolean = !(state.pc in 0..(maxOps - 1))

    fun setFunc(register: Char, value: String) : (State) -> State = {
        State(it.registers.plus(Pair(register, parseValue(value, it))), it.pc + 1, false)
    }

    fun subFunc(register: Char, value: String) : (State) -> State = {
        State(it.registers.plus(Pair(register, it.registers[register]!! - parseValue(value, it))), it.pc + 1, false)
    }

    fun mulFunc(register: Char, value: String) : (State) -> State = {
        State(it.registers.plus(Pair(register, it.registers[register]!! * parseValue(value, it))).plus(Pair('x', (it.registers['x']!! + 1L))), it.pc + 1, false)
    }

    fun jnzFunc(register: String, value: String) : (State) -> State = {
        if (parseValue(register, it) != 0L) State(it.registers,it.pc + parseValue(value, it), false) else State(it.registers,it.pc + 1, false)
    }
    
    fun doOneOp(it: State, ops: List<(State) -> State>) : State = ops[it.pc.toInt()](it)

    fun solvePt1(input: List<String>) : Long {
        val ops = parseOps(input)
        val startState = State(registers(0), 0,false)
        return generateSequence(startState) { doOneOp(it, ops) }.takeWhile { !shouldStop(it, ops.size) }.last().registers['x']!!
    }

    fun solvePt2(input: List<String>) : Int {
        val seed = input.first().split(" ").last().toInt()
        val low = seed * 100 + 100000
        val high = low + 17000
        return (low..high step 17).fold(0) { acc, value ->
            if (notPrime(value)) acc + 1 else acc
        }
    }

    fun notPrime(num: Int) : Boolean {
        (2..num/2).forEach {
            if (num % it == 0) return true
        }
        return false
    }

    fun rewritten() : Int {
        val low = 81 * 100 + 100000
        val high = low + 17000
        var h = 0
        (low..high step 17).forEach { b ->
            var f = 1
            (2..b).forEach { d ->
                (2..b).forEach { e ->
                    if (d * e == b) f = 0
                }
            }
            if (f == 0) h++
        }
        return h
    }

    fun reconstructed() : Long {
        var a: Long = 1
        var b: Long = 81 * 100 + 100000
        var c: Long = b + 17000
        var d: Long = 0
        var e: Long = 0
        var f: Long = 0
        var g: Long = 0
        var h: Long = 0

        while (true) {
            f = 1
            d = 2
            while (g != 0L) {
                e = 2
                while (g != 0L) {
                    g = d * e - b
                    if (g == 0L) f = 0
                    e++
                    g = e
                    g -= b
                }
                d++
                g = d - b
            }
            if (f == 0L) h++
            g = b - c
            if (g == 0L) return h
            b += 17
        }
    }
}
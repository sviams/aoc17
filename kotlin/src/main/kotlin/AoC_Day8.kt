
object AoC_Day8 {

    private val ops = mapOf<String, (Int, Int) -> Int>(
            "inc" to { a, b -> a + b },
            "dec" to { a, b -> a - b }
    )

    private val preds = mapOf<String, (Int, Int) -> Boolean>(
            "<" to { a, b -> a < b },
            ">" to { a, b -> a > b },
            ">=" to { a, b -> a >= b },
            "<=" to { a, b -> a <= b },
            "==" to { a, b -> a == b },
            "!=" to { a, b -> a != b }
    )

    fun solvePt1(input: List<String>) : Int {
        val split = input.map { it.split(" ") }.asSequence()
        return split.fold(split.map { it[0] }.distinct().associateBy({it}, {0})) { regs, line ->
            if (preds[line[5]]!!(regs[line[4]]!!, line[6].toInt())) {
                regs.plus(Pair(line[0], ops[line[1]]!!(regs[line[0]]!!, line[2].toInt())))
            } else regs
        }.values.max()!!
    }

    fun solvePt2(input: List<String>) : Int {
        val split = input.map { it.split(" ") }.asSequence()
        val registers = split.map { it[0] }.distinct().associateBy({it}, {0}).toMutableMap()
        return split.fold(0) { highest, line ->
            if (preds[line[5]]!!(registers[line[4]]!!, line[6].toInt())) {
                registers[line[0]] = ops[line[1]]!!(registers[line[0]]!!, line[2].toInt())
                val maxVal = registers.values.max()!!
                if (maxVal > highest) maxVal else highest
            } else highest
        }
    }

}
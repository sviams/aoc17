object AoC_Day9 {

    const val START_GARBAGE = '<'
    const val END_GARBAGE = '>'
    const val START_GROUP = '{'
    const val END_GROUP = '}'
    const val NONE = ' '
    const val IGNORE = '!'

    fun solvePt1(input: Sequence<String>) : Int =
        input.fold(0) {acc, line ->
            acc + line.toCharArray().fold(Pair(listOf<Char>(NONE), 0)) { carry, currentChar ->
                if (carry.first.first() == IGNORE) Pair(carry.first.drop(1), carry.second)
                else when (currentChar) {
                    START_GARBAGE -> if (carry.first.first() != START_GARBAGE) Pair(listOf(currentChar) + carry.first, carry.second) else carry
                    START_GROUP -> if (carry.first.first() != START_GARBAGE) Pair(listOf(currentChar) + carry.first, carry.second) else carry
                    END_GROUP -> when (carry.first.first()) {
                        START_GROUP -> Pair(carry.first.drop(1), carry.second + carry.first.count { it == START_GROUP })
                        else -> carry
                    }
                    IGNORE -> Pair(listOf(IGNORE) + carry.first, carry.second)
                    END_GARBAGE -> when (carry.first.first()) {
                        START_GARBAGE -> Pair(carry.first.drop(1), carry.second)
                        else -> carry
                    }
                    else -> carry
                }
            }.second
        }

    fun solvePt2(input: Sequence<String>) : Int =
        input.fold(0) {acc, line ->
            acc + line.toCharArray().fold(Pair(listOf<Char>(NONE), 0)) { carry, currentChar ->
                when (carry.first.first()) {
                    IGNORE -> Pair(carry.first.drop(1), carry.second)
                    else -> when (currentChar) {
                        IGNORE -> Pair(listOf(IGNORE) + carry.first, carry.second)
                        START_GARBAGE -> when (carry.first.first()) {
                            START_GARBAGE -> Pair(carry.first, carry.second + 1)
                            else -> Pair(listOf(currentChar) + carry.first, carry.second)
                        }
                        END_GARBAGE -> if (carry.first.first() == START_GARBAGE) Pair(carry.first.drop(1), carry.second) else carry
                        else -> when (carry.first.first()) {
                            START_GARBAGE -> Pair(carry.first, carry.second + 1)
                            else -> carry
                        }
                    }
                }
            }.second
        }
}
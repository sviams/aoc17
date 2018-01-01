object AoC_Day19 {

    fun parseMap(lines: List<String>) : List<List<Char>> = lines.map { line -> line.toCharArray().toList() }

    data class Direction(val x: Int, val y: Int, val token: Char)
    data class State(val x: Int, val y: Int, val dir: Direction, val seen: List<Char>, val count: Int)

    val validChars = ('A'..'Z').toList()
    val validTokens = listOf('|', '-')

    fun findNewDirection(state: State, map: List<List<Char>>) : Direction {
        val newToken = if (state.dir.token == '|') '-' else '|'
        val goodStuff = validChars + newToken
        return when (state.dir.token) {
            '|' -> if (goodStuff.contains(map[state.y][state.x - 1])) Direction(-1, 0, newToken) else Direction(1, 0, newToken)
            else -> if (goodStuff.contains(map[state.y - 1][state.x])) Direction(0, -1, newToken) else Direction(0, 1, newToken)
        }
    }

    fun goToEnd(startIndex: Int, map: List<List<Char>>) = generateSequence(State(startIndex,0, Direction(0,1, '|'), emptyList(), 0)) {
        val current = map[it.y][it.x]
        when (current) {
            '+' -> {
                val newDirection = findNewDirection(it, map)
                State(it.x + newDirection.x, it.y + newDirection.y, newDirection, it.seen, it.count + 1)
            }
            ' ' -> State(0,0,Direction(0,0, '!'), it.seen, it.count)
            else -> if (validTokens.contains(current)) State(it.x + it.dir.x, it.y + it.dir.y, it.dir, it.seen, it.count + 1) else State(it.x + it.dir.x, it.y + it.dir.y, it.dir, it.seen + current, it.count + 1)
        }
    }.takeWhile { it.dir.token != '!' }.last()

    fun solve(input: List<String>) : State {
        val map = parseMap(input)
        return goToEnd(map[0].indexOf('|'), map)
    }

    fun solvePt1(input: List<String>) : String = solve(input).seen.joinToString("")
    fun solvePt2(input: List<String>) : Int = solve(input).count
}
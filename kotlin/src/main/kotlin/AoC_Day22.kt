import kotlin.collections.HashMap

object AoC_Day22 {

    // So...in Kotlin, Map<K,V> is actually a LinkedHashMap behind the scenes
    // because JetBrains want to preserve order, which might be useful when doing
    // transformations from List -> Map -> List or whatever.
    // It is however most harmful to insertion/removal performance when the map
    // grows large. Hence, in lieu of a native Kotlin unordered map implementation
    // I opted to extend HashMap with plus and pretend it's immutable
    fun <K,V> HashMap<K,V>.plus(pair: Pair<K,V>) : HashMap<K,V> {
        return this.apply { put(pair.first, pair.second) }
    }

    data class Position(val x: Int, val y: Int)

    fun turn(from: Position, change: Position) : Position =
            when (from) {
                UP -> if (change == RIGHT) RIGHT else LEFT
                LEFT -> if (change == RIGHT) UP else DOWN
                DOWN -> if (change == RIGHT) LEFT else RIGHT
                else -> if (change == RIGHT) DOWN else UP
            }

    fun reverse(from: Position) : Position =
            when (from) {
                UP -> DOWN
                LEFT -> RIGHT
                DOWN -> UP
                else -> LEFT
            }

    fun move(from: Position, direction: Position) = Position((from.x + direction.x), (from.y + direction.y))

    data class State(val pos: Position, val direction: Position, val accInfected: Int, val infected: HashMap<Position, Int>)

    val UP = Position(0,1)
    val LEFT = Position(-1,0)
    val DOWN = Position(0,-1)
    val RIGHT = Position(1, 0)

    val CLEAN : Int = 0
    val WEAK: Int = 1
    val INFECTED : Int = 2
    val FLAGGED : Int = 3

    fun parseStartState(input: List<String>): State {
        val center : Int = Math.ceil((input.size / 2).toDouble()).toInt()
        val infected = input.foldIndexed(emptyList<Position>()) { y, acc, row -> acc + lineToCoords(row, center-y, center)}
        val infMap: HashMap<Position, Int> = infected.associate { it to INFECTED }.toMap(HashMap(16))
        return AoC_Day22.State(Position(0, 0), UP, 0, infMap)
    }

    fun lineToCoords(row: String, y: Int, size: Int) : List<Position> =
        row.toCharArray().foldIndexed(emptyList()) {x, acc, c -> if (c == '#') acc + Position((x-size), y) else acc}

    fun solvePt1(input: List<String>, iterations: Int) : Int =
        generateSequence(parseStartState(input)) { state ->
            val current = state.infected.getOrDefault(state.pos, CLEAN)
            if (current == INFECTED) {
                val newDir = turn(state.direction, RIGHT)
                State(move(state.pos, newDir), newDir, state.accInfected, state.infected.plus(state.pos to CLEAN))
            } else {
                val newDir = turn(state.direction, LEFT)
                State(move(state.pos, newDir), newDir, state.accInfected + 1, state.infected.plus(state.pos to INFECTED))
            }
        }.take(iterations + 1).last().accInfected

    fun solvePt2(input: List<String>, iterations: Int) : Int =
        generateSequence(parseStartState(input)) { state ->
            when (state.infected[state.pos]) {
                INFECTED -> {
                    val newDir = turn(state.direction, RIGHT)
                    State(move(state.pos, newDir), newDir, state.accInfected, state.infected.plus(state.pos to FLAGGED))
                }
                WEAK -> {
                    State(move(state.pos, state.direction), state.direction, state.accInfected + 1, state.infected.plus(state.pos to INFECTED))
                }
                FLAGGED -> {
                    val newDir = reverse(state.direction)
                    State(move(state.pos, newDir), newDir, state.accInfected, state.infected.plus(state.pos to CLEAN))
                }
                else -> {
                    val newDir = turn(state.direction, LEFT)
                    State(move(state.pos, newDir), newDir, state.accInfected, state.infected.plus(state.pos to WEAK))
                }
            }
        }.take(iterations + 1).last().accInfected

}
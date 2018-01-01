object AoC_Day11 {

    data class Position(val x: Int, val y: Int) {
        fun distance(): Int {
            val absX = Math.abs(x)
            val absY = Math.abs(y)
            return if (absX < absY) Math.ceil((absY-absX).toDouble()/2).toInt() + absX else absX
        }
    }
    data class State(val pos: Position, val maxSteps: Int)

    private fun followMoves(moves: List<String>) : State =
        moves.fold(State(Position(0, 0), 0)) { state, value ->
            val oldPos = state.pos
            val newPos = when (value) {
                "ne" -> Position(oldPos.x +1, oldPos.y +1)
                "se" -> Position(oldPos.x +1, oldPos.y -1)
                "sw" -> Position(oldPos.x -1, oldPos.y -1)
                "nw" -> Position(oldPos.x -1, oldPos.y +1)
                "n" -> Position(oldPos.x, oldPos.y+2)
                else -> Position(oldPos.x, oldPos.y-2)
            }
            State(newPos, Math.max(newPos.distance(), state.maxSteps))
        }

    fun solvePt1(input: String) : Int = followMoves(input.split(",")).pos.distance()
    fun solvePt2(input: String) : Int = followMoves(input.split(",")).maxSteps
}
object AoC_Day10 {

    data class SparseState(val list: List<Int>, val currIdx: Int, val skip: Int)

    fun createSparse(stepSequence: Sequence<Int>, initial: SparseState) =
        stepSequence.fold(initial) { state, steps ->
            val endIndex = (state.currIdx + steps) % initial.list.size
            val changed = if (endIndex < state.currIdx) (state.list.subList(state.currIdx, state.list.size) + state.list.subList(0, endIndex)).reversed()
            else state.list.subList(state.currIdx, endIndex).reversed()
            val newList = if (endIndex < state.currIdx) changed.subList(changed.size-endIndex, changed.size) + state.list.subList(endIndex, state.currIdx) + changed.subList(0, changed.size - endIndex)
            else state.list.subList(0, state.currIdx) + changed + state.list.subList(endIndex, initial.list.size)
            SparseState(newList, (endIndex + state.skip) % initial.list.size, state.skip + 1)
        }

    fun sparseToDense(input: List<Int>) = (0..15).map { input.subList(it*16, (it+1)*16).fold(0) {acc, value -> acc.xor(value)} }

    fun denseToString(input: List<Int>) = input.joinToString("") { it.toString(16).padStart(2, '0')}

    fun solvePt1(input: String, initialState: List<Int>) : Int {
        val stepSequence = input.split(',').map { it.toInt() }.asSequence()
        val endState = createSparse(stepSequence, SparseState(initialState, 0, 0)).list
        return endState[0] * endState[1]
    }

    fun solvePt2(input: String, initialState: List<Int>) : String {
        val stepSequence = input.toCharArray().map { it.toInt()}.asSequence() + sequenceOf(17, 31, 73, 47, 23)
        return denseToString(sparseToDense((0..63).fold(SparseState(initialState, 0, 0)) { carry, _ -> createSparse(stepSequence, carry) }.list))
    }
}
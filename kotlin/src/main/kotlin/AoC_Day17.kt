object AoC_Day17 {

    fun solvePt1(input: Int) : Int {
        val endState = generateSequence(Pair(0,arrayOf(0))) {
            val newPos = (it.first + input) % it.second.size + 1
            Pair(newPos, (it.second.sliceArray(0..(newPos-1)) + it.second.size + it.second.sliceArray((newPos) until it.second.size)))
        }.take(2018).last()
        return endState.second[endState.first + 1]
    }

    fun solvePt2(input: Int) : Int =
        generateSequence(Triple(0, 1, emptyArray<Int>())) {
            val newPos = (it.first + input) % it.second + 1
            if (newPos == 1) Triple(newPos, it.second + 1, it.third + it.second)
            else Triple(newPos, it.second + 1, it.third)
        }.take(50000000).last().third.last()
}
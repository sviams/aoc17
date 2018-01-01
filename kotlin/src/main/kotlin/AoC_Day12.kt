object AoC_Day12 {

    private fun parseInput(input: Sequence<String>) : Map<Int, List<Int>> = input.associate { value ->
        val split = value.split(" <-> ")
        split[0].toInt() to split[1].split(",").map { it.trimStart().toInt() }
    }

    private fun getGroupWithRoot(theMap: Map<Int, List<Int>>, alreadySeen: List<Int>, currentValue: Int, sofar: Int) : List<Int> =
        theMap[currentValue]?.fold(alreadySeen) { acc, value ->
            if (acc.contains(value)) acc else (acc + getGroupWithRoot(theMap,acc + value, value, sofar + 1)).distinct()
        } ?: alreadySeen

    private tailrec fun countGroups(theMap: Map<Int, List<Int>>, theCount: Int) : Int {
        if (!theMap.any()) return theCount
        val rootGroup = getGroupWithRoot(theMap, listOf(theMap.keys.first()), theMap.keys.first(), 0)
        return countGroups(theMap.filter { !rootGroup.contains(it.key) }, theCount + 1)
    }

    fun solvePt1(input: Sequence<String>) : Int = getGroupWithRoot(parseInput(input), listOf(0),0, 0).size

    fun solvePt2(input: Sequence<String>) : Int = countGroups(parseInput(input), 0)
}
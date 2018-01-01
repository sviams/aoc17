object AoC_Day24 {

    data class Link(val a: Int, val b: Int) {
        fun matches(output: Int) : Boolean = a == output || b == output
        fun opposite(input: Int) : Int = if (a == input) b else a
    }

    fun parseInput(input: List<String>) : List<Link> =
        input.map { line ->
            val split = line.split("/")
            Link(split[0].toInt(), split[1].toInt())
        }

    fun findStrongestBridge(output: Int, links: List<Link>, sum: Int) : Int {
        val matches = links.filter { it.matches(output) }
        return matches.map { m ->
            val nextOutput = m.opposite(output)
            findStrongestBridge(nextOutput,links.minus(m), sum + nextOutput) + output
        }.max() ?: sum
    }

    fun solvePt1(input: List<String>) : Int = findStrongestBridge(0, parseInput(input), 0)

    fun findLongestBridges(output: Int, links: List<Link>, combo: Pair<Int, Int>) : Pair<Int, Int> {
        val matches = links.filter { it.matches(output) }
        val allLongest =  matches.map { m ->
            val nextOutput = m.opposite(output)
            findLongestBridges(nextOutput,links.minus(m), Pair(combo.first + nextOutput + output, combo.second + 1))
        }
        val maxLength = allLongest.maxBy { it.second }?.second
        return allLongest.filter { it.second == maxLength }.maxBy { it.first } ?: combo
    }

    fun solvePt2(input: List<String>) : Int = findLongestBridges(0, parseInput(input), Pair(0,0)).first

}

object AoC_Day4 {

    fun solve_pt1(input: List<String>) : Int =
        input.map { it.split(" ") }.fold(0) { acc, tokens ->
            if (tokens.any { tokens.indexOf(it) != tokens.lastIndexOf(it) }) acc else acc +1
        }

    fun solve_pt2(input: List<String>) : Int =
        input.map { it.split(" ") }.fold(0) { acc, tokens ->
            if (tokens.map { it.toCharArray().sorted() }.any { chars ->
                tokens.map { it.toCharArray().sorted() }.fold(0) { acc, otherChars ->
                    if (chars == otherChars) acc + 1 else acc
                } > 1
            }) acc else acc + 1
        }
}
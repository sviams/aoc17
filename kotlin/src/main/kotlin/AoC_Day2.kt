import java.util.*

object AoC_Day2 {

    fun parseInput(input: List<String>) : List<List<Int>> = input.map { it.split('\t').map { s -> s.toInt() } }

    fun solve_pt1(input: List<String>) : Int =
        parseInput(input).fold(0) { acc, arrayList -> acc + arrayList.max()!! - arrayList.min()!! }


    fun solve_pt2(input: List<String>) : Int =
        parseInput(input).fold(0) { totalAcc, arrayList ->
            totalAcc + arrayList.fold(0) { rowAcc, tested ->
                rowAcc + arrayList.fold(0) { valAcc, sibling ->
                    if (tested != sibling && tested % sibling == 0) tested / sibling else valAcc
                }
            }
        }
}
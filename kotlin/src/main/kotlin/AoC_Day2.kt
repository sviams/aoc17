import java.util.*

object AoC_Day2 {

    fun solve_pt1(input: ArrayList<ArrayList<Int>>) : Int =
        input.fold(0) { acc, arrayList -> acc + arrayList.max()!! - arrayList.min()!! }


    fun solve_pt2(input: ArrayList<ArrayList<Int>>) : Int =
        input.fold(0) { totalAcc, arrayList ->
            totalAcc + arrayList.fold(0) { rowAcc, tested ->
                rowAcc + arrayList.fold(0) { valAcc, sibling ->
                    if (tested != sibling && tested % sibling == 0) tested / sibling else valAcc
                }
            }
        }
}
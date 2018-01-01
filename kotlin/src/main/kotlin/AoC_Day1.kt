object AoC_Day1 {

    fun solve_pt1(input: String) : Int {
        val intList = input.toCharArray().map { it.toInt() - 48 }
        return (0 until intList.size).fold(0) { acc, index ->
            if (intList[index] == intList[(index+1) % intList.size]) acc + intList[index] else acc
        }
    }

    fun solve_pt2(input: String) : Int {
        val intList = input.toCharArray().map { it.toInt() - 48 }
        return intList.foldIndexed(0) { index, acc, i ->
            val unadjustedNextIndex = index+intList.size/2
            val nextIndex = if (unadjustedNextIndex >= intList.size) unadjustedNextIndex - intList.size else unadjustedNextIndex
            if (i == intList[nextIndex]) acc + i else acc
        }
    }
}
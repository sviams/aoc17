object AoC_Day15 {

    val factorA = 16807L
    val factorB = 48271L

    fun createGenerator(seed: Long, factor: Long) = generateSequence(seed) { (it * factor) % 2147483647 }

    val ifTheyMatch = {a: Long, b: Long -> if ((a shl 48) == (b shl 48)) 1L else 0L }

    fun countMatches(a: Sequence<Long>, b: Sequence<Long>) : Int = a.zip(b, ifTheyMatch).filter { it == 1L }.toList().size

    fun solvePt1(startA: Long, startB: Long, iterations: Int) : Int {
        val seqA = createGenerator(startA, factorA).take(iterations)
        val seqB = createGenerator(startB, factorB).take(iterations)
        return countMatches(seqA, seqB)
    }

    fun solvePt2(startA: Long, startB: Long, iterations: Int) : Int {
        val seqA = createGenerator(startA, factorA).filter { it % 4 == 0L }.take(iterations)
        val seqB = createGenerator(startB, factorB).filter { it % 8 == 0L }.take(iterations)
        return countMatches(seqA, seqB)
    }
}
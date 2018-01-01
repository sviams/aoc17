import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.runBlocking

object AoC_Day21 {

    val startState = Matrix(listOf(
            listOf(0,1,0),
            listOf(0,0,1),
            listOf(1,1,1)
    ))

    data class Matrix(val data: List<List<Int>>) {
        val size : Int by lazy { data.size }

        fun rotate() = Matrix((0 until data.size).map { row -> (0 until data.size).map { col -> data[col][row] } }.reversed())

        fun flip() = Matrix((0 until data.size).map { row -> data[row].reversed() })

        val countActive : Int by lazy { data.fold(0) {acc, row -> acc + row.sum() } }

        fun matches(other: List<Matrix>) = this.countActive == other.first().countActive && other.contains(this)

        fun divideToChunksAndTransform(rules: List<Rule>) : List<List<Matrix>> {
            val chunkSize = if (size % 2 == 0) 2 else 3
            val noChunks = size / chunkSize
            val deferred = (0 until noChunks).map { chunkRow ->
                val rowOffset =  chunkRow * chunkSize
                async {
                    (0 until noChunks).map { chunkCol ->
                        val colOffset = chunkCol * chunkSize
                        val before = Matrix(data.subList(rowOffset, rowOffset + chunkSize).map { it.subList(colOffset, colOffset + chunkSize) })
                        rules.single { rule -> before.matches(rule.input) }.output
                    }
                }
            }
            return runBlocking {
                deferred.map { it.await() }
            }
        }

        fun generatePossible() : List<Matrix> {
            val rotOne = rotate()
            val rotTwo = rotOne.rotate()
            val rotThree = rotTwo.rotate()
            return listOf(this, this.flip(), rotOne, rotOne.flip(), rotTwo, rotTwo.flip(), rotThree, rotThree.flip()).distinct()
        }

        fun transform(rules: List<Rule>) : Matrix = joinChunks(this.divideToChunksAndTransform(rules))
    }

    data class Rule(val input: List<Matrix>, val output: Matrix)

    fun stringToMatrix(input: String) : Matrix {
        val inputSplit = input.split("/")
        val mat : List<List<Int>> = inputSplit.map { row -> row.toCharArray().map { c -> if (c == '#') 1 else 0 } }
        return Matrix(mat)
    }

    fun parseRules(input: List<String>) : List<Rule> =
        input.map { line ->
            val lineSplit = line.split(" => ")
            Rule(stringToMatrix(lineSplit[0]).generatePossible(), stringToMatrix(lineSplit[1]))
        }

    fun joinARowFromChunks(chunks: List<Matrix>, rowIndex: Int) : List<Int> =
        chunks.map { it.data[rowIndex] }.fold(emptyList()) { acc, piece -> acc + piece}

    fun joinChunksInARow(chunks: List<Matrix>) : List<List<Int>> =
        (0 until chunks.first().size).map { index -> joinARowFromChunks(chunks, index) }

    fun joinChunks(chunks: List<List<Matrix>>) : Matrix =
        Matrix(chunks.fold(emptyList()) { rowAcc, rowChunks ->
            rowAcc + joinChunksInARow(rowChunks)
        })

    fun solve(input: List<String>, iterations: Int) : Int {
        val rules = parseRules(input)
        return generateSequence(startState) { it.transform(rules) }.take(iterations + 1).last().countActive
    }

}
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import java.io.File
import kotlin.test.assertEquals

class AoC_Day20_Tests : Spek({

    given("AoC Day 20 part 1") {

        it("should be correct for ref data") {
            val content = File("c:\\tmp\\aoc_20_ref.txt").readLines()
            assertEquals(0, AoC_Day20.solvePt1(content))
        }

        it("should be correct for the task") {
            val content = File("c:\\tmp\\aoc_20.txt").readLines()
            assertEquals(161, AoC_Day20.solvePt1(content))
        }

    }

    given("AoC Day 20 part 2") {

        it("should be correct for the task") {
            val content = File("c:\\tmp\\aoc_20.txt").readLines()
            assertEquals(438, AoC_Day20.solvePt2(content))
        }

        it("should be correct for the task using coroutines") {
            val content = File("c:\\tmp\\aoc_20.txt").readLines()
            assertEquals(438, AoC_Day20.solvePt2Async(content))
        }

    }


})
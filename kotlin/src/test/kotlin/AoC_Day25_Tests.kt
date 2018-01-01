import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import java.io.File
import kotlin.test.assertEquals

class AoC_Day25_Tests : Spek({

    given("AoC Day 25 part 1 input parsing") {

        it("correctly parses startOp") {
            val content = File("c:\\tmp\\aoc_25_ref.txt").readLines()
            assertEquals('A', AoC_Day25.parseInput(content).first.nextOp)
        }

        it("correctly parses startOp for the task") {
            val content = File("c:\\tmp\\aoc_25.txt").readLines()
            assertEquals('A', AoC_Day25.parseInput(content).first.nextOp)
        }

        it("correctly parses stopCond") {
            val content = File("c:\\tmp\\aoc_25_ref.txt").readLines()
            assertEquals(6, AoC_Day25.parseInput(content).first.stopCond)
        }

        it("correctly parses stopCond for the task") {
            val content = File("c:\\tmp\\aoc_25.txt").readLines()
            assertEquals(12656374, AoC_Day25.parseInput(content).first.stopCond)
        }

    }

    given("AoC Day 25 part 1") {



        it("should be correct for ref data") {
            val content = File("c:\\tmp\\aoc_25_ref.txt").readLines()
            assertEquals(3, AoC_Day25.solvePt1(content))
        }

        it("should be correct for the task") {
            val content = File("c:\\tmp\\aoc_25.txt").readLines()
            assertEquals(2526, AoC_Day25.solvePt1(content))
        }

    }

})
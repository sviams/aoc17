import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import java.io.File
import kotlin.test.assertEquals

class AoC_Day22_Tests : Spek({

    given("AoC Day 22 part 1") {

        it("should be correct for ref data with for 5 iterations") {
            val content = File("c:\\tmp\\aoc_22_ref.txt").readLines()
            assertEquals(5, AoC_Day22.solvePt1(content, 7))
        }

        it("should be correct for ref data with for 70 iterations") {
            val content = File("c:\\tmp\\aoc_22_ref.txt").readLines()
            assertEquals(41, AoC_Day22.solvePt1(content, 70))
        }

        it("should be correct for ref data with for 10000 iterations") {
            val content = File("c:\\tmp\\aoc_22_ref.txt").readLines()
            assertEquals(5587, AoC_Day22.solvePt1(content, 10000))
        }

        it("should be correct for the task") {
            val content = File("c:\\tmp\\aoc_22.txt").readLines()
            assertEquals(5406, AoC_Day22.solvePt1(content, 10000))
        }

    }

    given("AoC Day 22 part 2") {

        it("should be correct for ref data with 100 iterations") {
            val content = File("c:\\tmp\\aoc_22_ref.txt").readLines()
            assertEquals(26, AoC_Day22.solvePt2(content, 100))
        }

        it("should be correct for ref data with 10000000 iterations") {
            val content = File("c:\\tmp\\aoc_22_ref.txt").readLines()
            assertEquals(2511944, AoC_Day22.solvePt2(content, 10000000))
        }

        it("should be correct for the task") { // 1s 813ms benched
            val content = File("c:\\tmp\\aoc_22.txt").readLines()
            assertEquals(2511640, AoC_Day22.solvePt2(content, 10000000))
        }

    }


})
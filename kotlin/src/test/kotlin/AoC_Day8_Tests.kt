import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import java.io.File
import kotlin.test.assertEquals

class AoC_Day8_Tests : Spek({

    given("AoC Day 8 part 1") {

        it("should be correct for valid ref data") {
            val content = File("c:\\tmp\\aoc8_ref.txt").readLines()
            assertEquals(1, AoC_Day8.solvePt1(content))
        }

        it("should be correct for the task") {
            val content = File("c:\\tmp\\aoc_8.txt").readLines()
            assertEquals(6611, AoC_Day8.solvePt1(content))
        }

    }

    given("AoC Day 8 part 2") {

        it("should be correct for valid ref data") {
            val content = File("c:\\tmp\\aoc8_ref.txt").readLines()
            assertEquals(10, AoC_Day8.solvePt2(content))
        }

        it("should be correct for the task") {
            val content = File("c:\\tmp\\aoc_8.txt").readLines()
            assertEquals(6619, AoC_Day8.solvePt2(content))
        }

    }


})
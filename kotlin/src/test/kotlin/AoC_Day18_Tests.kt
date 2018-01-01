import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import java.io.File
import kotlin.test.assertEquals

class AoC_Day18_Tests : Spek({

    given("AoC Day 18 part 1") {

        it("should be correct for ref data") {
            val content = File("c:\\tmp\\aoc_18_ref.txt").readLines()
            assertEquals(4, AoC_Day18.solvePt1(content))
        }

        it("should be correct for the task") {
            val content = File("c:\\tmp\\aoc_18.txt").readLines()
            assertEquals(2951, AoC_Day18.solvePt1(content))
        }

    }

    given("AoC Day 18 part 2") {

        it("should be correct for the task") {
            val content = File("c:\\tmp\\aoc_18.txt").readLines()
            assertEquals(7366, AoC_Day18.solvePt2(content))
        }

    }


})
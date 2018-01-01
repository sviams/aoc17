import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import java.io.File
import kotlin.test.assertEquals

class AoC_Day19_Tests : Spek({

    given("AoC Day 19 part 1") {

        it("should be correct for ref data") {
            val content = File("c:\\tmp\\aoc_19_ref.txt").readLines()
            assertEquals("ABCDEF", AoC_Day19.solvePt1(content))
        }

        it("should be correct for the task") {
            val content = File("c:\\tmp\\aoc_19.txt").readLines()
            assertEquals("YOHREPXWN", AoC_Day19.solvePt1(content))
        }

    }

    given("AoC Day 19 part 2") {

        it("should be correct for ref data") {
            val content = File("c:\\tmp\\aoc_19_ref.txt").readLines()
            assertEquals(38, AoC_Day19.solvePt2(content))
        }

        it("should be correct for the task") {
            val content = File("c:\\tmp\\aoc_19.txt").readLines()
            assertEquals(16734, AoC_Day19.solvePt2(content))
        }

    }


})
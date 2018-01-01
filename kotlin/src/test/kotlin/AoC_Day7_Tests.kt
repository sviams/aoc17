import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import java.io.File
import kotlin.test.assertEquals

class AoC_Day7_Tests : Spek({

    given("AoC Day 7 part 1") {

        it("should be correct for valid ref data") {
            val content = File("c:\\tmp\\aoc7_ref.txt").readLines()
            assertEquals("tknk", AoC_Day7.solvePt1(content))
        }

        it("should be correct for the task imperatively") {
            val content = File("c:\\tmp\\aoc_7.txt").readLines()
            assertEquals("airlri", AoC_Day7.solvePt1(content))
        }

    }

    given("AoC Day 7 part 2") {

        it("should be correct for valid ref data") {
            val content = File("c:\\tmp\\aoc7_ref.txt").readLines()
            assertEquals(60, AoC_Day7.solvePt2(content))
        }

        it("should be correct for the task imperatively") {
            val content = File("c:\\tmp\\aoc_7.txt").readLines()
            assertEquals(1206, AoC_Day7.solvePt2(content))
        }

    }


})
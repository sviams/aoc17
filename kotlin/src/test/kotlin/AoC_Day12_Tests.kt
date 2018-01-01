import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import java.io.File
import kotlin.test.assertEquals

class AoC_Day12_Tests : Spek({

    given("AoC Day 12 part 1") {

        it("should be correct for valid ref data 1") {
            val content = File("c:\\tmp\\aoc_12_ref.txt").readLines().asSequence()
            assertEquals(6, AoC_Day12.solvePt1(content))
        }

        it("should be correct for the task") {
            val content = File("c:\\tmp\\aoc_12.txt").readLines().asSequence()
            assertEquals(115, AoC_Day12.solvePt1(content))
        }

    }

    given("AoC Day 12 part 2") {

        it("should be correct for valid ref data 1") {
            val content = File("c:\\tmp\\aoc_12_ref.txt").readLines().asSequence()
            assertEquals(2, AoC_Day12.solvePt2(content))
        }

        it("should be correct for the task") { // 8 ms benched
            val content = File("c:\\tmp\\aoc_12.txt").readLines().asSequence()
            assertEquals(221, AoC_Day12.solvePt2(content))
        }

    }


})
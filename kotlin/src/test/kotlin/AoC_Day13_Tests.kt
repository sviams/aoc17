import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import java.io.File
import kotlin.test.assertEquals

class AoC_Day13_Tests : Spek({

    given("AoC Day 13 part 1") {

        it("should be correct for valid ref data 1") {
            val content = File("c:\\tmp\\aoc_13_ref.txt").readLines().asSequence()
            assertEquals(24, AoC_Day13.solvePt1(content))
        }

        it("should be correct for the task") {
            val content = File("c:\\tmp\\aoc_13.txt").readLines().asSequence()
            assertEquals(748, AoC_Day13.solvePt1(content))
        }

    }

    given("AoC Day 13 part 2") {

        it("should be correct for valid ref data") {
            val content = File("c:\\tmp\\aoc_13_ref.txt").readLines().asSequence()
            assertEquals(10, AoC_Day13.solvePt2(content))
        }

        it("should be correct for the task") { // 104 ms benched
            val content = File("c:\\tmp\\aoc_13.txt").readLines().asSequence()
            assertEquals(3873662, AoC_Day13.solvePt2(content))
        }

    }


})
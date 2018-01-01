import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import java.io.File
import kotlin.test.assertEquals

class AoC_Day16_Tests : Spek({

    given("AoC Day 16 part 1") {

        it("should be correct for the task") {
            val content = File("c:\\tmp\\aoc_16.txt").readLines().asSequence()
            assertEquals("namdgkbhifpceloj", AoC_Day16.solvePt1(content))
        }

    }

    given("AoC Day 16 part 2") {

        it("should be correct for the task") {
            val content = File("c:\\tmp\\aoc_16.txt").readLines().asSequence()
            assertEquals("ibmchklnofjpdeag", AoC_Day16.solvePt2(content))
        }

    }


})
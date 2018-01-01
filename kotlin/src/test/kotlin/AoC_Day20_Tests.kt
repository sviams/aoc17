import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import java.io.File
import kotlin.test.assertEquals

class AoC_Day20_Tests : Spek({

    given("AoC Day 20 part 1") {

        it("should be correct for ref data") {
            assertEquals(0, AoC_Day20.solvePt1(readResource("20_ref.txt")))
        }

        it("should be correct for the task") {
            assertEquals(161, AoC_Day20.solvePt1(readResource("20.txt")))
        }

    }

    given("AoC Day 20 part 2") {

        it("should be correct for the task") {
            assertEquals(438, AoC_Day20.solvePt2(readResource("20.txt")))
        }

        it("should be correct for the task using coroutines") {
            assertEquals(438, AoC_Day20.solvePt2Async(readResource("20.txt")))
        }

    }


})
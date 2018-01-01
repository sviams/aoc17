import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import java.io.File
import kotlin.test.assertEquals

class AoC_Day25_Tests : Spek({

    given("AoC Day 25 part 1 input parsing") {

        it("correctly parses startOp") {
            assertEquals('A', AoC_Day25.parseInput(readResource("25_ref.txt")).first.nextOp)
        }

        it("correctly parses startOp for the task") {
            assertEquals('A', AoC_Day25.parseInput(readResource("25_ref.txt")).first.nextOp)
        }

        it("correctly parses stopCond") {
            assertEquals(6, AoC_Day25.parseInput(readResource("25_ref.txt")).first.stopCond)
        }

        it("correctly parses stopCond for the task") {
            assertEquals(12656374, AoC_Day25.parseInput(readResource("25.txt")).first.stopCond)
        }

    }

    given("AoC Day 25 part 1") {



        it("should be correct for ref data") {
            assertEquals(3, AoC_Day25.solvePt1(readResource("25_ref.txt")))
        }

        it("should be correct for the task") {
            assertEquals(2526, AoC_Day25.solvePt1(readResource("25.txt")))
        }

    }

})
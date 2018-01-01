import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import java.io.File
import kotlin.test.assertEquals

class AoC_Day16_Tests : Spek({

    given("AoC Day 16 part 1") {

        it("should be correct for the task") {
            assertEquals("namdgkbhifpceloj", AoC_Day16.solvePt1(readResource("16.txt")))
        }

    }

    given("AoC Day 16 part 2") {

        it("should be correct for the task") {
            assertEquals("ibmchklnofjpdeag", AoC_Day16.solvePt2(readResource("16.txt")))
        }

    }


})
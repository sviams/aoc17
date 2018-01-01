import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import java.io.File
import kotlin.test.assertEquals

class AoC_Day24_Tests : Spek({

    given("AoC Day 24 part 1") {

        it("should be correct for ref data") {
            assertEquals(31, AoC_Day24.solvePt1(readResource("24_ref.txt")))
        }

        it("should be correct for the task") {
            assertEquals(1940, AoC_Day24.solvePt1(readResource("24.txt")))
        }

    }

    given("AoC Day 24 part 2") {

        it("should be correct for ref data") {
            assertEquals(19, AoC_Day24.solvePt2(readResource("24_ref.txt")))
        }

        it("should be correct for the task") {
            assertEquals(1928, AoC_Day24.solvePt2(readResource("24.txt")))
        }

    }


})
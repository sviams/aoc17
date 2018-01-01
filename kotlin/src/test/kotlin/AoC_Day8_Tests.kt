import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import java.io.File
import kotlin.test.assertEquals

class AoC_Day8_Tests : Spek({

    given("AoC Day 8 part 1") {

        it("should be correct for valid ref data") {
            assertEquals(1, AoC_Day8.solvePt1(readResource("8_ref.txt")))
        }

        it("should be correct for the task") {
            assertEquals(6611, AoC_Day8.solvePt1(readResource("8.txt")))
        }

    }

    given("AoC Day 8 part 2") {

        it("should be correct for valid ref data") {
            assertEquals(10, AoC_Day8.solvePt2(readResource("8_ref.txt")))
        }

        it("should be correct for the task") {
            assertEquals(6619, AoC_Day8.solvePt2(readResource("8.txt")))
        }

    }


})
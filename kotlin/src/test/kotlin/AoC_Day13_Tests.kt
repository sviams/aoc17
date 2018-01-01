import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import java.io.File
import kotlin.test.assertEquals

class AoC_Day13_Tests : Spek({

    given("AoC Day 13 part 1") {

        it("should be correct for valid ref data 1") {
            assertEquals(24, AoC_Day13.solvePt1(readResource("13_ref.txt")))
        }

        it("should be correct for the task") {
            assertEquals(748, AoC_Day13.solvePt1(readResource("13.txt")))
        }

    }

    given("AoC Day 13 part 2") {

        it("should be correct for valid ref data") {
            assertEquals(10, AoC_Day13.solvePt2(readResource("13_ref.txt")))
        }

        it("should be correct for the task") { // 104 ms benched
            assertEquals(3873662, AoC_Day13.solvePt2(readResource("13.txt")))
        }

    }


})
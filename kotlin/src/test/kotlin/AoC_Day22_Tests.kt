import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import java.io.File
import kotlin.test.assertEquals

class AoC_Day22_Tests : Spek({

    given("AoC Day 22 part 1") {

        it("should be correct for ref data with for 5 iterations") {
            assertEquals(5, AoC_Day22.solvePt1(readResource("22_ref.txt"), 7))
        }

        it("should be correct for ref data with for 70 iterations") {
            assertEquals(41, AoC_Day22.solvePt1(readResource("22_ref.txt"), 70))
        }

        it("should be correct for ref data with for 10000 iterations") {
            assertEquals(5587, AoC_Day22.solvePt1(readResource("22_ref.txt"), 10000))
        }

        it("should be correct for the task") {
            assertEquals(5406, AoC_Day22.solvePt1(readResource("22.txt"), 10000))
        }

    }

    given("AoC Day 22 part 2") {

        it("should be correct for ref data with 100 iterations") {
            assertEquals(26, AoC_Day22.solvePt2(readResource("22_ref.txt"), 100))
        }

        it("should be correct for ref data with 10000000 iterations") {
            assertEquals(2511944, AoC_Day22.solvePt2(readResource("22_ref.txt"), 10000000))
        }

        it("should be correct for the task") { // 1s 813ms benched
            assertEquals(2511640, AoC_Day22.solvePt2(readResource("22.txt"), 10000000))
        }

    }


})
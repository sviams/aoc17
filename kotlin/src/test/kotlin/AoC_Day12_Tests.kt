import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import java.io.File
import kotlin.test.assertEquals

class AoC_Day12_Tests : Spek({

    given("AoC Day 12 part 1") {

        it("should be correct for valid ref data 1") {
            assertEquals(6, AoC_Day12.solvePt1(readResource("12_ref.txt")))
        }

        it("should be correct for the task") {
            assertEquals(115, AoC_Day12.solvePt1(readResource("12.txt")))
        }

    }

    given("AoC Day 12 part 2") {

        it("should be correct for valid ref data 1") {
            assertEquals(2, AoC_Day12.solvePt2(readResource("12_ref.txt")))
        }

        it("should be correct for the task") { // 8 ms benched
            assertEquals(221, AoC_Day12.solvePt2(readResource("12.txt")))
        }

    }


})
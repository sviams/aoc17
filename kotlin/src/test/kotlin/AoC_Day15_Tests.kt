import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import java.io.File
import kotlin.test.assertEquals

class AoC_Day15_Tests : Spek({

    given("AoC Day 15 part 1") {

        it("should be correct for valid ref data 1") {
            assertEquals(588, AoC_Day15.solvePt1(65, 8921, 40000000))
        }

        it("should be correct for the task") {
            assertEquals(626, AoC_Day15.solvePt1(679, 771, 40000000))
        }

    }

    given("AoC Day 14 part 2") {

        it("should be correct for valid ref data 1") {
            assertEquals(309, AoC_Day15.solvePt2(65, 8921, 5000000))
        }

        it("should be correct for the task") {
            assertEquals(306, AoC_Day15.solvePt2(679, 771, 5000000))
        }

    }


})
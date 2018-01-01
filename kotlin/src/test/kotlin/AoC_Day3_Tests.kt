import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import kotlin.test.assertEquals

class AoC_Day3_Tests : Spek({

    given("AoC Day 3 part 1") {

        it("should be correct for 8") {
            assertEquals(1, AoC_Day3.solvePt1(8))
        }

        it("should be correct for 9") {
            assertEquals(2, AoC_Day3.solvePt1(9))
        }

        it("should be correct for 12") {
            assertEquals(3, AoC_Day3.solvePt1(12))
        }

        it("should be correct for 23") {
            assertEquals(2, AoC_Day3.solvePt1(23))
        }

        it("should be correct for 25") {
            assertEquals(4, AoC_Day3.solvePt1(25))
        }

        it("should be correct for 49") {
            assertEquals(6, AoC_Day3.solvePt1(49))
        }

        it("should be correct for 1024") {
            assertEquals(31, AoC_Day3.solvePt1(1024))
        }

        it("should be correct for the task") {
            assertEquals(371, AoC_Day3.solvePt1(368078))
        }

    }

    given("AoC Day 3 part 2") {

        it("should be correct for 2") {
            assertEquals(4, AoC_Day3.solvePt2(2))
        }

        it("should be correct for 4") {
            assertEquals(5, AoC_Day3.solvePt2(4))
        }

        it("should be correct for 23") {
            assertEquals(25, AoC_Day3.solvePt2(23))
        }

        it("should be correct for 362") {
            assertEquals(747, AoC_Day3.solvePt2(362))
        }

        it("should be correct for 147") {
            assertEquals(304, AoC_Day3.solvePt2(147))
        }

        it("should be correct for 59") {
            assertEquals(122, AoC_Day3.solvePt2(59))
        }

        benchedIt("should be correct for the task", 10000) {
            assertEquals(369601, AoC_Day3.solvePt2(368078))
        }

    }


})
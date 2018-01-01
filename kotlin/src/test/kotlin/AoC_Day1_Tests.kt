import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import kotlin.test.assertEquals

class AoC_Day1_Tests : Spek({

    given("AoC Day 1 part 1") {

        it("should be correct for simple reference data") {
            assertEquals(3, AoC_Day1.solve_pt1("1122"))
        }

        it("should be correct for repeating reference data") {
            assertEquals(4, AoC_Day1.solve_pt1("1111"))
        }

        it("should be correct for non-repeating reference data") {
            assertEquals(0, AoC_Day1.solve_pt1("1234"))
        }

        it("should be correct for reference data that wraps around") {
            assertEquals(9, AoC_Day1.solve_pt1("91212129"))
        }

        it("should be correct for my task") {
            assertEquals(995, AoC_Day1.solve_pt1(readResource("1.txt").first()))
        }

    }

    given("AoC Day 1 part 2") {

        it("should be correct for reference data 1") {
            assertEquals(6, AoC_Day1.solve_pt2("1212"))
        }

        it("should be correct for reference data 2") {
            assertEquals(0, AoC_Day1.solve_pt2("1221"))
        }

        it("should be correct for reference data 3") {
            assertEquals(4, AoC_Day1.solve_pt2("123425"))
        }

        it("should be correct for reference data 4") {
            assertEquals(12, AoC_Day1.solve_pt2("123123"))
        }

        it("should be correct for my task") {
            assertEquals(1130, AoC_Day1.solve_pt2(readResource("1.txt").first()))
        }

    }

})
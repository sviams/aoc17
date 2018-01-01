import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import kotlin.test.assertEquals

class AoC_Day2_Tests : Spek({

    given("AoC Day 2 part 1") {

        it("should be correct for simple reference data") {
            assertEquals(18, AoC_Day2.solve_pt1(readResource("2.1_ref.txt")))
        }

        it("should be correct for the task") {
            assertEquals(44887, AoC_Day2.solve_pt1(readResource("2.txt")))
        }

    }

    given("AoC Day 1 part 2") {

        it("should be correct for simple reference data") {
            assertEquals(9, AoC_Day2.solve_pt2(readResource("2.2_ref.txt")))
        }

        it("should be correct for the task") {
            assertEquals(242, AoC_Day2.solve_pt2(readResource("2.txt")))
        }
    }

})
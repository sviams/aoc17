import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import kotlin.test.assertEquals

class AoC_Day5_Tests : Spek({

    given("AoC Day 5 part 1") {

        it("should be correct for valid ref data") {
            assertEquals(5,  AoC_Day5.solvePt1(listOf(0,3,0,1,-3)))
        }

        it("should be correct for the task") {
            assertEquals(373160, AoC_Day5.solvePt1(readResource("5.txt").map { it.toInt() }))
        }

    }

    given("AoC Day 5 part 2") {

        it("should be correct for valid ref data") {
            assertEquals(10,  AoC_Day5.solvePt2(listOf(0,3,0,1,-3)))
        }

        /*
        it("should be correct for the task functionally") {
            assertEquals(26395586, AoC_Day5.solvePt2(task))
        }
        */

        it("should be correct for the task imperatively") {
            assertEquals(26395586, AoC_Day5.solvePt2Imperative(readResource("5.txt").map { it.toInt() }.toTypedArray()))
        }

    }


})
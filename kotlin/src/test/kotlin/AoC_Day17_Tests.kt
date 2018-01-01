import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import java.io.File
import kotlin.test.assertEquals

class AoC_Day17_Tests : Spek({

    given("AoC Day 17 part 1") {

        it("should be correct for the ref data") {
            assertEquals(638, AoC_Day17.solvePt1(3))
        }

        it("should be correct for the task") {
            assertEquals(772, AoC_Day17.solvePt1(312))
        }

    }

    given("AoC Day 17 part 2") {

        it("should be correct for the task") {
            assertEquals(42729050, AoC_Day17.solvePt2(312))
        }

    }


})
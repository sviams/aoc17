import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import java.io.File
import kotlin.test.assertEquals

class AoC_Day18_Tests : Spek({

    given("AoC Day 18 part 1") {

        it("should be correct for ref data") {
            assertEquals(4, AoC_Day18.solvePt1(readResource("18_ref.txt")))
        }

        it("should be correct for the task") {
            assertEquals(2951, AoC_Day18.solvePt1(readResource("18.txt")))
        }

    }

    given("AoC Day 18 part 2") {

        it("should be correct for the task") {
            assertEquals(7366, AoC_Day18.solvePt2(readResource("18.txt")))
        }

    }


})
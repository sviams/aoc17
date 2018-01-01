import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import java.io.File
import kotlin.test.assertEquals

class AoC_Day19_Tests : Spek({

    given("AoC Day 19 part 1") {

        it("should be correct for ref data") {
            assertEquals("ABCDEF", AoC_Day19.solvePt1(readResource("19_ref.txt")))
        }

        it("should be correct for the task") {
            assertEquals("YOHREPXWN", AoC_Day19.solvePt1(readResource("19.txt")))
        }

    }

    given("AoC Day 19 part 2") {

        it("should be correct for ref data") {
            assertEquals(38, AoC_Day19.solvePt2(readResource("19_ref.txt")))
        }

        it("should be correct for the task") {
            assertEquals(16734, AoC_Day19.solvePt2(readResource("19.txt")))
        }

    }


})
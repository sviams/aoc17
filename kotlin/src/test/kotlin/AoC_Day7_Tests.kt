import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import java.io.File
import kotlin.test.assertEquals

class AoC_Day7_Tests : Spek({

    given("AoC Day 7 part 1") {

        it("should be correct for valid ref data") {
            assertEquals("tknk", AoC_Day7.solvePt1(readResource("7_ref.txt")))
        }

        it("should be correct for the task imperatively") {
            assertEquals("airlri", AoC_Day7.solvePt1(readResource("7.txt")))
        }

    }

    given("AoC Day 7 part 2") {

        it("should be correct for valid ref data") {
            assertEquals(60, AoC_Day7.solvePt2(readResource("7_ref.txt")))
        }

        it("should be correct for the task imperatively") {
            assertEquals(1206, AoC_Day7.solvePt2(readResource("7.txt")))
        }

    }


})
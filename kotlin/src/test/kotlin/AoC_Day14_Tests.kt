import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import java.io.File
import kotlin.test.assertEquals

class AoC_Day14_Tests : Spek({

    given("AoC Day 14 part 1") {

        it("should be correct for valid ref data 1") {
            assertEquals(8108, AoC_Day14.solvePt1("flqrgnkx"))
        }

        it("should be correct for the task") {
            assertEquals(8292, AoC_Day14.solvePt1("ugkiagan"))
        }

    }

    given("AoC Day 14 part 2") {

        it("should be correct for valid ref data 1") {
            assertEquals(1242, AoC_Day14.solvePt2("flqrgnkx"))
        }

        it("should be correct for the task") {
            assertEquals(1069, AoC_Day14.solvePt2("ugkiagan"))
        }

    }


})
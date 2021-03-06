import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import java.io.File
import kotlin.test.assertEquals

class AoC_Day23_Tests : Spek({

    given("AoC Day 23 part 1") {

     it("should be correct for the task") {
            assertEquals(6241, AoC_Day23.solvePt1(readResource("23.txt")))
        }

    }

    given("AoC Day 23 part 2") {

        it("should be correct for the task") {
            assertEquals(909, AoC_Day23.solvePt2(readResource("23.txt")))
        }

    }


})
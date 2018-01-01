import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import java.io.File
import java.util.*
import kotlin.test.assertEquals

class AoC_Day6_Tests : Spek({

    val task = arrayOf<Byte>(0,5,10,0,11,14,13,4,11,8,8,7,1,4,12,11)

    val ref = arrayOf<Byte>(0,2,7,0)

    given("AoC Day 6 part 1") {

        it("should be correct for valid ref data") {
            assertEquals(5,  AoC_Day6.solvePt1(ref))
        }

        it("should be correct for the task imperatively") {
            assertEquals(7864, AoC_Day6.solvePt1(task))
        }

    }

    given("AoC Day 6 part 2") {

        it("should be correct for valid ref data") {
            assertEquals(4,  AoC_Day6.solvePt2(ref))
        }

        it("should be correct for the task imperatively") {
            assertEquals(1695, AoC_Day6.solvePt2(task))
        }

    }


})
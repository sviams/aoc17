import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import java.io.File
import kotlin.test.assertEquals

class AoC_Day11_Tests : Spek({

    val ref1 = "ne,ne,ne"
    val ref2 = "ne,ne,sw,sw"
    val ref3 = "ne,ne,s,s"
    val ref4 = "se,sw,se,sw,sw"

    given("AoC Day 11 part 1") {

        it("should be correct for valid ref data 1") {
            assertEquals(3, AoC_Day11.solvePt1(ref1))
        }

        it("should be correct for valid ref data 2") {
            assertEquals(0, AoC_Day11.solvePt1(ref2))
        }

        it("should be correct for valid ref data 3") {
            assertEquals(2, AoC_Day11.solvePt1(ref3))
        }

        it("should be correct for valid ref data 4") {
            assertEquals(3, AoC_Day11.solvePt1(ref4))
        }

        it("should be correct for valid ref data 5") {
            assertEquals(0, AoC_Day11.solvePt1("s,sw,nw,n,ne,se"))
        }

        it("should be correct for valid ref data 6") {
            assertEquals(3, AoC_Day11.solvePt1("sw,se,sw,se,sw,se"))
        }

        it("should be correct for valid ref data 7") {
            assertEquals(3, AoC_Day11.solvePt1("nw,ne,nw,ne,nw,ne"))
        }

        it("should be correct for valid ref data 8") {
            assertEquals(6, AoC_Day11.solvePt1("nw,sw,nw,sw,nw,sw"))
        }

        it("should be correct for valid ref data 9") {
            assertEquals(6, AoC_Day11.solvePt1("ne,se,ne,se,ne,se"))
        }

        it("should be correct for the task") {
            val content = File("c:\\tmp\\aoc_11.txt").readLines().asSequence().first()
            assertEquals(784, AoC_Day11.solvePt1(content))
        }

    }

    given("AoC Day 11 part 2") {

        it("should be correct for the task") {
            val content = File("c:\\tmp\\aoc_11.txt").readLines().asSequence().first()
            assertEquals(1558, AoC_Day11.solvePt2(content))
        }

    }


})
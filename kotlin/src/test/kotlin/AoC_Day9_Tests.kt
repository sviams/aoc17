import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import java.io.File
import kotlin.test.assertEquals

class AoC_Day9_Tests : Spek({

    val ref1 = sequenceOf("{{<!!>},{<!!>},{<!!>},{<!!>}}")
    val ref2 = sequenceOf("{{<a!>},{<a!>},{<a!>},{<ab>}}")
    val ref3 = "{<a>,<a>,<a>,<a>}"
    val ref4 = "{{<ab>},{<ab>},{<ab>},{<ab>}}"

    given("AoC Day 9 part 1") {

        it("should be correct for valid ref data") {
            assertEquals(9, AoC_Day9.solvePt1(ref1))
        }

        it("should be correct for valid ref data 2") {
            assertEquals(3, AoC_Day9.solvePt1(ref2))
        }

        it("should be correct for valid ref data 3") {
            assertEquals(1, AoC_Day9.solvePt1(sequenceOf(ref3)))
        }

        it("should be correct for valid ref data 4") {
            assertEquals(9, AoC_Day9.solvePt1(sequenceOf(ref4)))
        }

        it("should be correct for the task") {
            val content = File("c:\\tmp\\aoc_9.txt").readLines().asSequence()
            assertEquals(12505, AoC_Day9.solvePt1(content))
        }

    }

    given("AoC Day 9 part 2") {

        it("should be correct for valid ref data 1") {
            assertEquals(0, AoC_Day9.solvePt2(sequenceOf("<>")))
        }

        it("should be correct for valid ref data 2") {
            assertEquals(17, AoC_Day9.solvePt2(sequenceOf("<random characters>")))
        }

        it("should be correct for valid ref data 3") {
            assertEquals(3, AoC_Day9.solvePt2(sequenceOf("<<<<>")))
        }

        it("should be correct for valid ref data 4") {
            assertEquals(2, AoC_Day9.solvePt2(sequenceOf("<{!>}>")))
        }

        it("should be correct for valid ref data 5") {
            assertEquals(0, AoC_Day9.solvePt2(sequenceOf("<!!>")))
        }

        it("should be correct for valid ref data 6") {
            assertEquals(0, AoC_Day9.solvePt2(sequenceOf("<!!!>>")))
        }

        it("should be correct for valid ref data 7") {
            assertEquals(10, AoC_Day9.solvePt2(sequenceOf("<{o\"i!a,<{i<a>")))
        }

        it("should be correct for the task") {
            val content = File("c:\\tmp\\aoc_9.txt").readLines().asSequence()
            assertEquals(6671, AoC_Day9.solvePt2(content))
        }

    }


})
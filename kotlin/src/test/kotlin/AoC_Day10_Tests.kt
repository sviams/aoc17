import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import kotlin.test.assertEquals

class AoC_Day10_Tests : Spek({

    val initialTaskState = (0..255).toList()
    val task = sequenceOf(147,37,249,1,31,2,226,0,161,71,254,243,183,255,30,70)
    val taskString = "147,37,249,1,31,2,226,0,161,71,254,243,183,255,30,70"

    given("AoC Day 10 part 1") {

        it("should be correct for valid ref data") {
            assertEquals(12, AoC_Day10.solvePt1(sequenceOf(3, 4, 1, 5), (0..4).toList()))
        }

        it("should be correct for the task") {
            assertEquals(37230, AoC_Day10.solvePt1(task, initialTaskState))
        }

    }

    given("AoC Day 10 part 2") {

        it("xors all correctly") {
            val input = (0..16).fold(emptyList<Int>()) { acc, _ -> acc + listOf(65,27,9,1,4,3,40,50,91,7,6,0,2,5,68,22) }
            assertEquals(listOf(64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64), AoC_Day10.sparseToDense(input))
        }

        it("converts to string correctly") {
            assertEquals("4007ff", AoC_Day10.denseToString(listOf(64, 7, 255)))
        }

        it("should be correct for empty string") {
            assertEquals("a2582a3a0e66e6e86e3812dcb672a272", AoC_Day10.solvePt2("", initialTaskState))
        }

        it("should be correct for AoC 2017") {
            assertEquals("33efeb34ea91902bb2f59c9920caa6cd", AoC_Day10.solvePt2("AoC 2017", initialTaskState))
        }

        it("should be correct for the task") {
            assertEquals("70b856a24d586194331398c7fcfa0aaf", AoC_Day10.solvePt2(taskString, initialTaskState))
        }

    }


})
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import java.io.File
import java.util.*
import kotlin.test.assertEquals

class AoC_Day4_Tests : Spek({

    given("AoC Day 4 part 1") {

        it("should be correct for valid ref data") {
            assertEquals(1, AoC_Day4.solve_pt1(listOf("aa bb cc dd ee")))
        }

        it("should be correct for invalid ref data") {
            assertEquals(0, AoC_Day4.solve_pt1(listOf("aa bb cc dd aa")))
        }

        it("should be correct for valid ref data with similarities") {
            assertEquals(1, AoC_Day4.solve_pt1(listOf("aa bb cc dd aaa")))
        }

        it("should be correct for valid ref data with similarities") {
            val input = listOf("aa bb cc dd ee", "aa bb cc dd aa", "aa bb cc dd aaa")
            assertEquals(2, AoC_Day4.solve_pt1(input))
        }

        it("should be correct for the task") {
            val content = File("c:\\tmp\\day3_pt1.txt").readLines()
            assertEquals(466, AoC_Day4.solve_pt1(content))
        }

    }

    given("AoC Day 4 part 2") {

        it("should be correct for valid ref data") {
            assertEquals(1, AoC_Day4.solve_pt2(listOf("abcde fghij")))
        }

        it("should be correct for invalid ref data") {
            assertEquals(0, AoC_Day4.solve_pt2(listOf("abcde xyz ecdab")))
        }

        it("should be correct for valid ref data with similarities") {
            assertEquals(1, AoC_Day4.solve_pt2(listOf("a ab abc abd abf abj")))
        }

        it("should be correct for valid ref data with similarities") {
            val input = listOf("abcde fghij", "abcde xyz ecdab", "a ab abc abd abf abj")
            assertEquals(2, AoC_Day4.solve_pt2(input))
        }

        it("should be correct for the task") {
            val content = File("c:\\tmp\\day3_pt1.txt").readLines()
            assertEquals(251, AoC_Day4.solve_pt2(content))
        }

    }


})
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import java.io.File
import kotlin.test.assertEquals

class AoC_Day21_Tests : Spek({

    given("a 4x4 matrix") {

        val input = AoC_Day21.Matrix(listOf(
                listOf(1,0,0,0),
                listOf(0,1,0,1),
                listOf(1,1,1,0),
                listOf(1,1,1,1)
        ))

        it("should correctly rotate one step") {
            val expected = AoC_Day21.Matrix(listOf(
                    listOf(0,1,0,1),
                    listOf(0,0,1,1),
                    listOf(0,1,1,1),
                    listOf(1,0,1,1)
            ))
            assertEquals(expected, input.rotate())
        }

        it("should correctly rotate two steps") {
            val expected = AoC_Day21.Matrix(listOf(
                    listOf(1,1,1,1),
                    listOf(0,1,1,1),
                    listOf(1,0,1,0),
                    listOf(0,0,0,1)
            ))
            assertEquals(expected, input.rotate().rotate())
        }

        it("should correctly count active cells") {
            assertEquals(10, input.countActive)
        }

        it("should correctly count active cells") {
            assertEquals(10, input.countActive)
        }

        it("should correctly flip") {
            val expected = AoC_Day21.Matrix(listOf(
                    listOf(0,0,0,1),
                    listOf(1,0,1,0),
                    listOf(0,1,1,1),
                    listOf(1,1,1,1)
            ))
            assertEquals(expected, input.flip())
        }

    }

    given("a 3x3 matrix") {

        val input = AoC_Day21.Matrix(listOf(
                listOf(1,0,0),
                listOf(0,1,0),
                listOf(1,1,1)
        ))

        it("should correctly rotate one step") {
            val expected = AoC_Day21.Matrix(listOf(
                    listOf(0,0,1),
                    listOf(0,1,1),
                    listOf(1,0,1)
            ))
            assertEquals(expected, input.rotate())
        }

        it("should correctly rotate two steps") {
            val expected = AoC_Day21.Matrix(listOf(
                    listOf(1,1,1),
                    listOf(0,1,0),
                    listOf(0,0,1)
            ))
            assertEquals(expected, input.rotate().rotate())
        }

        it("should correctly count active cells") {
            assertEquals(5, input.countActive)
        }

    }

    given("AoC Day 21 part 1") {

        it("should be correct for ref data") {
            assertEquals(12, AoC_Day21.solve(readResource("21_ref.txt"), 2))
        }

        it("should be correct for the task") {
            assertEquals(139, AoC_Day21.solve(readResource("21.txt"), 5))
        }

    }

    given("AoC Day 21 part 2") {

        it("should be correct for the task") { // 1s 940 ms benched
            assertEquals(1857134, AoC_Day21.solve(readResource("21.txt"), 18))
        }

    }


})
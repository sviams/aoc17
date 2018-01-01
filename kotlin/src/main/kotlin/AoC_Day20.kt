import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.runBlocking

object AoC_Day20 {

    fun parseParticleStates(lines: List<String>) : List<ParticleState> = lines.map { line ->
        val split = line.split(", ")
        val splits = (0..2).map { split[it].substring(split[it].indexOf('<')+1, split[it].indexOf('>')) }
        val vecs = splits.map {
            val items = it.split(",")
            Vec3D(items[0].trimStart().toInt(), items[1].trimStart().toInt(), items[2].trimStart().toInt())
        }
        ParticleState(vecs[0], vecs[1], vecs[2])
    }

    data class Vec3D(val x: Int, val y: Int, val z: Int) {
        fun distance() = Math.abs(x) + Math.abs(y) + Math.abs(z)
        fun plus(other: Vec3D) : Vec3D = Vec3D(x + other.x, y + other.y, z + other.z)
    }

    data class ParticleState(val pos: Vec3D, val vel: Vec3D, val acc: Vec3D) {
        fun increment() : ParticleState {
            val newVel = vel.plus(acc)
            return ParticleState(pos.plus(newVel), newVel, acc)
        }
    }

    data class State(val particles: List<ParticleState>, val closest: List<Int>)

    fun solvePt1(input: List<String>) : Int {
        val parts = parseParticleStates(input)
        val minByAccelerationThenVelocity = parts.filter { it.acc.distance() == parts.minBy { it.acc.distance() }!!.acc.distance() }.minBy { it.vel.distance() }
        return parts.indexOf(minByAccelerationThenVelocity)
    }

    fun solvePt2(input: List<String>) : Int =
        generateSequence(State(parseParticleStates(input), emptyList())) {
            val newParts = it.particles.map { p -> p.increment() }
            val filteredParts = newParts.filter { f -> newParts.map { p -> p.pos }.count { x -> x == f.pos } == 1}
            State(filteredParts,(it.closest + filteredParts.size).takeWhile { x -> x <= it.particles.size })
        }.takeWhile {
            it.closest.size < 10 || it.closest.distinct().size > 1
        }.last().closest.last()

    // Playing around with Kotlin coroutines
    fun solvePt2Async(input: List<String>) : Int =
        generateSequence(State(parseParticleStates(input), emptyList())) {
            val deferred = it.particles.map { p -> async { p.increment() } } // Quite ridiculous since increment() is extremely cheap
            runBlocking {
                val newParts = deferred.map { it.await() }
                val filteredParts = newParts.filter { f -> newParts.map { p -> p.pos }.count { x -> x == f.pos } == 1}
                State(filteredParts,(it.closest + filteredParts.size).takeWhile { x -> x <= it.particles.size })
            }

        }.takeWhile {
            it.closest.size < 10 || it.closest.distinct().size > 1
        }.last().closest.last()
}
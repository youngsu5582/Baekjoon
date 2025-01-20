import java.util.PriorityQueue
import java.util.StringTokenizer
import kotlin.math.min

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }

    val aSt = StringTokenizer(readLine())
    val bSt = StringTokenizer(readLine())

    val pq = PriorityQueue<Grade> { o1, o2 -> o2.performance.compareTo(o1.performance) }
    repeat(m) {
        val current = aSt.nextToken().toInt()
        val performance = bSt.nextToken().toInt()
        pq.add(Grade(current, performance))
    }

    var time = n * 24
    var result = 0

    while (time > 0 && pq.isNotEmpty()) {
        val grade = pq.poll()
        if (grade.current == 100) {
            result += 100
            continue
        }
        val useTime = min(grade.calculate(), time)
        time -= useTime
        pq.add(grade.study(useTime))
    }

    while (pq.isNotEmpty()) {
        result += pq.poll().current
    }

    println(result)
}

data class Grade(
    val current: Int,
    val performance: Int
) {
    fun calculate(): Int {
        return (100 - current) / performance
    }

    fun study(time: Int): Grade {
        val next = current + performance * time
        return Grade(next, 100 - next)
    }
}

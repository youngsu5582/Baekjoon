import java.util.*
import kotlin.math.abs

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val st = StringTokenizer(readLine())
    val ary = LongArray(n) { 0 }
    repeat(n) {
        ary[it] = st.nextToken().toLong()
    }
    ary.sort()

    var left = 0
    var right = (n - 1)
    var answer = Solution(-2_000_000_000, 0)
    while (left < right) {
        val l = ary[left]
        val r = ary[right]
        val solution = Solution(l, r)
        if (solution.sum() < answer.sum()) {
            answer = solution
        }
        if (compare(l, r)) {
            left++
        } else {
            right--
        }
    }
    println("${answer.left} ${answer.right}")
}

data class Solution(
    val left: Long,
    val right: Long
) {
    fun sum(): Long {

        return abs(right + left)
    }
}

private fun compare(left: Long, right: Long): Boolean {
    return abs(left) > abs(right)
}
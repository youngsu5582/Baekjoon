import kotlin.math.abs

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val ary = LongArray(n)
    repeat(n) {
        ary[it] = readLine().toLong()
    }
    ary.sort()
    var left = 0
    var right = 0
    var max = Long.MAX_VALUE
    while (left < n && right < n) {
        val sum = abs(ary[right] - ary[left])
//        println("$left\t$right\t${ary[left]}\t${ary[right]}\t$sum")
        if (sum >= m) {
            max = Math.min(sum, max)
            left++
        } else {
            right++
        }
    }
    println(max)
}
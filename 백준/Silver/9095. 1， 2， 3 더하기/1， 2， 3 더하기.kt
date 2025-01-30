fun main() = with(System.`in`.bufferedReader()) {
    val t = readLine().toInt()
    repeat(t) {
        val n = readLine().toInt()
        val ary = IntArray(Math.max(n + 1, 4))
        ary[1] = 1
        ary[2] = 2
        ary[3] = 4
            for (i in 4..n) {
                ary[i] = ary[i - 1] + ary[i - 2] + ary[i - 3]
            }
        println(ary[n])
    }
}
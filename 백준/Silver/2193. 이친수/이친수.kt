fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val ary = mutableListOf<Pair<Long, Long>>()
    ary.add(Pair(0, 1))
    val result = dp(ary, n)
    println(result)
}

fun dp(mutableList: MutableList<Pair<Long, Long>>, n: Int): Long {
    for (i in 1..n) {
        val prev = mutableList[i - 1]
        mutableList.add(Pair(prev.first + prev.second, prev.first))
    }
    val last = mutableList[n - 1]
    return last.first + last.second
}
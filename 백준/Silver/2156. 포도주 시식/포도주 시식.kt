import kotlin.math.max

// 09:47

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val ary = IntArray(n)
    repeat(n) {
        ary[it] = readLine().toInt()
    }
    if(n==1){
        println(ary[0])
        return
    }
    else if (n == 2) {
        println(ary[0] + ary[1])
        return
    }
    else if (n == 3) {
        println(max(max(ary[0] + ary[1], ary[0] + ary[2]),ary[1]+ary[2]))
        return
    }

    val dp = IntArray(n)

    dp[0] = ary[0]
    dp[1] = dp[0]+ary[1]
    dp[2] = max(dp[1],max(ary[0]+ary[2],ary[1]+ary[2]))
    for(i in 3 until n){
        // o x o o
        // x o x o
        // . . o x
        dp[i] = max(dp[i-3] + ary[i-1] + ary[i], max(dp[i-2]+ary[i],dp[i-1]))
    }
    println(dp.max())
}
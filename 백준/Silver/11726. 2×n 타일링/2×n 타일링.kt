fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val ary = IntArray(Math.max(n+1,3))
    ary[1]= 1
    ary[2]= 2

    for(i in 3..n){
        ary[i] = (ary[i-2] + ary[i-1]) % 10007
    }
    println(ary[n])
}
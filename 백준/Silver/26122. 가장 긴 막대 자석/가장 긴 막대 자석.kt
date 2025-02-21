fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val magnet = readLine()


    // 
    // 굳이 알 필요 있는가?
    val memorization = IntArray(n) { 1 }

    for (i in 1 until n) {
        // 이전과 동일하다면
        if (magnet[i] == magnet[i - 1]) {
            memorization[i] = memorization[i - 1] + 1
        }
    }
    var max = 0
    for (i in 1 until n) {
        val prevIndex = i - memorization[i]
        if(prevIndex<0){
            continue
        }
        val m = magnet[prevIndex]
        if (m != magnet[i]) {
            // 이전 index
            val prev = memorization[prevIndex]
            if (prev < 0) {
                continue
            }
            if (prev >= memorization[i]) {
                max = Math.max(memorization[i] * 2, max)
            }
        }
    }

    println(max)
}
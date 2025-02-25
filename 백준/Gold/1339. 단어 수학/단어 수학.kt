fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val mapped = MutableList(9) { mutableMapOf<Char, Int>() }
    repeat(n) {
        val line = readLine()
        val size = line.length
        for (i in 0 until size) {
            val index = size - i
            val result = mapped[index][line[i]] ?: 0
            mapped[index][line[i]] = result + 1
        }
    }

    val maxed = mutableMapOf<Char, Int>()
    var mul = 1
    for (i in 0 until 9) {
        val temp = mapped[i]
        temp.forEach {
            val value = maxed[it.key] ?: 0
            maxed[it.key] = value + mul * it.value
        }
        mul *= 10
    }

    val mp = mutableMapOf<Char, Int>()
    var number = 9
    for (element in maxed.entries.sortedByDescending { it.value }.map { it.key }) {
        mp[element] = number--
    }
    var answer = 0
    mul = 1
    for(i in 0 until 9) {
        val temp = mapped[i]
        if(temp.isEmpty()){
            continue
        }
        temp.forEach {
            val value = mp[it.key] ?: 0
            answer += value * mul * it.value
        }
        mul *= 10
    }
    println(answer)
}
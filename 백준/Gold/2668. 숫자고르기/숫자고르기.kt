fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val ary = Array<MutableList<Int>>(size = n + 1, init = { mutableListOf() })
    val under = Array(size = n + 1) { 0 }

    for (i in 1..n) {
        val number = readLine().toInt()
        ary[i].add(number)
        under[i] = number
    }
    val founded = Array(size = n + 1) { false }
    for (i in 1..n) {
        val under = under[i]
        if (!founded[under]) {
            find(under, i, ary).forEach {
                founded[it] = true
            }
        }
    }
    println(founded.count { it })
    for(i in 1 .. n){
        if(founded[i]){
            println(i)
        }
    }
}

private fun find(number: Int, findNumber: Int, ary: Array<MutableList<Int>>): Array<Int> {
    val visited = MutableList(ary.size) { false }
    val dq = ArrayDeque<FindMap>()
    dq.add(FindMap(number, arrayOf(findNumber)))
    visited[number] = true
    while (dq.isNotEmpty()) {
        val next = dq.removeFirst()
        if (next.currentNumber == findNumber) {
            return next.path
        }
        for (path in ary[next.currentNumber]) {
            if (!visited[path]) {
                visited[path] = true
                dq.add(FindMap(currentNumber = path, path = next.path.plus(next.currentNumber)))
            }
        }
    }
    return arrayOf()
}

private data class FindMap(
    val currentNumber: Int,
    val path: Array<Int>
)
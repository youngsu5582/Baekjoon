fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    val list = Array<MutableList<Int>>(n + 1) { mutableListOf() }
    repeat(n - 1) {
        val (x, y) = readLine().split(" ").map { it.toInt() }
        list[x].add(y)
        list[y].add(x)
    }
    val visited = IntArray(n + 1) { -1 }
    val queue = mutableListOf<Int>()
    queue.add(1)
    visited[1] = 1
    while (queue.isNotEmpty()) {
        val element = queue.removeFirst()

        for (e in list[element]) {
            if (visited[e] != -1) continue
            visited[e] = element
            queue.add(e)
        }
    }
    for (index in 2 .. n)
        println(visited[index])
}
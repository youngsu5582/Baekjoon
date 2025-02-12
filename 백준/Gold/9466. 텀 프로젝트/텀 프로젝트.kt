fun main() = with(System.`in`.bufferedReader()) {
    val t = readLine().toInt()
    repeat(t) {
        val n = readLine().toInt()
        val students = readLine().split(" ").map { it.toInt() }.toMutableList()

        // 임의 숫자 - Index 1 맞추기 위함
        students.add(0, -1)
        var answer = 0
        val visited = BooleanArray(n + 1) { false }
        for (i in 1 until students.size) {
            if(i==students[i]){
                answer++
                visited[i] = true
            }
        }

        for (i in 1 until students.size) {
            if (visited[i]) continue
            var next = students[i]
            val graph = mutableListOf<Int>()
            while (next != i) {
                if (visited[next]) {
                    graph.add(next)
                    break
                }
                visited[next] = true
                graph.add(next)
                next = students[next]
            }

            if (next == i) {
                visited[next] = true
                answer += graph.size + 1
            } else {
                val index = graph.indexOf(next)
                answer+=graph.size-index-1
            }
        }
        println(n - answer)
    }
}
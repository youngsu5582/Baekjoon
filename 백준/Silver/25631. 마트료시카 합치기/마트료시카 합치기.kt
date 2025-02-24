import java.util.*

// 16:20

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val st = StringTokenizer(readLine())
    val pq = PriorityQueue<Matrocika>(compareBy { it.height })
    repeat(n) {
        pq.add(Matrocika(st.nextToken().toInt()))
    }


    // 자동 정렬
    val list = mutableListOf<Matrocika>()
    // 처음값 추가
    list.add(pq.poll())
    while (pq.isNotEmpty()) {
        val matrocika = pq.poll()
        val first = list.first()

        // 무조건 작은값 순인게 보장되므로
        if (first.height == matrocika.height) {
            list.add(matrocika)
            continue
        }
        list.removeFirst()
        list.add(matrocika)
    }
    println(list.size)
}

data class Matrocika(
    val height: Int,
)
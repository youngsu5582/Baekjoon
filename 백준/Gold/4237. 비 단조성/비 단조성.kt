import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() = BufferedReader(InputStreamReader(System.`in`)).use { br ->
    val t = br.readLine().toInt()
    val sb = StringBuilder()
    repeat(t) {
        val st = StringTokenizer(br.readLine())
        val n = st.nextToken().toInt()
        val arr = IntArray(n) { st.nextToken().toInt() }

        // 배열이 비어있다면 0을 출력 (문제 조건상 n>=1이지만 안전하게)
        if(n == 0){
            sb.append("0\n")
            return@repeat
        }

        var count = 1
        var last = arr[0]
        // 첫 비교는 B[0] > B[1] 이므로, 다음 원소는 반드시 작아야 한다.
        var expectingDown = true

        for (i in 1 until n) {
            if (expectingDown) {
                if (arr[i] < last) {
                    // 조건 만족: 이전(peak)보다 작으면 subsequence에 추가
                    count++
                    last = arr[i]
                    expectingDown = false
                } else {
                    // 조건 불만족: 더 큰 값이면 peak를 갱신해서 최대값을 유지한다.
                    if (arr[i] > last) {
                        last = arr[i]
                    }
                }
            } else { // expectingUp: valley 다음에는 peak가 나와야 함
                if (arr[i] > last) {
                    count++
                    last = arr[i]
                    expectingDown = true
                } else {
                    // 조건 불만족: valley를 더 낮게 업데이트해서 나중에 확장 가능하도록 한다.
                    if (arr[i] < last) {
                        last = arr[i]
                    }
                }
            }
        }
        sb.append("$count\n")
    }
    print(sb)
}

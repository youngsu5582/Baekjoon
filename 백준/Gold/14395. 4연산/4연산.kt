val max = 100000_0000L
// * -> + -> - -> /

fun main() = with(System.`in`.bufferedReader()) {
    val (s, t) = readLine().split(" ").map { it.toLong() }
    val dq = mutableListOf<Operation>()
    dq.add(Operation(s, StringBuilder()))
    val visited = mutableSetOf<Long>()

    if (s == t) {
        println(0)
        return
    }

    val minus_number = 0L
    val div_number = 1L

    while (dq.isNotEmpty()) {
        val (number, sb) = dq.removeFirst()
        val plus_number = number + number
        val mul_number = number * number
        if (number == t) {
            println(sb)
            return
        }

        if (check(visited, mul_number, max)) {
            visited.add(mul_number)
            dq.add(Operation(mul_number, sb.newWithChar('*')))
        }
        if (check(visited, plus_number, max)) {
            visited.add(plus_number)
            dq.add(Operation(plus_number, sb.newWithChar('+')))
        }
        if (check(visited, minus_number, max)) {
            visited.add(minus_number)
            dq.add(Operation(minus_number, sb.newWithChar('-')))
        }

        if (check(visited, div_number, max)) {
            visited.add(div_number)
            dq.add(Operation(div_number, sb.newWithChar('/')))
        }
    }
    println(-1)
}

data class Operation(
    val number: Long,
    val sb: StringBuilder
)

fun StringBuilder.newWithChar(char: Char): StringBuilder {
    return StringBuilder(this).append(char)
}

private fun check(set:Set<Long>, number: Long, n: Long): Boolean {
    return set.contains(number).not()
}
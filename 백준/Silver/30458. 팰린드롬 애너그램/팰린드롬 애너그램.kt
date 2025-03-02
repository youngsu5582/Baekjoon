fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val s = readLine()
    val alpha = IntArray(26)
    repeat(n) {
        alpha[s[it] - 'a'] += 1
    }

    val zero = checkPalindrome(alpha)

    alpha[s[n / 2] - 'a'] -= 1
    val operation = checkPalindrome(alpha)
    if (zero || operation) println("Yes")
    else println("No")
}

private fun checkPalindrome(ary: IntArray): Boolean {
    for (i in ary.indices) {
        if (ary[i] % 2 != 0) {
            return false
        }
    }
    return true
}
class Solution {
    fun solution(begin: String, target: String, words: Array<String>): Int {
        var answer = 0
        
        // 문자열의 순서 캐싱
        
        // 순서에 해당하는 값 visited 인지 확인
        var count = 0
        val cacheMap = mutableMapOf<String,Int>()
        for(index in words.indices){
            cacheMap[words[index]] = index
        }
        val queue = ArrayDeque<String>()
        val visited = BooleanArray(words.size)
        queue.add(begin)
        while(queue.isNotEmpty()){
            repeat(queue.size){
                val element = queue.removeFirst()
                if(element==target){
                    return count
                }
                words.forEachIndexed{ wordIndex,word ->
                    if(visited[wordIndex].not() && checkRule(element,word)){
                        visited[wordIndex]=true
                        queue.add(word)
                    }
                }
            }
            count++
        }
        return 0
    }
 private fun checkRule(a: String, b: String): Boolean {
        return a.indices.count { a[it] != b[it] } == 1
    }
}
data class Element(
    val word:String,
    val visited:BooleanArray
)


// 1. 한 번에 한 개의 알파벳만 바꿀 수 있습니다.
// 2. words에 있는 단어로만 변환할 수 있습니다.

// 각 단어는 알파벳 소문자로만 이루어져 있습니다.
// 각 단어의 길이는 3 이상 10 이하이며 모든 단어의 길이는 같습니다.
// words에는 3개 이상 50개 이하의 단어가 있으며 중복되는 단어는 없습니다.
// begin과 target은 같지 않습니다.
// 변환할 수 없는 경우에는 0를 return 합니다.
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
        val queue = mutableListOf<String>()
        val visited = BooleanArray(words.size)
        queue.add(begin)
        while(queue.isNotEmpty()){
            val itCount = queue.size
            for(index in 0 until itCount){
                val element = queue.removeFirst()
                if(element==target){
                    return count
                }
                for(word in words){
                    val cacheIndex = cacheMap[word]!!
                    if(visited[cacheIndex].not() && checkRule(element,word)){
                        visited[cacheIndex]=true
                        queue.add(word)
                    }
                }
            }
            count++
        }
        return 0
    }
    private fun checkRule(first:String,second:String):Boolean{
        val size = first.length
        var count = 0
        for(i in 0 until size){
            if(first[i]!=second[i]) count++
        }
        return count == 1
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
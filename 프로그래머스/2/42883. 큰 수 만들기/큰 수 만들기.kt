class Solution {
    fun solution(number: String, k: Int): String {
        // 5 3
        var leftIndex = 0
        
        // 10 - 4 -1 = 5
        
        // 0 1 2 3 4 5 6
        // 1 2 3 1 2 3 4
        // 
    
        val sb = StringBuilder()
        for(i in number.length - k -1 downTo 0){
            var rightIndex = number.length - i
            
            //?
            var max = Pair(leftIndex,number[leftIndex].toInt()-48)
            for(index in leftIndex until rightIndex){
                val n = number[index].toInt() - 48
                if(max.second < n){
                    max = Pair(index,n)
                }
            }
            // 다음 index 부터 조회하게 넘긴다.
            leftIndex = max.first + 1
            // println(max)
            sb.append(max.second)
        }
        
        return sb.toString()
    }
}

// 오른쪽에서 길이를 보장 후
// 왼쪽에서 최대값을 찾자.

// 1 2 3 1 2 3 4
// -> 1 2 1 제거

// 남은 숫자가 k 보다 크다면?
// 제거

// 더 큰수를 만났을때, 남은 숫자가 k 보다 크다면?
// 앞 수들 제거
// 7 7?

// 7777 8 8888
// 4
// 8888


//4 1 7 7 2 5 2 8 4 1
// -> 4 1 2 2 제거

//4 1 1 2?
// -> 775284


// number는 2자리 이상, 1,000,000자리 이하인 숫자입니다.
// k는 1 이상 number의 자릿수 미만인 자연수입니다.
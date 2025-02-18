class Solution {
    fun solution(brown: Int, yellow: Int): IntArray {
        var answer = IntArray(2)
        val sum = brown+yellow
        for(width in 0..brown){
            for(height in 0..width){ 
                if(width*height!=sum){
                    continue
                }
                
                val widthValue = width*2
                val heightValue = (height-2)*2
                val brownValue = heightValue + widthValue
                val yellowValue = sum - brownValue
                
                if(brownValue == brown && yellowValue == yellow){
                    answer[0] = width
                    answer[1] = height
                    return answer 
                }
            }
        }
        return answer
    }
}

// 4 3
// 8 + 2 = 10
// 3 3
// 6 + 2 = 8


// 8 6
// 16 8(4+4)

// brown 8 이상 5,000
// 노란색 1 이상 2,000,000
//카펫의 가로 길이는 세로 길이와 같거나, 세로 길이보다 깁니다.

// 3 * 3 = 9

// 5 * 5 = 25, 1

// 2개, 1개일시 -> OXO

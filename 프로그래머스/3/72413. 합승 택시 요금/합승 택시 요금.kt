class Solution {
    fun solution(n: Int, s: Int, a: Int, b: Int, fares: Array<IntArray>): Int {
        val ary = Array(n+1){IntArray(n+1){100000*200}}
        repeat(n+1){
            ary[it][it] = 0
        }
        for(fare in fares){
            val (x,y,cost) = fare
            ary[x][y]=cost
            ary[y][x]=cost
        }
        //s -> A
        //s -> B
        for(k in 1 .. n){
            for(i in 1 .. n){
                for(j in 1 .. n){
                    ary[i][j] = Math.min(ary[i][k] + ary[k][j],ary[i][j])
                }
            }
        }
        var max = ary[s][a]+ary[s][b]
        // s, a, b
        for(i in 1 .. n){
            max = Math.min(ary[s][i] + ary[i][a] + ary[i][b],max)
        }
        // 최단거리 세팅
        
        return max
    }
}

// 4→1→5 : A, B가 합승하여 택시를 이용합니다. 예상 택시요금은 10 + 24 = 34원 입니다.
// 5→6 : A가 혼자 택시를 이용합니다. 예상 택시요금은 2원 입니다.
// 5→3→2 : B가 혼자 택시를 이용합니다. 예상 택시요금은 24 + 22 = 46원 입니다.

// => 시작 지점에서 각자 집까지 가장 금액이 낮아지는 특정 지점까지 이동해야 함
// 1. 어디까지 합승 해야하는지 정한다. ( 합승 안할수도 있음 )
// 그 후, 각자가 알아서 이동

// n: 지점 개수
// s : 시작 지점
// a : 집 주소
// b : 집 주소

// 지점갯수 n은 3 이상 200 이하인 자연수입니다.
// 지점 s, a, b는 1 이상 n 이하인 자연수이며, 각기 서로 다른 값입니다.
// 즉, 출발지점, A의 도착지점, B의 도착지점은 서로 겹치지 않습니다.

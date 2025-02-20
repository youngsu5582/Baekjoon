import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        var pq = new PriorityQueue<Integer>();
        for(int s : scoville){
            pq.add(s);
        }
        while(pq.size()>1){
            var first = pq.poll();
            if(first>=K){
                return answer;
            }
            var second = pq.poll();
            var total = first + second * 2;
            // System.out.println("First : \t" + first + "Second : \t" + second + "Sum : \t" + total);
            pq.add(total);
            answer++;
        }
        
        if(pq.size()==2){
            var first = pq.poll();
            var second = pq.poll();
            if(first + second * 2>=K){
                return answer + 1;
            }
        }
        if(pq.size()==1){
            if(pq.poll()>=K){
                return answer;
            }
        }
        return -1;
    }
}

// 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)

// 모든 음식의 스코빌 지수가 K 이상이 될 때까지 반복하여 섞는다.

// scoville의 길이는 2 이상 1,000,000 이하입니다.
// K는 0 이상 1,000,000,000 이하입니다.
// scoville의 원소는 각각 0 이상 1,000,000 이하입니다.
// 모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에는 -1을 return 합니다.
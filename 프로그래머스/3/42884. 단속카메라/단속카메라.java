import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        
        var pq = init(routes);
        int answer = 1;
        Pair pair = pq.poll();
        int right = pair.y;
        
        while(!pq.isEmpty()){
            pair = pq.poll();
            if(pair.x>right){
                right = pair.y;
                answer++;
            }else{
                right = Math.min(right,pair.y);
            }
        }
        
        return answer;
    }
    
    private PriorityQueue<Pair> init(int[][] routes){
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1,p2)->Integer.compare(p1.x,p2.x));
        
        for(int[] route: routes){
            pq.add(new Pair(route[0],route[1]));
        }
        return pq;
    }
}
class Pair{
    public int x;
    public int y;
    
    public Pair(int x,int y){
        this.x = x;
        this.y = y;
    }
    
    @Override
    public String toString(){
        return x+"\t"+y;
    }
    
}

// 차량의 대수는 1대 이상 10,000대 이하입니다.
// routes에는 차량의 이동 경로가 포함되어 있으며 routes[i][0]에는 i번째 차량이 고속도로에 진입한 지점, routes[i][1]에는 i번째 차량이 고속도로에서 나간 지점이 적혀 있습니다.
// 차량의 진입/진출 지점에 카메라가 설치되어 있어도 카메라를 만난것으로 간주합니다.
// 차량의 진입 지점, 진출 지점은 -30,000 이상 30,000 이하입니다.

// -20 ~ -15 , -18 ~ -13 , -14 ~ -5 , -5 ~ -3
import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        
        //BFS
        int[][] ary = new int[n][n];
        for(int i = 0; i< n; i++){
            for(int j =0; j<n;j++){
                ary[i][j] = Integer.MAX_VALUE;
            }
        }
        
        for(int i = 0;i < costs.length;i++){
            int[] cost = costs[i];
            int x = cost[0];
            int y = cost[1];
            ary[x][y]=cost[2];
            ary[y][x]=cost[2];
        }
        
        final PriorityQueue<Bridge> pq = new PriorityQueue<>(Comparator.comparingInt(bridge -> bridge.cost));
        boolean[] visited = new boolean[n];
        int answer = 0;
        
        pq.add(new Bridge(0,0));
            while(!pq.isEmpty()){
            Bridge bridge = pq.poll();
            int next = bridge.x;
            int cost = bridge.cost;
            
            if(visited[next]){
                continue;
            }
            answer+=cost;
            visited[next] = true;
            for(int i = 0; i < n; i++){
                if(!visited[i] && ary[next][i]!=Integer.MAX_VALUE){
                    pq.add(new Bridge(i,ary[next][i]));
                }
            }
        }
        
        return answer;
    }
    
    private class Bridge{
    int x;
    int cost;
    public Bridge(int x,int cost){
        this.x = x;
        this.cost = cost;
    }
    }
}

// 섬의 개수 : 1이상 100이하
// costs 길이 : ((n-1)*n) /2
// costs[i][0] - costs[i][1] : 다리 연결되는 두 섬 번호
// costs[i][2] - 다리 건설에 드는 비용

// 같은 연결은 두번 X, 순서가 바뀌어도 같은 연결
// 모든 섬 사이 다리 건설 비용 주지 않는다.
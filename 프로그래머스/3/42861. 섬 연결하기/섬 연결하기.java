import java.util.*;

class Solution {
    static int num;
    static int[] ary;
    
    public void union(int x,int y){
        int pos_x = find(x);
        int pos_y = find(y);
        if(pos_x!=pos_y){
            ary[pos_y]=pos_x;
        }
    }
    public int find(int n){
        if(n==ary[n]){
            return n;
        }
        return find(ary[n]);
    }
    
    public int solution(int n, int[][] costs) {
        num = n;
        int answer = 0;
        PriorityQueue<Ladder> pq = new PriorityQueue<>((o1,o2)->o1.cost > o2.cost ? 1 : -1);
        ary = new int[n];
        for(int i=0;i<n;i++){
            ary[i] = i;
        }
        for(int i=0;i<costs.length;i++){
            int x = costs[i][0];
            int y = costs[i][1];
            pq.add(new Ladder(x,y,costs[i][2]));
        }
        
        while(!pq.isEmpty()){
            Ladder ld = pq.poll();
            if(find(ld.x)!=find(ld.y)){
                union(ld.x,ld.y);
                answer+=ld.cost;
            }
        }
        return answer;
    }
}
class Ladder{
    
    int x;
    int y;
    int cost;
    
    public Ladder(int x,int y,int cost){
        this.x = x;
        this.y = y;
        this.cost = cost;
    }
}
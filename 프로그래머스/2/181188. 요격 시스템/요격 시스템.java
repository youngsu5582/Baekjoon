import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        PriorityQueue<Missile> dq = new PriorityQueue<>((o1,o2)->o1.x > o2.x ? 1 : -1);
        for(int i=0;i<targets.length;i++){
            dq.add(new Missile(targets[i][0],targets[i][1]));
        }
        
        int last_pos = dq.peek().y;
        while(!dq.isEmpty()){
            final var mis = dq.poll();
            if(mis.x >= last_pos){
                answer++;
                last_pos = mis.y;
                continue;
            }
            last_pos = Math.min(last_pos,mis.y);
        }
        // if(!isEnd){
        //     answer++;
        // }
        return answer +1;
    }
}

class Missile{
    // 처음
    int x;
    // 끝
    int y;
    public Missile(int x,int y){
        this.x = x;
        this.y = y;
    }
}
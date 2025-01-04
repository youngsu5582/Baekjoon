import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[computers.length];
        for(int i=0;i<computers.length;i++){
            if(visited[i]==false){
                answer++;
                bfs(computers,i,visited);
            }
        }
        return answer;
    }
    public void dfs(int[][] computers,int index,boolean[] visited){
        for(int j=0;j<computers.length;j++){
            if(computers[index][j] == 1 && visited[j]==false){
                visited[j]=true;
                dfs(computers,j,visited);
            }
        }
        return;
    }
    
    public void bfs(int[][] computers,int index,boolean[] visited){
        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(index);
        while(!dq.isEmpty()){
            int next = dq.poll();
            visited[next]=true;
            for(int i=0;i<computers.length;i++){
                if(computers[next][i] == 1 &&visited[i]==false){
                    dq.add(i);
                }               
            }
        }
    }
}
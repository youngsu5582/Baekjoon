class Solution {
    static int len;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        len = n;
        boolean[] visited = new boolean[n];
        for(int i=0;i<len;i++){
            if(visited[i]==false){
                answer++;
                visited[i]=true;
                dfs(i,visited,computers);       
            }
        }
        
        return answer;
    }
    
    public void dfs(int index,boolean[] visited,int[][] computers){
        for(int i=0;i<len;i++){
            if(computers[index][i] == 1 && visited[i]==false){
                visited[i]=true;
                dfs(i,visited,computers);
            }
        }
    }
}
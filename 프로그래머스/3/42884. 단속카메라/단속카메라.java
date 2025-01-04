import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        
        Arrays.sort(routes,(arr1,arr2)->Integer.compare(arr1[1],arr2[1]));
        int right = Integer.MIN_VALUE;
        int answer = 0;
        
        for(int i=0;i<routes.length;i++){
            if(routes[i][0]>right){
                ++answer;
                right = routes[i][1];
            }
        }
        
        return answer;
    }
}
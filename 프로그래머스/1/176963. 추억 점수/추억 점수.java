import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int length = name.length;
        int[] answer = new int[photo.length];
        Map<String,Integer> mp = new HashMap<>();
        for(int i= 0 ;i < length;i++){
            mp.put(name[i],yearning[i]);
        }
        
        for(int i= 0 ;i < photo.length;i++){
            int sum = 0;
            for(int j = 0; j<photo[i].length;j++){
                sum+=mp.getOrDefault(photo[i][j],0);
            }
            answer[i] = sum;
        }
        return answer;
    }
}

// 3 ≤ name의 길이 = yearning의 길이≤ 100

//3 ≤ photo의 길이 ≤ 100
import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        
        int[] counts = new int[3];
        
        int[] first = {1,2,3,4,5};
        int[] second = {1,3,4,5};
        int[] third = {3,1,2,4,5};
        
        for(int i=0;i<answers.length;i++){
            int value = answers[i];
            if(first[i%5]==value){
                counts[0]++;
            }
            if((value == 2 && i%2==0) || (value != 2 && i%2 !=0 && second[i/2%4]==value)){
                counts[1]++;
            }
            if(third[i/2%5]==value){
                counts[2]++;
            }
        }
        
        List<Integer> ary = new ArrayList<>();
        int maxCount = Arrays.stream(counts).max().getAsInt();
        for(int i = 0; i<3;i++){
            if(maxCount==counts[i]){
                ary.add(i+1);
            }
        }        
        return ary.stream().mapToInt(Integer::intValue).toArray();
    }
}

//10,000 
// 1 2 3 4 5 1 2 3 4 5
// 2 1 2 3 2 4 2 5 2 1 2 3 2 4 2 5 - 2 X 로 1,3,4,5 반복
// 3 3 1 1 2 2 4 4 5 5 3 3 1 1 2 2 4 4 5 5 - 3,1,2,4,5 2번씩 반복
import java.math.*;

class Solution {
    public long[] solution(int n, long left, long right) {
        long size = right - left;
        long[] answer = new long[(int)size+1];
        int count = 0;
        for(long i=left;i<=right;i++){
            long x = i / n;
            long y = i %n;
            long value = Math.max(x,y);
            answer[count++]=value+1;
        }
        return answer;
    }
    
    
}
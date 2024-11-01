import java.util.*;

class Solution {
    public int solution(int n) {
        int [] ary = new int[n+2];
        ary[0] = 1;
        ary[1] = 1;
        for(int i= 2; i<= n+1;i++){
            int prev = ary[i-2];
            int value = ary[i-1];
            int sum = prev + value;
            ary[i] = sum > 1000000007 ? sum % 1000000007 : sum;
        }
        return ary[n] % 1_000_000_007;
    }
    
}

// 가로 길이가 2이고 세로의 길이가 1인 직사각형모양의 타일
// 가로의 길이 n은 60,000이하의 자연수 입니다
//  1,000,000,007으로 나눈 나머지를 return해주세요.
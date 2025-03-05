import java.util.*;

// 12:39 

class Solution {
    
    public int solution(int[][] scores) {
        // 하나의 값을 큰 값으로 해 보장한다.
        // 왼쪽을 큰 값으로 정렬시, 어차피 무조건 하나의 값은 인센티브를 받을 수 있는 조건 만족하기 때문
        int[] wanho = scores[0];
        int total = wanho[0]+wanho[1];
        int maxScore = 0;
        Arrays.sort(scores,(a,b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        int order = 1;
        for(int[] score : scores){
            if(maxScore <= score[1]){
                maxScore = score[1];
                if(score[0]+score[1] > total) order++;
            }else{
                if(score.equals(wanho)){
                    return -1;
                }
            }
        }
        return order;
    }
}
// 두 점수가 모두 낮은 사람을 찾아야 한다.
// 
// 근무 태도 점수, 동료 평가 점수

// 두 점수가 모두 낮은 경우 한번이라도 있으면 인센티브 불가능


// scores[0] 은 완호 점수
// 나머지는 동료 점수

// 두 점수 합이 높은 순으로 석차
// 하지만, 두 점수가 모두 낮은 경우 제외 ( 어차피, 합이 최대라면? - 무조건 하나는 더 크게 된다. )

// 결국 제외가 되는지 안되는지를 찾아야 한다!
// 가장 작은 값보다 큰지를 확인한다.
import java.util.*;

class Solution {
    int count = 0;
    public int solution(int[] numbers, int target) {
        int answer = 0;
        dfs(numbers,0,target,0);
        return count;
    }
    
    public void dfs(int[] numbers,int sum,int target, int index){
        if(numbers.length == index){
            if(target == sum){
                count++;
            }
            return;
        }
        dfs(numbers,sum+numbers[index],target,index+1);
        dfs(numbers,sum-numbers[index],target,index+1);
    }
    
    private boolean check(List<Integer> numbers, int target){
        int value = 0;
        for(int number : numbers){
            value+=number;
        }
        return value == target;
    }
}

// 주어지는 숫자의 개수는 2개 이상 20개 이하입니다.
// 각 숫자는 1 이상 50 이하인 자연수입니다.
// 타겟 넘버는 1 이상 1000 이하인 자연수입니다.
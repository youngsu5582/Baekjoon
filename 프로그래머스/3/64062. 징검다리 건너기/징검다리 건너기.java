class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int left = 0;
        int right = Integer.MAX_VALUE;
        
        while(left<=right){
            int mid = (left+right)/2;
            boolean success = true;
            for(int i=0;i<stones.length;i++){
                if(stones[i]>=mid){
                    continue;
                }
                i = next_index(stones,k,i,mid);
                if(i==-1){
                    success = false;
                    break;
                }
            }
            if(success){
                answer = Math.max(answer,mid);
                left =mid+1;
            }else{
                right = mid-1;
            }
        }
        return answer;
    }
    private int next_index(int[] stones,int k,int index,int size){
        for(int i=index;i<index+k;i++){
            if(stones.length==i){
                return i;
            }
            if(stones[i]>=size){
                return i;
            }
        }
        return -1;
    }
}

// 디딤돌의 최대 칸수 k가 매개변수로 주어질 때, 
// 최대 몇 명까지 징검다리를 건널 수 있는지 return 하도록 solution 함수를 완성해주세요.

// 징검다리를 건너야 하는 니니즈 친구들의 수는 무제한 이라고 간주합니다.
// stones 배열의 크기는 1 이상 200,000 이하입니다.
// stones 배열 각 원소들의 값은 1 이상 200,000,000 이하인 자연수입니다.
// k는 1 이상 200,000 이하인 자연수입니다.
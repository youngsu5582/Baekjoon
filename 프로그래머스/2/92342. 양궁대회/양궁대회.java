import java.util.*;

class Solution {
    // 09:30
    public int[] solution(int n, int[] info) {
        
        int[] answer = bfs(n,info);
        
        return answer;
    }
    public int[] bfs(int n,int[] info){
        Deque<Bow> dq= new ArrayDeque<>();
        dq.add(new Bow(0,new int[11],0));
        Bow max = new Bow(0,new int[11],0);
        int maxPoint = 0;
        while(!dq.isEmpty()){
            Bow bow = dq.removeFirst();
            if(bow.isLast()){
                bow.put(n);
                int bowPoint = bow.calculate(info);
                if(bowPoint > maxPoint){
                    
                    max = bow;
                    maxPoint = bowPoint;
                    continue;
                }
                if(bowPoint == maxPoint && bow.isBest(max)){
                    max = bow;
                    maxPoint = bowPoint;
                }
                continue;
            }
            if(bow.canWin(n,info[bow.index])){
                dq.add(bow.win(info[bow.index]));
            }
            dq.add(bow.lose());
        }
        if(max.calculate(info)<=0){
            return new int[]{-1};
        }
        return max.ary;
    }
    
    private class Bow{
        int index;
        int [] ary;
        int count;
        
        public Bow(int index,int [] ary,int count){
            this.index = index;
            this.ary = ary;
            this.count = count;
        }
        public int calculate(int[] info){
            int sum = 0;
            int infoSum = 0; 
            int point = 10;
            for(int i = 0; i < info.length; i++){
                int nextPoint = point - i;
                if(info[i]<ary[i]){
                    sum += nextPoint;
                }
                if(info[i]>ary[i]){
                    infoSum += nextPoint;
                }
            }
            return sum - infoSum;
        }
        public boolean isLast(){
            return index == 10;
        }
        public void put(int n){
            ary[index] = n - count;
        }
        public Bow win(int value){
            int[] temp = Arrays.copyOf(ary,11);
            temp[index] = value + 1;
            return new Bow(index+1,temp,count+value + 1);
        }
        public Bow lose(){
            int[] temp = Arrays.copyOf(ary,11);
            return new Bow(index+1,temp,count);
        }
        public boolean canWin(int max, int value){
            if(count + value + 1 > max){
                return false;
            }
            return true;
        }
        public boolean isBest(Bow other){
            for(int i = 10; i >= 0; i--){
                if(this.ary[i] < other.ary[i]){ 
                    return false;
                }else if(this.ary[i] > other.ary[i]){ 
                    return true;
                }
            }
            return true;
        }
    }
    // 이기거나 지나 계속 분기한다.
    //
}
// 최대점수는 앞이다.
// n은 10
// info는 11

// 어피치가 쏜 다음 라이언이 n발 쏜다.

// a = b일 경우 어피치가 k점 가져간다.

// k점을 여러 발 맞혀도 k점 보다 많은 점수를 가져가는 게 아니고 k점만 가져간다.
// a = b = 0인 경우, 어느 누구도 점수를 가져가지 않는다.

// 10점부터 0점까지 순서대로 정수 배열 담아 return 하도록 해야한다.
// 라이언이 우승할 수 없는 경우 -1

// 무조건 n 발을 다 쏴야 한다.
// 가장 큰 점수 차이 여러가지 일 경우, 가장 낮은 점수를 더 많이 맞힌 경우를 return

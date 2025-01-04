import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> max = new PriorityQueue<>((i1,i2) -> i1<i2?1:-1);
        PriorityQueue<Integer> min = new PriorityQueue<>((i1,i2) -> i1>i2?1:-1);
        Map<String,Integer> mp = new HashMap<>();

        for(String data : operations){
            String[] value = data.split(" ");
            Operation operation = new Operation(value[0],value[1]);
            Integer num = 0;
            
            if(operation.isInsert()){
                max.add(operation.value);
                min.add(operation.value);
            }else if(operation.deleteMax()){
                while(true){
                    num = max.poll();
                    if(num==null){
                        break;
                    }
                    Integer count = mp.get("min"+num);
                    if(count == null || count == 0){
                        break;
                    }
                    mp.put("min"+num,count-1);
                }
                mp.put("max"+num,mp.getOrDefault("max"+num,0)+1);
            }else{
                while(true){
                    num = min.poll();
                    if(num==null){
                        break;
                    }
                    Integer count = mp.get("max"+num);
                    if(count == null || count == 0){
                        break;
                    }
                    mp.put("max"+num,count-1);
                }
                mp.put("min"+num,mp.getOrDefault("min"+num,0)+1);
            }
        }
        answer[0] = find(max,mp,"min");
        answer[1] = find(min,mp,"max");
        
        return answer;
    }
    private int find(PriorityQueue<Integer> pq, Map<String,Integer> mp,String reverse){
        while(!pq.isEmpty()){
            int value = pq.poll();
            int deleteCount = mp.getOrDefault(reverse+value,0);
            if(deleteCount==0){
                return value;
            }
            mp.put(reverse+value,deleteCount-1);
        }
        return 0;
    }


    class Operation{
        public String command;
        public int value;
        public Operation(String command,String value){
            this.command = command;
            this.value = Integer.valueOf(value);
        }
        public boolean isInsert(){
            return command.equals("I");
        }
        public boolean deleteMax(){
            return command.equals("D") && value == 1;
        }
        public boolean deleteMin(){
            return command.equals("D") && value == -1;
        }
    }
}

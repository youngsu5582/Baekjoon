import java.util.*;

class Solution {
    public String solution(String s) {
        String[] list = s.split(" ");
        PriorityQueue<Integer> ascPq = new PriorityQueue<Integer>(
            (i1,i2) ->i1>i2?1:-1);
        PriorityQueue<Integer> descPq = new PriorityQueue<Integer>((i1,i2) ->i2>i1?1:-1);
        for(String element : list){
            int value = Integer.valueOf(element);
            ascPq.add(value);
            descPq.add(value);
        }
        return ascPq.poll()+" "+descPq.poll();
    }
}
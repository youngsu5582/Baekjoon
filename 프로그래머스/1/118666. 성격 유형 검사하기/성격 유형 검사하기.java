import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        Map<Character,Integer> mp = new HashMap<>();
        for(int i=0;i<choices.length;i++){
            int choice = choices[i] - 4;
            String s = survey[i];
            if(choice<0){
                mp.put(s.charAt(0),get(mp,s.charAt(0))+choice*-1);
            }
            if(choice>0){
                mp.put(s.charAt(1),get(mp,s.charAt(1))+choice);
            }
        }
        
        append(sb,mp,'R','T');
        append(sb,mp,'C','F');
        append(sb,mp,'J','M');
        append(sb,mp,'A','N');
        return sb.toString();
    }
    private void append(StringBuilder sb,Map<Character,Integer> mp,char c1,char c2){
        if(get(mp,c1)>=get(mp,c2)){
            sb.append(c1);
        }else{
            sb.append(c2);
        }
    }
                       
    private int get(Map<Character,Integer> mp,char c){
        return mp.getOrDefault(c,0);
    }
}
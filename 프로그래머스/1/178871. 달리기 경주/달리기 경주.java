import java.util.*;

class Solution {
    private static Map<String, Integer> mp = new HashMap<>();
    
    public String[] solution(String[] players, String[] callings) {
        init(players);
        for (String calling : callings) {
            int index = find(calling);
            swap(players,calling,index);
        }
        return players;
    }
    private void init(String[] players){
        for(int i = 0; i<players.length; i++){
            mp.put(players[i],i);
        }
    }
    private int find(String answer){
        return mp.get(answer);
    }

    public void swap(String[] ls, String calling, int index) {
        String change = ls[index-1];
        ls[index-1]= calling;
        mp.put(calling,index-1);
        ls[index] = change;
        mp.put(change,index);
    }
}
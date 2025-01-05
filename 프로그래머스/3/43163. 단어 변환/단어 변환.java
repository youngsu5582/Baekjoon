import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        Map<String,List<String>> mp = new HashMap<>();
        for(String word: words){
            mp.put(word,isOk(word,words));
        }
        mp.put(begin,isOk(begin,words));
        
        return bfs(mp,begin,target);
    }
    private int bfs(Map<String,List<String>> mp,String begin,String target){
        Deque<String> dq = new ArrayDeque<>();
        dq.add(begin);
        int count = 0;
        while(!dq.isEmpty()){
            int length = dq.size();
            for(int i =0;i<length;i++){
                String s = dq.poll();
                if(s.equals(target)){
                    return count;
                }
                List<String> list = mp.get(s);
                if(list==null){
                    continue;
                }
                
                for(String word : list){
                    dq.addLast(word);
                }
                mp.remove(s);
                
            }
            count++;
        }
        return 0;
    }
    
    private List<String> isOk(String s,String[] words){
        int length = s.length();
        List<String> list = new ArrayList<>();
        
        for(String word : words){
            
            if(s.equals(word)){
                continue;
            }
            int match_count = 0;
            for(int i=0;i<length;i++){
                if(s.charAt(i) == word.charAt(i)){
                    match_count++;
                }
            }
            if(match_count==length-1){
                list.add(word);   
            }
        }
        return list;
    }
}

// 1. 한 번에 한 개의 알파벳만 바꿀 수 있습니다.
// 2. words에 있는 단어로만 변환할 수 있습니다.

// 각 단어는 알파벳 소문자로만 이루어져 있습니다.
// 각 단어의 길이는 3 이상 10 이하이며 모든 단어의 길이는 같습니다.
// words에는 3개 이상 50개 이하의 단어가 있으며 중복되는 단어는 없습니다.
// begin과 target은 같지 않습니다.
// 변환할 수 없는 경우에는 0를 return 합니다.
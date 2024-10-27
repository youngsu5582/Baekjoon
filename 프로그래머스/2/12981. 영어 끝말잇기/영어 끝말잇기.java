import java.util.HashMap;
import java.util.Map;

class Solution {
    public static int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        Map<String, Integer> mp = new HashMap<>();
        int size = words.length;
        char c = words[0].charAt(0);
        for (int i = 1; i <= size; i++) {
            if (words[i - 1].charAt(0) != c) {
                answer[0] = i % n == 0 ? n : i %n;
                answer[1] = i % n == 0 ? i / n : (i / n) +1 ;
                return answer;
            }
            if (mp.containsKey(words[i - 1])) {
                answer[0] = i % n == 0 ? n : i %n;
                answer[1] = i % n == 0 ? i / n : (i / n) +1 ;
                return answer;
            }
            c = words[i - 1].charAt(words[i - 1].length() - 1);
            mp.put(words[i - 1], i);
        }
        return answer;
    }
}
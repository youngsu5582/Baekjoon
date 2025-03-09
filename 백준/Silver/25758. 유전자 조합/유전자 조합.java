import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

// 19:45 

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] firstAry = new int[26];
        int[] secondAry = new int[26];

        boolean[] possible = new boolean[26];

        Map<Integer, Integer> pair = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String gene = st.nextToken();
            int first = gene.charAt(0) - 'A';
            int second = gene.charAt(1) - 'A';

            if (firstAry[first] == 0) {
                pair.put(first, second);
            }
            if (secondAry[second] == 0) {
                pair.put(second, first);
            }
            firstAry[first]++;
            secondAry[second]++;
        }

        for (int i = 0; i < 26; i++) {
            if (firstAry[i] == 0) {
                continue;
            }
            for (int j = 0; j < 26; j++) {
                if (secondAry[j] == 0) {
                    continue;
                }
                if (possible[i] && possible[j]) {
                    continue;
                }
                if (firstAry[i] == 1 && (pair.getOrDefault(i, -1) == j) && secondAry[i] == 1) {
                    continue;
                }
                if (secondAry[j] == 1 && (pair.getOrDefault(j, -1) == i) && firstAry[i] == 1) {
                    continue;
                }

                if (i <= j) {
                    possible[j] = true;
                } else {
                    possible[i] = true;
                }

            }
        }
        StringBuilder sb = new StringBuilder();

        List<Character> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (possible[i]) {
                list.add((char) (i + 'A'));
            }
        }
        System.out.println(list.size());
        System.out.println(list.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));
    }
}

// 유전자는 형질 두개
// 형질은 대문자 알파벳

// 두 유전자 조합시, 첫 번째 유전자의 첫번쨰 형질 + 두 번째 유전자의 두번쨰 형질
// 두 알파벳 중 사전순 같거나 큰 알파벳이 유전자의 표현형
// N개 1세대 유전자 주어질 시, 서로 다른 모든 1세대 유전자들과 조합 가능하다.

// N <= 100,000

// AB - DC -> AC
// AB - XP -> AP
// DC - AB -> DB
// DC - XP -> DP
// XP - AB -> XB
// XP - DC -> XC

// ADX - CPB

// 4 -> 4 * 3 = 12
// => N^2

// 10만개든, 어차피 앞의 알파벳 + 뒤의 알파벳만 맞추면 된다.


// 첫번째 일때는 무조건 A만 보장
// 두번째 일때는 무조건 B만 보장

// => 대신, AB가 같이 조합이 되면 안된다.
// 1개일때는 상대방의 값을 가지고 있다가, 이를 활용한다.

//

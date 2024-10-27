import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        String first = sc.nextLine();
        String second = sc.nextLine();

        System.out.println(check(first, second) ? "YES" : "NO");
    }

    private static boolean check(String s1, String s2) {
        return checkEqual(s1, s2) && checkVowel(s1, s2) && checkAlpha(s1, s2);
    }

    public static boolean checkVowel(String s1, String s2) {
        Deque<Character> deque_1 = parseDeque(s1);
        Deque<Character> deque_2 = parseDeque(s2);
        while (!deque_1.isEmpty() || !deque_2.isEmpty()) {
            char c1 = whileNotVowel(deque_1);
            char c2 = whileNotVowel(deque_2);
            if (c1 != c2) {
                return false;
            }
        }
        return deque_1.isEmpty() && deque_2.isEmpty();
    }

    private static char whileNotVowel(Deque<Character> dq) {
        while (!dq.isEmpty()) {
            char c = dq.poll();
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                continue;
            }
            return c;
        }
        return ' ';
    }

    private static Deque<Character> parseDeque(String s1) {
        Deque<Character> dq = new ArrayDeque<>();
        for (Character c : s1.toCharArray()) {
            dq.addLast(c);
        }
        return dq;
    }

    public static boolean checkEqual(String s1, String s2) {
        int length = s1.length() - 1;
        return index(s1, 0) == index(s2, 0) && index(s1, length) == index(s2, length);
    }

    public static boolean checkAlpha(String s1, String s2) {
        int[] arys_1 = parse(s1);
        int[] arys_2 = parse(s2);

        for (int i = 0; i < 26; i++) {
            if (arys_1[i] != arys_2[i]) {
                return false;
            }
        }
        return true;
    }

    private static char index(String s, int index) {
        return s.charAt(index);
    }

    private static int[] parse(String s) {
        int[] alpha = new int[26];

        s.chars()
                .forEach(value -> alpha[value - (int) 'a'] += 1);
        return alpha;
    }
}
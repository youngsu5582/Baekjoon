import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 12:35 

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Money> A = new PriorityQueue<>(Comparator.comparing(money -> money.value));
        PriorityQueue<Integer> B = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            A.add(new Money(Integer.valueOf(st.nextToken()), i));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            B.add(Integer.valueOf(st.nextToken()));
        }

        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            Money a = A.poll();
            int b = B.poll();
            if (a.value > b) {
                System.out.println(-1);
                return;
            }
            temp[a.position] = b;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(temp[i])
                    .append(" ");
        }
        System.out.println(sb);
    }

    private static class Money {
        int value;
        int position;

        public Money(int value, int position) {
            this.value = value;
            this.position = position;
        }
    }
}
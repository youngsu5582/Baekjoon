import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static final StringBuilder sb = new StringBuilder();
    private static PriorityQueue<Integer> plus_list = new PriorityQueue<>(Collections.reverseOrder());
    private static PriorityQueue<Integer> minus_list = new PriorityQueue<>(Collections.reverseOrder());
    private static int n;
    private static int m;
    private static int sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        while (st.hasMoreTokens()) {
            int number = Integer.parseInt(st.nextToken());
            if (number > 0) {
                plus_list.add(number);
            } else {
                minus_list.add(number * -1);
            }
        }

        int max = findMax();
        add(plus_list);
        add(minus_list);

        System.out.println(sum - max);
    }

    public static int findMax() {
        int plus = Optional.ofNullable(plus_list.peek()).orElse(-1);
        int minus = Optional.ofNullable(minus_list.peek()).orElse(-1);
        return plus > minus ? plus : minus;
    }

    public static void add(PriorityQueue<Integer> pq) {
        int count = 0;
        int temp = -1;
        while (!pq.isEmpty()) {
            temp = Math.max(pq.poll(), temp);
            count++;
            if (count == m) {
                count = 0;
                sum += temp * 2;
                temp = -1;
            }
        }
        if(temp ==-1){
            return;
        }
        sum += temp * 2;
    }
}

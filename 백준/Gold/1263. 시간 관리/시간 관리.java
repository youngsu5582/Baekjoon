import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        PriorityQueue<Work> dq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            dq.add(new Work(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Work first = dq.poll();
        int min = first.s - first.t;
        while (!dq.isEmpty()) {
            Work w = dq.poll();
            //
            if (min <= w.s) {
                min -= w.t;
                continue;
            }
            min = w.s - w.t;
        }
        if (min < 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(min);
    }

    static class Work implements Comparable<Work> {
        int t;
        int s;

        public Work(final int t, final int s) {
            this.t = t;
            this.s = s;
        }

        @Override
        public int compareTo(Work o) {
            return o.s - this.s; // s 값을 내림차순으로 정렬
        }
    }
}

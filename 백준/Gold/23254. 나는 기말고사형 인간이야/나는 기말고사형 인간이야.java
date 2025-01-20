import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        StringTokenizer aSt = new StringTokenizer(br.readLine());
        StringTokenizer bSt = new StringTokenizer(br.readLine());

        PriorityQueue<Grade> pq = new PriorityQueue<>();
        for (int i = 0; i < m; i++) {
            pq.add(new Grade(Integer.parseInt(aSt.nextToken()), Integer.parseInt(bSt.nextToken())));
        }
        int time = n * 24;
        int result = 0;
        while (time > 0 && !pq.isEmpty()) {

            Grade grade = pq.poll();
            if (grade.current == 100) {
                result += 100;
                continue;
            }
            int useTime = Math.min(grade.calculate(), time);
            time -= useTime;
            pq.add(grade.study(useTime));
        }
        while (!pq.isEmpty()) {
            result += pq.poll().current;
        }
        System.out.println(result);
    }

    private static class Grade implements Comparable<Grade> {
        int current;
        int performance;

        public Grade(int current, int performance) {
            this.current = current;
            this.performance = performance;
        }

        public int calculate() {
            return (100 - current) / performance;
        }

        public Grade study(final int time) {
            int next = current + performance * time;
            return new Grade(next, 100 - next);
        }

        @Override
        public int compareTo(Grade o) {
            return Integer.compare(o.performance, performance);
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] temp = br.readLine()
                .split(" ");
        int N = Integer.parseInt(temp[0]);
        int A = Integer.parseInt(temp[1]);
        int B = Integer.parseInt(temp[2]);
        PriorityQueue<Thing> dq = new PriorityQueue<>((o1, o2) -> Math.abs(o1.a - o1.b) < Math.abs(o2.a - o2.b) ? 1 : -1);

        for (int i = 0; i < N; i++) {
            temp = br.readLine()
                    .split(" ");
            dq.add(new Thing(Long.parseLong(temp[0]), Long.parseLong(temp[1]), 1));
        }
        long sum = 0;
        while (!dq.isEmpty()) {
            Thing thing = dq.poll();
            long a = thing.a;
            long b = thing.b;

            // A 가 크나, B가 count 없는 경우
            if (a >= b) {
                if (B > 0) {
                    sum += b;
                    B--;
                } else {
                    sum += a;
                    A--;
                }
            } else {
                if (A > 0) {
                    sum += a;
                    A--;
                } else {
                    sum += b;
                    B--;
                }
            }
        }
        System.out.println(sum);
    }
}

class Thing {
    long a;
    long b;
    int index;

    public Thing(final long a, final long b, int index) {
        this.a = a;
        this.b = b;
        this.index = index;
    }
}

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    // 걷을시 : 1초 후, -1 or 1 이동
    // 순간이동 : 0초, 2 * X

    // N : 100000
    // 2초, 512MB

    // 있는 위치 : N, 동생 위치 : K
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int n = Integer.parseInt(st.nextToken());
        final int k = Integer.parseInt(st.nextToken());

        final int[] ary = new int[Math.max(n, k) * 2 + 1];
        Arrays.fill(ary, Integer.MAX_VALUE);
        Deque<Pair> dq = new ArrayDeque<>();
        dq.add(new Pair(n, 0));

        while (!dq.isEmpty()) {
            Pair p = dq.poll();
            if (p.x == k) {
                System.out.println(p.count);
                break;
            }
            if (p.x < 0 || p.x >= ary.length) {
                continue;
            }

            dq.add(new Pair(p.x * 2, p.count));
            int element = ary[p.x];
            if (element > p.count) {
                dq.add(new Pair(p.x - 1, p.count + 1));
                dq.add(new Pair(p.x + 1, p.count + 1));
                ary[p.x] = p.count;
            }
        }
    }

}

class Pair {
    int x;
    int count;

    public Pair(int x, int count) {
        this.x = x;
        this.count = count;
    }
}

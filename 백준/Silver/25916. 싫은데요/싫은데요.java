import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] ary = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        int index = 0;
        while (st.hasMoreTokens()) {
            ary[index++] = Integer.parseInt(st.nextToken());
        }

        int tail_index = 0;
        index = 0;
        int prev = 0;
        int sum = 0;
        while (index < n) {
            int next = ary[index];
            if (prev + next <= m) {
                prev += next;
                index++;
                sum = Math.max(prev, sum);
                continue;
            }
            prev -= ary[tail_index++];
        }
        System.out.println(sum);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.max;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] ary = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ary[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        int sum = 0;
        int answer = 0;

        while (left < n) {
            if (sum + ary[left] <= m) {
                sum += ary[left++];
                answer = max(answer, sum);
            } else {
                sum -= ary[right++];
            }
        }
        System.out.println(answer);
    }
}
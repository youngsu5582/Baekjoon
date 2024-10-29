import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static int m;
    private static int b;
    private static int[][] ary;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        ary = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int count = 0;
            while (st.hasMoreTokens()) {
                ary[i][count++] = Integer.parseInt(st.nextToken());
            }
        }

        int max_index = 0;
        int max_sum = Integer.MAX_VALUE;
        for (int index = find_min(); index <= find_max(); index++) {
            int sum = 0;
            int bag = b;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int value = ary[i][j];
                    if (value < index) {
                        sum += index - value;
                        bag -= index - value;
                    } else {
                        sum += (value - index) * 2;
                        bag += value - index;
                    }
                }
            }
            if (bag < 0) {
                break;
            }
            if(max_sum>=sum){
                max_sum = sum;
                max_index = index;
            }
        }
        System.out.println(max_sum+" "+max_index);

    }
    private static int find_max(){
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max = Math.max(max,ary[i][j]);
            }
        }
        return max;
    }
    private static int find_min(){
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                min = Math.min(min,ary[i][j]);
            }
        }
        return min;
    }
}

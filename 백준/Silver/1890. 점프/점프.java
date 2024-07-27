import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static final StringBuilder sb = new StringBuilder();
    private static int[][] list;
    private static BigInteger[][] dp;
    private static int n;

    public static void main(final String[] args) throws IOException {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.valueOf(reader.readLine());

        list = new int[n][n];
        dp = new BigInteger[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
            int index = 0;
            while (st.hasMoreTokens()) {
                list[i][index++] = Integer.valueOf(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j]=BigInteger.ZERO;
            }
        }

        dp[0][0]=BigInteger.ONE;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                execute(i, j);
            }
        }
        System.out.println(dp[n-1][n-1]);
    }

    public static void execute(int x, int y) {
        int count = list[x][y];
        if(list[x][y]==0){
            return;
        }
        int n_x = x + count;
        int n_y = y +count;
        if(n_y <n){
            dp[x][n_y] = dp[x][y].add(dp[x][n_y]);
        }
        if(n_x < n){
            dp[n_x][y] = dp[x][y].add(dp[n_x][y]);
        }
    }
}

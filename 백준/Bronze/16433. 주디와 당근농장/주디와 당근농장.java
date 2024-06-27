import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final StringBuilder sb = new StringBuilder();

    public static void main(final String[] args) throws IOException {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final String line = reader.readLine();
        final StringTokenizer st = new StringTokenizer(line, " ");
        final int n = Integer.valueOf(st.nextToken());
        final int r = Integer.valueOf(st.nextToken());
        final int c = Integer.valueOf(st.nextToken());

        final int[][] ary = new int[n][n];

        ary[r - 1][c - 1] = 1;
        dfs(ary, r - 1, c - 1);
        format(ary);

        System.out.println(sb);
    }

    private static void format(final int[][] ary) {
        int n = ary.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (ary[i][j] == 1) {
                    sb.append('v');
                } else {
                    sb.append('.');
                }
            }
            sb.append('\n');
        }
    }

    private static final int[][] directions = {{-1, -1}, {1, -1}, {1, 1}, {-1, 1}};

    private static void dfs(final int[][] ary, final int r, final int c) {
        for (final int[] direction : directions) {
            final int next_r = r + direction[0];
            final int next_c = c + direction[1];
            if ((0 <= next_r && next_r < ary.length) && (0 <= next_c && next_c < ary.length)) {
                if (ary[next_r][next_c] == 0) {
                    ary[next_r][next_c] = 1;
                    dfs(ary, next_r, next_c);
                }
            }
        }
    }
}
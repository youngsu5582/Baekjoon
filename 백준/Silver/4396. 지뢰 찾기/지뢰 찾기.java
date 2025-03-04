import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 19:55 - 

public class Main {
    public static void main(final String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int n = Integer.parseInt(br.readLine());

        final boolean[][] mines = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            final String line = br.readLine();
            for (int j = 0; j < n; j++) {
                if (line.charAt(j) == '.') {
                    continue;
                }
                mines[i][j] = true;
            }
        }

        final int[][] maps = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maps[i][j] = -1;
            }
        }

        boolean isEnd = false;
        // 열린 부분 표시
        for (int i = 0; i < n; i++) {
            final String line = br.readLine();
            for (int j = 0; j < n; j++) {
                if (line.charAt(j) == 'x') {
                    if (mines[i][j]) {
                        isEnd = true;
                    }
                    maps[i][j] = 0;
                }
                // if(line.charAt())
            }
        }


        // 숫자 표시
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int count = 0;
                if(maps[i][j]==-1){
                    continue;
                }
                for (final int[] direction : DIRECTIONS) {
                    final int nextX = i + direction[0];
                    final int nextY = j + direction[1];
                    if (0 <= nextX && nextX < n && 0 <= nextY && nextY < n) {
                        if (mines[nextX][nextY]) {
                            count++;
                        }
                    }
                }
                maps[i][j] = count;
            }
        }

        final StringBuilder sb = new StringBuilder();
        // 숫자 표시
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isEnd && mines[i][j]) {
                    sb.append('*');
                } else if (maps[i][j] == -1) {
                    sb.append('.');
                }else{
                    sb.append(maps[i][j]);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static final int[][] DIRECTIONS = {{-1, 0}, {-1, 1}, {0,1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
}
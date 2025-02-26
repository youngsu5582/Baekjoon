import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        String[] temp;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        temp = br.readLine()
                .split(" ");
        int n = Integer.valueOf(temp[0]);
        int m = Integer.valueOf(temp[1]);
        temp = br.readLine()
                .split(" ");
        int h = Integer.valueOf(temp[0])-1;
        int w = Integer.valueOf(temp[1])-1;

        int[][] ary = new int[n][m];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                ary[i][j] = Integer.valueOf(st.nextToken());
            }
        }
        int k = Integer.valueOf(br.readLine());
        Deque<Hasugu> dq = new ArrayDeque<>();

        // 0은 검사, 1은 빠진곳, 2는 하수구
        int[][] visited = new int[n][m];

        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.valueOf(st.nextToken()) - 1;
            int y = Integer.valueOf(st.nextToken()) - 1;
            visited[x][y] = 2;
            dq.add(new Hasugu(x, y));
        }

        while (!dq.isEmpty()) {
            // 무조건 하수구나 물이 빠진 곳임을 보장함
            Hasugu hsg = dq.removeFirst();
            int x = hsg.x;
            int y = hsg.y;
            for (int[] direction : DIRECTIONS) {
                int nextX = x + direction[0];
                int nextY = y + direction[1];
                if (0 <= nextX && nextX < n && 0 <= nextY && nextY < m) {
                    // 검사 시작
                    if (visited[nextX][nextY] == 0) {
                        // 기존이 하수구 또는 자기보다 높이 낮을때
                        if (ary[x][y] <= ary[nextX][nextY]) {
                            visited[nextX][nextY] = 1;
                            dq.add(new Hasugu(nextX, nextY));
                        }
                    }
                }
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (h + i >= n || w + j >= m) {
                    continue;
                }
//                System.out.println(i+"\t"+j);
                boolean flag = true;
                for (int x = i; x <= i + h; x++) {
                    for (int y = j; y <= j + w; y++) {
//                        System.out.println(x+"\t"+y);
                        if (visited[x][y] == 0) {
                            flag = false;
                            break;
                        }
                    }
                    if (!flag) break;
                }
//                System.out.println("\n");
                if (flag) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static class Hasugu {
        int x;
        int y;

        public Hasugu(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static final int[][] DIRECTIONS = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
}
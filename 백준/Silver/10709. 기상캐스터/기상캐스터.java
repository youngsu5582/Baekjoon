import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[][] ary = new int[H][W];
        Deque<Point> dq = new ArrayDeque<>();

        for (int i = 0; i < H; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < W; j++) {
                if (Objects.equals(line[j], "c")) {
                    dq.add(new Point(i, j, 0));
                    ary[i][j] = 0;
                } else {
                    ary[i][j] = -1;
                }
            }
        }

        while (!dq.isEmpty()) {
            var point = dq.poll();
            if (point.y >= W) {
                continue;
            }
            dq.add(new Point(point.x, point.y+1, point.val + 1));
            if(ary[point.x][point.y]==-1){
                ary[point.x][point.y] = point.val;
                continue;
            }
            Math.min(ary[point.x][point.y], point.val);

        }

        for (int i = 0; i < H; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < W; j++) {
                sb.append(ary[i][j]).append(" ");
            }
            System.out.println(sb);
        }
    }
}

class Point {
    int x;
    int y;
    int val;

    public Point(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
}
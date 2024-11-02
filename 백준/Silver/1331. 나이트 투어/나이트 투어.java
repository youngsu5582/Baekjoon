import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static boolean[][] visited = new boolean[6][6];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String val = br.readLine();
        int start_x = val.charAt(1) - '1';
        int start_y = val.charAt(0) - 'A';
        int pos_x = start_x;
        int pos_y = start_y;

        for (int i = 0; i < 35; i++) {
            val = br.readLine();
            int x = val.charAt(1) - '1';
            int y = val.charAt(0) - 'A';
            if (check(pos_x, pos_y, x, y)) {
                pos_x = x;
                pos_y = y;
                visited[pos_x][pos_y] = true;
                continue;
            }
            pos_x = -3;
            pos_y = -3;
            break;
        }
        if (check(pos_x, pos_y, start_x,start_y)) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }

    private static int[][] ary = {{1, 2}, {-1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-2, 1}};

    private static boolean check(int x, int y, int next_x, int next_y) {
        for (int h = 0; h < ary.length; h++) {
            int pos_x = x + ary[h][0];
            int pos_y = y + ary[h][1];
            if (next_x == pos_x && next_y == pos_y && !visited[pos_x][pos_y]) {
                return true;
            }
        }
        return false;
    }
}

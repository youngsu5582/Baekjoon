import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    private static int N;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        Deque<Point> dq = new ArrayDeque<>();

        int count = 0;
        long sum = 0;
        for (int i = 0; i < N; i++) {
            String val = br.readLine();
            if (val.charAt(0) == '1') {
                while (count > 0) {
                    Point point1 = dq.pollLast();
                    if (point1 == null) {
                        break;
                    }
                    if (count >= point1.count) {
                        sum += point1.point;
                        count -= point1.count;
                    } else {
                        dq.add(new Point(point1.point, point1.count - count));
                        count = 0;
                    }
                }
                String[] temp = val.split(" ");
                dq.add(new Point(Integer.parseInt(temp[1]), Integer.parseInt(temp[2])));
            }
            count++;

        }
        while (count > 0) {
            Point point1 = dq.pollLast();
            if (point1 == null) {
                break;
            }
            if (count >= point1.count) {
                sum += point1.point;
                count -= point1.count;
            } else {
                dq.add(new Point(point1.point, point1.count - count));
                count = 0;
            }
        }
        System.out.println(sum);
    }
}

class Point {
    int point;
    int count;

    public Point(final int point, final int count) {
        this.point = point;
        this.count = count;
    }
}
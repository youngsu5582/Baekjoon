import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] temp = br.readLine()
                .split(" ");


        int N = Integer.parseInt(temp[0]);
        int M = Integer.parseInt(temp[1]);
        PriorityQueue<Apart> dq = new PriorityQueue<>((o1, o2) -> o1.x >= o2.x ? 1 : -1);
        for (int i = 0; i < M; i++) {
            temp = br.readLine()
                    .split(" ");
            int first = Integer.parseInt(temp[0]);
            int second = Integer.parseInt(temp[1]);
            dq.add(new Apart(first, i + 1));
            dq.add(new Apart(second, i + 1));
        }

        int index = 0;
        N = N % (2*M) == 0 ? N : N%(2*M);
        for(int i=0;i<N;i++){
            Apart apart = dq.poll();
            if(apart == null){
                System.out.println(index);
                return;
            }
            index = apart.y;
        }
        System.out.println(index);
    }
}

class Apart {
    // 높이
    int x;
    // 참가번호
    int y;

    public Apart(final int x, final int y) {
        this.x = x;
        this.y = y;
    }
}

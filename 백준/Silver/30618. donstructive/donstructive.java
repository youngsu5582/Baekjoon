import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        int[] ary = new int[n+1];
        int number = n;
        // 홀수
        if (n % 2 != 0) {
            ary[n / 2] = number--;
        }

        int left = n / 2 - 1;
        int right = n % 2 != 0 ? n / 2 + 1 : n / 2;
        // left : 4 -> 1
        // right : 4 -> 2

        // left : 5 -> 1
        // right : 5 -> 3


        while (0 <= left && right < n) {
            ary[left--] = number--;
            ary[right++] = number--;
        }
        for(int i = 0 ;i<n;i++){
            sb.append(ary[i]).append(' ');
        }
        System.out.println(sb);
    }
}
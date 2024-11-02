import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N  = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        long [] ary = new long[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ;i<N;i++){
            ary[i] = Long.parseLong(st.nextToken());
        }
        int count =0;
        int index = 1;
        ary[N] = -Integer.MIN_VALUE;
        while (index<N){
            long value = ary[index];
            long next_value = ary[index-1];
            if(Math.abs(value-next_value) < M){
                count++;
                index++;
            }
            index++;
        }
        System.out.println(count);
    }
}
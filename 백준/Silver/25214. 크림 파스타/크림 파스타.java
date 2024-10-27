import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answers[] = new int[n];
        sc.nextLine();
        final String[] arys = sc.nextLine().split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int prev = 0;
        for(int i =0;i<n;i++){
            int num = Integer.parseInt(arys[i]);
            if(min > num){
                min = num;
                max = 0;
            }
            max = Math.max(max,num);
            prev = max - min > prev ? max-min : prev;
            answers[i] = prev;
        }
        StringBuilder sb = new StringBuilder();
        for(int i =0 ; i<n;i++){
            sb.append(answers[i]).append(" ");
        }
        System.out.println(sb);
    }
}


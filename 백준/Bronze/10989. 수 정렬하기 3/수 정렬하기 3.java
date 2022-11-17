import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.TreeMap;
 
 
public class Main {
	public static void main(String[] args) throws IOException {
    
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] ary = new int[10001];
		
		for(int i = 0; i < N; i++) {
			int number = Integer.parseInt(br.readLine());
			ary[number]++;
		}

		for(int i=0;i<=10000;i++) {
			for(int j=0;j<ary[i];j++)
				sb.append(i).append('\n');
		}
		System.out.println(sb);
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException   {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int [] list = new int[N];
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0 ;i< N;i++) 
			list[i] = Integer.parseInt(st.nextToken());
		int max = 0;
		int min = 0;
		for(int i=0;i<N;i++)
			if(max<list[i])
				max = list[i];
		
		 
		
		while(min<max) {
			int mid = (min+max)/2;
			long sum = 0;
			for (int element : list)
				if(element-mid>0)
					sum+=(element-mid);
			if(sum<M) {
					max = mid;
			}
			else {
					min = mid +1;
			}
			
		}
		System.out.println(min-1);
	}
}

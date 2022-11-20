
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static int[] list;
	public static int N;
	public static int K;
	public static void main(String[] args) throws NumberFormatException, IOException   {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		list = new int[N];
		for(int i= 0; i< N;i++)
			list[i]=Integer.parseInt(br.readLine());
		Arrays.sort(list);
		long lo = 1;
		long hi = list[0]+K;
		// 최대 올릴수 있는 level
		if(N==1) {
			System.out.println(list[0]+K);
			return;
		}
		while(lo<hi) {
			long mid = (lo+hi)/2;
			 if(level(mid)>K)
				 hi = mid;
			 else
				 lo = mid+1;
		}
		
		System.out.println(lo-1);
		
		
	}
	public static long level(long mid) {
		long temp=0;
		for(int i=0;i<N;i++)
			if(mid - list[i]>0)
				temp+=mid-list[i];
		return temp;
	}

	
}

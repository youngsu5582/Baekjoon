
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static int[] list;
	public static void main(String[] args) throws NumberFormatException, IOException   {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		list = new int[N];
		for(int i= 0; i< N;i++)
			list[i]=Integer.parseInt(br.readLine());
		Arrays.sort(list);
		int lo = 1;
		int hi = list[N-1]-list[0]+1;
		while(lo<hi) {
			int mid = (lo+hi)/2;
			if(install(mid)<C) hi = mid;
			else lo = mid+1;
		}
		System.out.println(lo);
		
		
		
	}
	public static int install(int mid) {
		
		int count = 1;
		int last = list[0];
		
		for(int i=1;i<list.length;i++) {
			if(list[i]-last>mid) {
				last = list[i];
				count++;
			}
		}
		
		return count;
	}
}

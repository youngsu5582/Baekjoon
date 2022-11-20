
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException   {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int[] A = new int[N];
		for(int i = 0;i<N;i++)
			A[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(A);
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0;i<M;i++) {
			int min = 0;
			int max = N-1;
			int num = Integer.parseInt(st.nextToken());
			while(min<max) {
				int mid = (min+max)/2;
				if(A[mid]==num) {
					min= mid;
					break;
				}
				if(A[mid]>num) max = mid;
				else min = mid+1;
			}
			if(A[min]==num)System.out.println("1");
			else System.out.println("0");
		}
		
	}
}


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	public static long result = 0;
	public static void main(String[] args) throws NumberFormatException, IOException   {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
		int N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++){
			int temp = Integer.parseInt(br.readLine());
			if(temp==0){
				if(heap.isEmpty()) {System.out.println(temp);
				continue;
				}
				System.out.println(heap.poll());
			
			}
			else
				heap.add(temp);
		}

		
		

	}
}
	
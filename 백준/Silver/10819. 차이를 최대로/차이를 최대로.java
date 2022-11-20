
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	public static int n;
	public static int result = Integer.MIN_VALUE;
	public static boolean[] visited;
	public static ArrayList<Integer> list;
	public static void main(String[] args) throws NumberFormatException, IOException   {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		list = new ArrayList<Integer>();
		int num = Integer.parseInt(br.readLine());
		n = num;
		String line = br.readLine();
		String [] nums = line.split(" ");
		for(int i=0;i<num;i++)
			list.add(Integer.parseInt(nums[i]));
		visited = new boolean[num];
		ArrayList<Integer> arr = new ArrayList<>();
		dfs(arr,0);
		System.out.println(result);
		
	}
	public static void dfs(ArrayList<Integer> arr , int count) {
		if(count==n) {
			result = Math.max(getResult(arr),result);
			return;
		}
		for(int i=0;i<n;i++) {
		if(!visited[i]) {
			visited[i]=true;
			arr.add(list.get(i));
			dfs(arr,count+1);
			arr.remove(arr.size()-1);
			visited[i]=false;
			}
		}
		
	}
	public static int getResult(ArrayList<Integer>arr) {
		int result = 0;
		for(int i=0;i<n-1;i++) {
			result +=Math.abs(arr.get(i)-arr.get(i+1));
		}
		return result;
	}
}

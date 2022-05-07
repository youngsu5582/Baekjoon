import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        int[] ary = new int[n];
        TreeSet<Integer> set = new TreeSet<Integer>();
        for (int i = 0; i < arr.length; i++) {
            ary[i] = Integer.parseInt(arr[i]);
            set.add(ary[i]);
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int num = 0;
        for (int element : set) {
            map.put(element, num++);
        }
        for (int i = 0; i < n; i++)
            sb.append(map.get(ary[i])).append(" ");
        System.out.println(sb.toString());

    }
}
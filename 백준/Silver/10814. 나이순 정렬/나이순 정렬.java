import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        TreeMap<Integer, ArrayList<String>> map = new TreeMap();

        int n = s.nextInt();
        for (int i = 0; i < n; i++) {
            int num = s.nextInt();
            String name = s.next();
            ArrayList<String> temp = null;
            if (map.get(num) == null) {
                temp = new ArrayList<>();
                map.put(num, temp);
            } else
                temp = map.get(num);
            temp.add(name);

        }
        for (int key : map.keySet()) {
            for (String name : map.get(key))
                System.out.println(key + " " + name);
        }
    }
}
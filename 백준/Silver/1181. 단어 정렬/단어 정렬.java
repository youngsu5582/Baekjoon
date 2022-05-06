import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        TreeSet<String> ary = new TreeSet<String>();

        for (int i = 0; i < n; i++)
            ary.add(s.next());
        List<String> sortedList = new ArrayList<>(ary);
        Collections.sort(sortedList, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() == s2.length())
                    return s1.compareTo(s2);
                else if (s1.length() > s2.length())
                    return 1;
                else
                    return -1;
            }
        });
        for (String str : sortedList)
            System.out.println(str);

    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int l;
    private static int c;
    private static char[] ary;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        ary = new char[c];
        st = new StringTokenizer(br.readLine(), " ");
        int index = 0;
        while (st.hasMoreTokens()) {
            ary[index++] = st.nextToken()
                    .charAt(0);
        }
        Arrays.sort(ary);

        dfs("",0,0,0);
    }

    // a_count : 자음
    // b_count : 모음
    private static void dfs(String s, int index, int a_count, int b_count) {
//        System.out.println(a_count+"\t"+index+"\t"+b_count+"\t"+s);
        if(s.length()==l){
            if(a_count>1 && b_count>0){
                System.out.println(s);
            }
            return;
        }

        for (int i = index; i < c; i++) {
            char c = ary[i];
            if(c == 'a'|| c== 'e'||c=='i'||c=='o'||c=='u'){
                dfs(s+c,i+1,a_count,b_count+1);
            }else {
                dfs(s+c,i+1,a_count+1,b_count);
            }
        }
    }
}

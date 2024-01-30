import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = input(br);
        AtomicInteger original_time = new AtomicInteger(parseTime(line));
        int[] ary = {600,60,10};
        Integer special_result = original_time.get() % 30 == 0 ? original_time.get() / 30 : Integer.MAX_VALUE;
        Integer result = IntStream.rangeClosed(0,original_time.get()/30).map(index ->{
            AtomicInteger time = new AtomicInteger(original_time.get() - index*30);
            Integer temp = Arrays.stream(ary).map(operand -> {
                return time.getAndSet(time.get() % operand) / operand;
            }).sum()+index;
            temp = index == 0 ? temp +1 : temp;
            return time.get() == 0 ? temp:Integer.MAX_VALUE;
        }).min().orElse(Integer.MAX_VALUE);
        System.out.println(Math.min(result,special_result));
    }
    private static int parseTime(String line){
        List<Integer> temp = Arrays.stream(line.split(":")).map(Integer::parseInt).collect(Collectors.toList());
        return temp.get(0)* 60 + temp.get(1);
    }


    private static String input(BufferedReader br) {
        try {
            return br.readLine();
        } catch (Exception e) {
        }
        return null;
    }
}

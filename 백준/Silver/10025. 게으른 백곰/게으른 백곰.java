import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int unit = 1_000_000;
        List<Integer> n_k = map(Integer.class, input(br));
        int[] ary = new int[unit + 1];

        int n = n_k.get(0);
        int k = n_k.get(1);
        int max_index = IntStream.range(0, n).map(i -> {
            List<Integer> g_x = map(Integer.class, input(br));
            int g = g_x.get(0);
            int x = g_x.get(1);

            ary[x] = g;
            return x;
        }).max().orElse(0);
        int sum = IntStream.rangeClosed(0, Math.min(2 * k, unit)).map(i -> ary[i]).sum();

        AtomicInteger value = new AtomicInteger(sum);
        int result = IntStream
                .rangeClosed(k + 1, max_index - k)
                .map(index -> value.getAndSet(value.get() - ary[index - k - 1] + ary[index + k]))
                .max()
                .orElse(0);

        System.out.println(Math.max(value.get(), result));
    }

    private static <T> List<T> map(Class<T> clazz, String line) {
        StringTokenizer st = new StringTokenizer(line);
        List<String> tokens = new ArrayList<>();

        while (st.hasMoreTokens())
            tokens.add(st.nextToken());

        if (clazz == Integer.class)
            return (List<T>) tokens.stream().map(Integer::parseInt).collect(Collectors.toList());
        if (clazz == Double.class)
            return (List<T>) tokens.stream().map(Double::parseDouble).collect(Collectors.toList());
        if (clazz == String.class)
            return (List<T>) tokens.stream().collect(Collectors.toList());
        return null;
    }

    private static String input(BufferedReader br) {
        try {
            return br.readLine();
        } catch (Exception e) {
        }
        return null;
    }
}

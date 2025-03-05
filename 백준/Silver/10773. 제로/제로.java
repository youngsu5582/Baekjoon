import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        WrongMoney money = new WrongMoney(new ArrayDeque<>());
        for (int i = 0; i < k; i++) {
            money.addMoney(Integer.parseInt(br.readLine()));
        }
        System.out.println(money.getTotalMoney());
    }

    private static class WrongMoney {
        private final Deque<Integer> list;
        private static final int WRONG_MONEY = 0;

        public WrongMoney(Deque<Integer> list) {
            this.list = list;
        }

        public void addMoney(int number) {
            if (number == WRONG_MONEY && !list.isEmpty()) {
                deleteLast();
                return;
            }
            add(number);
        }

        private void deleteLast() {
            list.removeLast();
        }

        private void add(int number) {
            list.add(number);
        }

        public int getTotalMoney() {
            return list.stream()
                    .mapToInt(Integer::intValue)
                    .sum();
        }
    }
}



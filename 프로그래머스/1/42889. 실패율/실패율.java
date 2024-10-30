import java.util.*;

class Solution {
    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        Map<Integer, Integer> mp = new HashMap<>();

        int max = 0;
        for (int i = 0; i < stages.length; i++) {
            final var result = mp.getOrDefault(stages[i], 0);
            mp.put(stages[i], result + 1);
            max = Math.max(max, stages[i]);
        }

        int total = stages.length;
        int increase_count = 0;
        PriorityQueue<Result> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.y == o2.y) {
                return Integer.compare(o1.x, o2.x);
            }
            return Double.compare(o2.y, o1.y);
        });
        for (int i = 1; i <= N; i++) {
            
            int count = mp.getOrDefault(i,0);
            double result = (total - increase_count) != 0 ? ((double) count / (total - increase_count)) : 0.0;
            pq.add(new Result(i, result));
            increase_count += count;
        }

        int count = 0;
        while (!pq.isEmpty()) {
            answer[count++] = pq.poll().x;
        }
        return answer;
    }

    private static class Result {
        int x;
        double y;

        public Result(final int x, final double y) {
            this.x = x;
            this.y = y;
        }
    }
}
package step_hash.programmers;

import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;

public class DualPriorityQueue {
    static class Solution {
        public static int[] solution(String[] operations) {


            PriorityQueue<Integer> descQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
            PriorityQueue<Integer> ascQueue = new PriorityQueue<>();

            for (String operation : operations) {
                String[] input = operation.split(" ");

                String action = input[0];
                Integer value = Integer.parseInt(input[1]);

                switch (action) {
                    case "I" -> {
                        descQueue.add(value);
                        ascQueue.add(value);
                        break;
                    }
                    case "D" -> {
                        if (!ascQueue.isEmpty() && !descQueue.isEmpty()) {
                            if (value > 0) {
                                Integer poll = descQueue.poll();
                                ascQueue.remove(poll);
                            }else {
                                Integer poll = ascQueue.poll();
                                descQueue.remove(poll);
                            }
                        }
                    }
                }
            }
            if (ascQueue.isEmpty()) {
                return new int[]{0, 0};
            } else {
                return new int[]{descQueue.poll(), ascQueue.poll()};
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(
            new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1",
                "I 333"});
    }
}

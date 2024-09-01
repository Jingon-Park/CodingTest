package step_heap;

import java.util.PriorityQueue;

public class MoreSpicy {

    static class Solution {

        public int solution(int[] scoville, int K) {
            int answer = 0;

            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

            for (int value : scoville) {
                priorityQueue.add(value);
            }


            while (priorityQueue.peek() < K && priorityQueue.size() >= 2) {
                Integer min = priorityQueue.poll();
                Integer nextMin = priorityQueue.poll();

                priorityQueue.add(min + nextMin * 2);
                answer++;
            }
            if (priorityQueue.peek() < K) {
                answer = -1;
            }

            System.out.println(priorityQueue);
            return answer;
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.solution(new int[]{1, 2, 3, 9, 10, 12}, 7);

        System.out.println(result);

    }

}

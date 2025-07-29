package group_study.week_7;

import java.util.Collections;
import java.util.PriorityQueue;

public class Num4 {

    static class Solution {
        public long solution(int n, int[] works) {
            long answer = 0;

            PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
            for (int work : works) {
                queue.add(work);
            }

            while (n > 0) {
                int num = queue.poll();

                if (num == 0) {
                    break;
                }
                queue.add(num - 1);
                n--;
            }

            for (Integer integer : queue) {
                answer += (long) integer * integer;
            }

            return answer;
        }
    }
    public static void main(String[] args) {
        int n = 4;
        int[] works = {4, 3, 3};

        Solution solution = new Solution();
        long result = solution.solution(n, works);
        System.out.println(result);
    }

}

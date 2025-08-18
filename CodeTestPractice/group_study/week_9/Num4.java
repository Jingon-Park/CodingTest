package group_study.week_9;

import java.util.Arrays;

public class Num4 {

    static class Solution {

        public long solution(int n, int[] times) {
            long answer = Long.MAX_VALUE;
            long min = 0L;

            Arrays.sort(times);
            long max = ((long)times[times.length - 1] * n); //max를 잘 정해야함

            while (min < max) {
                long mid = (min + max) / 2;
                if (check(n, times, mid)) {
                    max = mid;
                    answer = Math.min(answer, mid);
                }else {
                    min = mid + 1;
                }
            }

            return answer;
        }

        public boolean check(int n, int[] times, long offeredTime) {
            long count = 0L;

            for (int time : times) {
                count += (offeredTime / time);
            }

            if (count < n) {
                return false;
            }

            return true;
        }
    }
    public static void main(String[] args) {

        int n = 6;
        int[] times = {7, 10};

        Solution solution = new Solution();
        long result = solution.solution(n, times);
        System.out.println(result);

    }

}

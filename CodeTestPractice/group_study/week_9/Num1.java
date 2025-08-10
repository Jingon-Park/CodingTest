package group_study.week_9;
public class Num1 {

    static class Solution {

        public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
            long low = 0l;
            long high = 100000000000L;
            long answer = 0L;

            while (high > low) {
                long mid = (high + low) >>> 1;

                if (checker(a, b, g, s, w, t, mid)) {
                    answer = mid;
                    high = mid;
                }else {
                    low = mid + 1;
                }
            }

            return answer;
        }

        public boolean checker(int a, int b, int[] g, int[] s, int[] w, int[] t, long time) {
            long goldSum = 0L;
            long silverSum = 0L;
            long amountSum = 0L;
            int size = g.length;

            for (int i = 0; i < size; i++) {
                long moveTime = t[i];
                long moveWeight = w[i];

                long carry = time / (2L * moveTime);
                if(time % (2L * moveTime) >= moveTime) {
                    carry++;
                }

                long carryAmount = carry * moveWeight;

                long goldCarryAmount = Math.min(g[i], carryAmount);
                long silverCarryAmount = Math.min(s[i], carryAmount);
                long totalCarryAmount = Math.min( (long) g[i] + (long)s[i], carryAmount);
                goldSum += goldCarryAmount;
                silverSum += silverCarryAmount;
                amountSum += totalCarryAmount;
            }

            return goldSum >= a && silverSum >= b && amountSum >= (a + b);
        }
    }
    public static void main(String[] args) {

        Solution solution = new Solution();
        long solution1 = solution.solution(90, 500, new int[]{70, 70, 0}, new int[]{0, 0, 500},
            new int[]{100, 100, 2}, new int[]{4, 8, 1});

        System.out.println(solution1);

    }

}

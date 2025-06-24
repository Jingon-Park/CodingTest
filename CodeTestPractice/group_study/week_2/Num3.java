package group_study.week_2;

import java.util.Arrays;

public class Num3 {

    static class Solution {
        public int solution(int[] diffs, int[] times, long limit) {
            long remainLimit = limit - times[0];
            int max = Arrays.stream(diffs).max().getAsInt();
            int min = 1;

            int level = 1;

            while (min != max) {
                long tempLimit = remainLimit;
                level = (min + max) / 2;

                for (int i = 1; i < diffs.length; i++) {
                    int price = getPrice(i, diffs,times, level);
                    tempLimit -= price;
                }
                if (tempLimit < 0) {
                    min = level + 1;
                } else {
                    max = level;
                }
            }

            return max;
        }

        public int getPrice(int index, int[] diffs, int[] times, int lv) {
            if (index < 1) {
                return -1;
            }
            if (diffs[index] <= lv) {
                return times[index];
            }
            return (times[index - 1] + times[index]) * (diffs[index] - lv) + times[index];
        }
    }
    public static void main(String[] args) {

        int[] diffs = {1, 5, 3};
        int[] times = {2, 4, 7};
        int limit = 30;


//        int[] diffs = {1,4,4,2};
//        int[] times = {6,3,8,2};
//        int limit = 59;

        Solution solution = new Solution();

        int result = solution.solution(diffs, times, limit);

        System.out.println(result);

    }

}

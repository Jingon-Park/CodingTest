package group_study.week_3;

import java.util.Arrays;
import java.util.Comparator;
/**
 * 요격 시스템
 */
public class Num1 {

    static class Solution {

        public int solution(int[][] targets) {
            int answer = 0;
            Arrays.sort(targets, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[1] == o2[1]) {
                        return o2[0] - o1[0];
                    }
                    return o1[1] - o2[1];
                }
            });

            int end = Integer.MIN_VALUE;

            for (int i = 0; i < targets.length; i++) {
                if (targets[i][0] >= end) {
                    answer++;
                    end = targets[i][1];
                }
            }

            return answer;
        }
    }
    public static void main(String[] args) {
        int[][] targets = {{4, 5}, {4, 8}, {10, 14}, {11, 13}, {5, 12}, {3, 7}, {1, 4}};
        Solution solution = new Solution();
        int result = solution.solution(targets);
        System.out.println(result);


    }


}

package step_dp.programmners;

import java.util.Arrays;

public class IntegerTriangle {

    static class Solution {
        public int solution(int[][] triangle) {
            int[][] dp = new int[triangle.length][triangle.length];

            dp[0][0] = triangle[0][0];

            for (int i = 0; i < triangle.length - 1; i++) {
                for (int j = 0; j < triangle[i].length; j++) {
                    dp[i + 1][j] = Math.max(dp[i][j] + triangle[i + 1][j], dp[i + 1][j]);
                    dp[i + 1][j + 1] = Math.max(dp[i][j] + triangle[i + 1][j + 1],
                        dp[i + 1][j + 1]);
                }
            }
            return Arrays.stream(dp[triangle.length - 1]).max().getAsInt();

        }
    }

    public static void main(String[] args) {

        int[][] input = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};

        Solution solution = new Solution();

        int result = solution.solution(input);

        System.out.println(result);

    }

}

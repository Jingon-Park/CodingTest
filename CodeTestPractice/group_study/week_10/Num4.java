package group_study.week_10;
public class Num4 {

    static class Solution {
        public int solution(int m, int n, int[][] puddles) {
            int[][] dp = new int[m + 1][n + 1];

            for (int i = 0; i < puddles.length; i++) {
                int x = puddles[i][0];
                int y = puddles[i][1];
                dp[x][y] = -1;
            }

            dp[1][1] = 1;
            for (int x = 1; x <= m; x++) {
                for (int y = 1; y <= n; y++) {
                    if (dp[x][y] == -1) {
                        dp[x][y] = 0;
                        continue;
                    }

                    if (x > 1){
                        dp[x][y] += dp[x - 1][y];
                    }

                    if (y > 1){
                        dp[x][y] += dp[x][y - 1];
                    }

                }
            }

            return dp[m][n];
        }
    }
    public static void main(String[] args) {

        int m = 4;
        int n = 3;
        int[][] puddles = {{2, 2}};
        Solution solution = new Solution();

        int result = solution.solution(m, n, puddles);
        System.out.println(result);

    }

}

package group_study.week_10;

public class Num3 {
    static class Solution {

        static int[][] values = {{1,7, 6, 7, 5, 4, 5, 3,2,3},
            {7, 1, 2,4,2,3,5,4,5,7},{6,2,1,2,3,2,3,5,4,5},{7,4,2,1,5,3,2,6,5,4},
            {5,2,3,5,1,2,4,2,3,5},{4,3,2,3,2,1,2,3,2,3},{5,5,3,2,4,2,1,5,3,2},
            {3,4,5,6,2,3,5,1,2,4},{2,5,4,5,3,2,3,2,1,2},{3,6,5,4,5,3,2,4,2,1}};
        public int solution(String numbers) {
            int[][] dp = new int[numbers.length()][2];

            int[][] leftP = new int[numbers.length()][2];
            int[][] rightP = new int[numbers.length()][2];

            int first = numbers.charAt(0) - '0';

            dp[0][0] = getValue(4, first);
            leftP[0][0] = first;
            rightP[0][0] = 6;

            dp[0][1] = getValue(6, first);
            leftP[0][1] = 4;
            rightP[0][1] = first;

            for(int i = 1; i < numbers.length(); i++) {

                int targetNum = numbers.charAt(i) - '0';

                int ll = dp[i - 1][0] + getValue(leftP[i - 1][0], targetNum);
                int rl = dp[i - 1][1] + getValue(leftP[i - 1][1], targetNum);

                if (ll < rl) {
                    dp[i][0] = ll;
                    rightP[i][0] = rightP[i - 1][0];
                } else {
                    dp[i][0] = rl;
                    rightP[i][0] = rightP[i - 1][1];
                }

                leftP[i][0] = targetNum;


                int lr = dp[i - 1][0] + getValue(rightP[i - 1][0], targetNum);
                int rr = dp[i - 1][1] + getValue(rightP[i - 1][1], targetNum);

                if (lr < rr) {
                    dp[i][1] = lr;
                    leftP[i][1] = leftP[i - 1][0];
                } else {
                    dp[i][1] = rr;
                    leftP[i][1] = leftP[i - 1][1];
                }
                rightP[i][1] = targetNum;
            }

            return Math.min(dp[numbers.length() - 1][0], dp[numbers.length() - 1][1]);
        }

        public int getValue(int position, int target) {
            return values[position][target];
        }

    }

    public static void main(String[] args) {
        String number = "5123";
        Solution solution = new Solution();
        int result = solution.solution(number);

        System.out.println(result);
    }

}

package group_study.week_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Num4 {

    /**
     * https://www.acmicpc.net/problem/1463
     * @param args
     * @throws IOException
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int inputNum = Integer.parseInt(br.readLine());

        int[] dp = new int[inputNum + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        dp[inputNum] = 0;


        while (inputNum > 1) {

            dp[inputNum - 1] = Math.min(dp[inputNum - 1], dp[inputNum] + 1);

            if (inputNum % 2 == 0) {
                int temp = inputNum / 2;
                dp[temp] = Math.min(dp[inputNum] + 1, dp[temp]);
            }

            if (inputNum % 3 == 0) {
                int temp = inputNum / 3;
                dp[temp] = Math.min(dp[inputNum] + 1, dp[temp]);
            }
            inputNum--;

        }
        System.out.println(dp[1]);
    }

}

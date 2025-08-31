package group_study.week_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 파도반 수열
 * https://www.acmicpc.net/problem/9461
 */
public class Num2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            int target = Integer.parseInt(br.readLine());
            System.out.println(dp(target));
        }
    }

    public static long dp(int n) {
        long[] dp = new long[n + 1];
        if (n < 4) {
            return 1;
        }

        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;

        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 3];
        }

        return dp[n];
    }

}

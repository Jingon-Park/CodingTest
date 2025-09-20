package group_study.week_15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 합분헤
 * https://www.acmicpc.net/problem/2225
 */
public class Num2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int num = Integer.parseInt(input[0]);

        int K = Integer.parseInt(input[1]);

        int[][] dp = new int[K + 1][num + 1];

        dp[0][0] = 1;

        for (int k = 1; k <= K; k++) {
            for (int n = 0; n <= num; n++) {
                for (int j = 0; j <= n; j++) {
                    dp[k][n] = (dp[k][n] + dp[k - 1][n - j]) % 1_000_000_000;
                }
            }
        }

        System.out.println(dp[K][num]);
    }

}

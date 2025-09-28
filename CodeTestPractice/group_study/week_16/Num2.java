package group_study.week_16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int line = Integer.parseInt(br.readLine());

        int[][] dp = new int[line + 1][3];

        int mod = 9901;

        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[1][2] = 1;

        for (int i = 2; i <= line; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % mod;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % mod;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % mod;
        }



        System.out.println((dp[line][0] + dp[line][1] + dp[line][2]) % mod);
    }

}

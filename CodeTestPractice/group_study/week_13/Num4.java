package group_study.week_13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * RGB 거리
 * https://www.acmicpc.net/problem/1149
 */
public class Num4 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        int[][] dp = new int[num][3];

        /**
         * N 번째 집을 칠하는데 필요한 최소 비용
         * 단 연속된 색으로 칠할 수 는 없음
         * F(N) = F(n - 1) + R/G/B
         */

        String[] first = br.readLine().split(" ");

        dp[0][0] = Integer.parseInt(first[0]);
        dp[0][1] = Integer.parseInt(first[1]);
        dp[0][2] = Integer.parseInt(first[2]);

        for (int i = 1; i < num; i++) {
            String[] split = br.readLine().split(" ");
            int red = Integer.parseInt(split[0]);
            int green = Integer.parseInt(split[1]);
            int blue = Integer.parseInt(split[2]);

            dp[i][0] = red + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = green + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = blue + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }

        System.out.println(Math.min(Math.min(dp[num - 1][0], dp[num - 1][1]),dp[num - 1][2]));
    }
}

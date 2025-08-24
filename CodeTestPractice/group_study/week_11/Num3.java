package group_study.week_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num3 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int[] values = new int[num];

        for (int i = 0; i < num; i++) {
            values[i] = Integer.parseInt(br.readLine());
        }

        if (num < 2) {
            System.out.println(values[0]);
            return;
        }

        int[][] dp = new int[num][2];
        dp[0][0] = values[0];
        dp[0][1] = values[0];
        dp[1][0] = dp[0][1] + values[1];
        dp[1][1] = values[1];


        for (int i = 2; i < num; i++) {
            /**
             * dp[i][0]은 i를 밟는데, i - 1 -> i 순서로 밟는 값을 저장하므로, i - 2는 밟지 않은 경우만 고려
             */
            dp[i][0] = dp[i - 1][1] + values[i];
            /**
             * dp[i][1]은 i를 밟는데, i - 2 -> i 순서보 밟는 경우이므로, i - 3을 밟았는지, 밟지 않았는지 모두 고려
             */
            dp[i][1] = Math.max(dp[i - 2][0], dp[i - 2][1]) + values[i];
        }

        System.out.println(Math.max(dp[num - 1][0], dp[num - 1][1]));

    }
}

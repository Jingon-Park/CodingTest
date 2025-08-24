package group_study.week_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 https://www.acmicpc.net/problem/9465
 */
public class Num2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        int[] answer = new int[count];

        for (int i = 0; i < count; i++) {
            int num = Integer.parseInt(br.readLine());
            int[][] dp = new int[num][2];
            int[] first = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
            int[] second = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
            if (num == 1) {
                answer[i] = Math.max(first[0], second[0]);
                continue;
            }

            dp[0][0] = first[0];
            dp[0][1] = second[0];
            dp[1][0] = dp[0][1] + first[1];
            dp[1][1] = dp[0][0] + second[1];

            for (int index = 2; index < num; index++) {

                dp[index][0] = Math.max(Math.max(dp[index - 1][0], dp[index - 2][0] + first[index]),
                    Math.max(dp[index - 2][1] + first[index], dp[index - 1][1] + first[index]));

                dp[index][1] = Math.max(Math.max(dp[index - 1][1], dp[index - 2][1] + second[index]),
                    Math.max(dp[index - 1][0] + second[index], dp[index - 2][0] + second[index]));
            }
            answer[i] = Math.max(dp[dp.length - 1][0], dp[dp.length - 1][1]);
        }

        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }

    }

}

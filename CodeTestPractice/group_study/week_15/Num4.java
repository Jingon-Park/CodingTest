package group_study.week_15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 구간 합 구하기 4
 * https://www.acmicpc.net/problem/11659
 */
public class Num4 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int num = Integer.parseInt(input[0]);
        int count = Integer.parseInt(input[1]);

        String[] numInput = br.readLine().split(" ");

        int[] dp = new int[num];
        dp[0] = Integer.parseInt(numInput[0]);

        for (int i = 1; i < numInput.length; i++) {
            dp[i] = dp[i - 1] + Integer.parseInt(numInput[i]);
        }

        for (int i = 0; i < count; i++) {
            String[] line = br.readLine().split(" ");

            int startIndex = Integer.parseInt(line[0]) - 1;
            int endIndex = Integer.parseInt(line[1]) - 1;

            int result = dp[endIndex] - (startIndex == 0 ? 0 : dp[startIndex - 1]);
            System.out.println(result);
        }
    }

}

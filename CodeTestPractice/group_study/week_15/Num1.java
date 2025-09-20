package group_study.week_15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 상자 넣기
 * https://www.acmicpc.net/problem/1965
 */
public class Num1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        int[] boxs = new int[num];


        String[] input = br.readLine().split(" ");
        for (int i = 0; i < num; i++) {
            boxs[i] = Integer.parseInt(input[i]);
        }

        int[] dp = new int[num];

        Arrays.fill(dp, 1);

        if (dp.length == 1) {
            System.out.println("1");
            return;
        }

        for (int i = 1; i < num; i++) {
            int j = i - 1;
            while (j >= 0) {
                if (boxs[i] > boxs[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
                j--;
            }
        }

        Arrays.sort(dp);
        System.out.println(dp[num - 1]);
    }
}

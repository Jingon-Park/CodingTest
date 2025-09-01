package group_study.week_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 동전 1
 * https://www.acmicpc.net/problem/2293
 */
public class Num3 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int num = Integer.parseInt(input[0]);
        int target = Integer.parseInt(input[1]);

        List<Integer> coins = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            coins.add(Integer.parseInt(br.readLine()));
        }

        long[] dp = new long[target + 1];
        dp[0] = 1;

        for (Integer coin : coins) {
            int index = coin;
            while (index <= target) {
                int temp = index - coin;
                if (temp >= 0) {
                    dp[index] += dp[temp];
                }
                index++;
            }
        }
        System.out.println(dp[target]);

    }
}

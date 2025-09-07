package group_study.week_13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 동전2
 * https://www.acmicpc.net/problem/2294
 */
public class Num3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int num = Integer.parseInt(input[0]);
        int target = Integer.parseInt(input[1]);

        Set<Integer> coinInput = new HashSet<>();


        for (int i = 0; i < num; i++) {
            coinInput.add(Integer.parseInt(br.readLine()));
        }

        List<Integer> coins = coinInput.stream().filter(coin -> coin <= target).collect(Collectors.toList());

        Collections.sort(coins);

        int[] dp = new int[target + 1];

        for (Integer coin : coins) {
            dp[coin] = 1;
        }

        for (Integer coin : coins) {
            for (int i = coin + 1; i <= target; i++) {
                if (dp[i - coin] > 0) {
                    if (dp[i] == 0) {
                        dp[i] = dp[i - coin] + 1;
                    } else {
                        dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                    }
                }
            }
        }

        System.out.println(dp[target] == 0 ? -1 : dp[target]);
    }
}

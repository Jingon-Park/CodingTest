package group_study.week_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * 1,2,3 더하기
 * https://www.acmicpc.net/problem/9095
 */
public class Num4 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());

        List<Integer> nums = List.of(1, 2, 3);

        for (int i = 0; i < input; i++) {

            int targetNum = Integer.parseInt(br.readLine());

            int[] dp = new int[targetNum + 1];
            dp[0] = 1;

            int index = 1;
            while (index <= targetNum) {
                int finalIndex = index;
                int sum = nums.stream().mapToInt(num -> {
                    int temp = finalIndex - num;
                    if (temp >= 0 && dp[temp] > 0) {
                        return dp[temp];
                    }
                    return 0;
                }).sum();
                dp[index] += sum;
                index++;
            }
            System.out.println(dp[targetNum]);
        }
    }
}

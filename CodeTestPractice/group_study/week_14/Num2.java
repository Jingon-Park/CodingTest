package group_study.week_14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 점프
 * https://www.acmicpc.net/problem/1890
 */
public class Num2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        int[][] board = new int[num][num];

        for (int x = 0; x < num; x++) {

            String[] input = br.readLine().split(" ");
            for (int y = 0; y < input.length; y++) {
                board[x][y] = Integer.parseInt(input[y]);
            }
        }

        int[][] dp = new int[num][num];
        dp[0][0] = 1;

        for (int x = 0; x < num; x++) {
            for (int y = 0; y < num; y++) {
                if (board[x][y] > 0) {
                    int step = board[x][y];

                    if (x + step < num) {
                        dp[x + step][y] += dp[x][y];
                    }

                    if (y + step < num) {
                        dp[x][y + step] += dp[x][y];
                    }
                }
            }
        }

        System.out.println(dp[num - 1][num - 1]);
    }

}

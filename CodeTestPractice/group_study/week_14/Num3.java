package group_study.week_14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 내리막길
 * https://www.acmicpc.net/problem/1520
 */
public class Num3 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int xSize = Integer.parseInt(input[0]);
        int ySize = Integer.parseInt(input[1]);

        int[][] map = new int[xSize][ySize];

        for (int x = 0; x < xSize; x++) {
            String[] line = br.readLine().split(" ");

            for (int y = 0; y < ySize; y++) {
                map[x][y] = Integer.parseInt(line[y]);
            }
        }

        int[][] dp = new int[xSize][ySize];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        System.out.println(dfs(0,0, xSize - 1, ySize - 1, map, dp));
    }

    static int dfs(int x, int y,  int targetX, int targetY, int[][] map, int[][] dp) {

        int[] moveX = {0, 0, 1, -1};
        int[] moveY = {1, -1, 0, 0};

        if (x == targetX && y == targetY) {
            return 1;
        }

        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        dp[x][y] = 0;

        for (int i = 0; i < moveX.length; i++) {
            int nextX = x + moveX[i];
            int nextY = y + moveY[i];

            if (nextX >= 0 && nextX < map.length && nextY >= 0 && nextY < map[0].length) {
                if (map[x][y] > map[nextX][nextY]) {
                    dp[x][y] += dfs(nextX, nextY, targetX, targetY, map, dp);
                }
            }
        }

        return dp[x][y];
    }

}

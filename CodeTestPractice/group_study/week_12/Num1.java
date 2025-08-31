package group_study.week_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.acmicpc.net/problem/2178
 * 미로탐색
 */
public class Num1 {


    static int[] mx = {1, -1, 0, 0};
    static int[] my = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        String[] map = new String[n];

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            map[i] = line;
        }

        Queue<int[]> queue = new LinkedList<>();

        boolean[][] visited = new boolean[n][m];

        queue.add(new int[]{0, 0, 1});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            int x = current[0];
            int y = current[1];
            int level = current[2];

            if (x == n - 1 && y == m - 1) {
                answer = Math.min(answer, level);
                break;
            }

            for (int i = 0; i < mx.length; i++) {
                int nextX = x + mx[i];
                int nextY =y + my[i];

                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m
                    && map[nextX].charAt(nextY) == '1' && !visited[nextX][nextY]) {
                    queue.add(new int[]{nextX, nextY, level + 1});
                    visited[nextX][nextY] = true;
                }
            }
        }
        System.out.println(answer);
    }

}

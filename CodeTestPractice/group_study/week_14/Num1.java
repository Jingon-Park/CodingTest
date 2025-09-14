package group_study.week_14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 단지 번호 붙이기
 * https://www.acmicpc.net/problem/2667
 */
public class Num1 {

    static boolean[][]visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        visited = new boolean[num][num];
        String[] map = new String[num];

        for (int i = 0; i < num; i++) {
            map[i] = br.readLine();
        }

        List<Integer> result = new ArrayList<>();

        for (int x = 0; x < map.length; x++) {
            for (int y = 0; y < map.length; y++) {
                int count = getLinkedCount(x, y, map);
                if (count > 0) {
                    result.add(count);
                }
            }
        }

        System.out.println(result.size());

        Collections.sort(result);


        result.forEach(count -> System.out.println(count));

    }

    static int getLinkedCount(int x, int y, String[] map) {
        int count = 0;

        int[] moveX = {1, -1, 0, 0};
        int[] moveY = {0, 0, 1, -1};

        if (visited[x][y] || map[x].charAt(y) == '0') {
            return 0;
        }

        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{x, y});
        visited[x][y] = true;
        count++;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int i = 0; i < moveX.length; i++) {
                int nextX = current[0] + moveX[i];
                int nextY = current[1] + moveY[i];

                if (nextX >= 0 && nextX < map.length && nextY >= 0 && nextY < map.length
                    && !visited[nextX][nextY] && map[nextX].charAt(nextY) == '1') {
                    queue.add(new int[]{nextX, nextY});
                    visited[nextX][nextY] = true;
                    count++;
                }
            }
        }

        return count;
    }

}

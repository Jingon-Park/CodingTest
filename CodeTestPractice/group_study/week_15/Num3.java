package group_study.week_15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 촌수 계산
 * https://www.acmicpc.net/problem/2644
 */
public class Num3 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");

        int targetFrom = Integer.parseInt(input[0]);
        int targetTo = Integer.parseInt(input[1]);

        int count = Integer.parseInt(br.readLine());

        boolean[][] graph = new boolean[num + 1][num + 1];

        for (int i = 0; i < count; i++) {
            String[] line = br.readLine().split(" ");
            int from = Integer.parseInt(line[0]);
            int to = Integer.parseInt(line[1]);

            graph[from][to] = true;
            graph[to][from] = true;
        }

        int result = bfs(targetFrom, targetTo, graph);

        System.out.println(result);
    }

    public static int bfs(int from, int to, boolean[][] graph) {

        int nodeNum = graph.length;
        boolean[] visited = new boolean[nodeNum];

        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{from, 0});
        visited[from] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int level = current[1];

            if (node == to) {
                return level;
            }

            boolean[] linkedNode = graph[node];

            for (int i = 1; i < linkedNode.length; i++) {
                if (linkedNode[i] && !visited[i]) {
                    queue.add(new int[]{i, level + 1});
                    visited[i] = true;
                }
            }
        }

        return -1;
    }

}

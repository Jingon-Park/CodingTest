package group_study.week_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


/**
 * https://www.acmicpc.net/problem/1260
 */
public class Num1 {


    static boolean[][] graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = br.readLine().split(" ");

        int node = Integer.parseInt(firstLine[0]);
        int line = Integer.parseInt(firstLine[1]);
        int startNode = Integer.parseInt(firstLine[2]);
        visited = new boolean[node + 1];

        graph = new boolean[node + 1][node + 1];

        for (int i = 0; i < line; i++) {
            String[] input = br.readLine().split(" ");
            int node1 = Integer.parseInt(input[0]);
            int node2 = Integer.parseInt(input[1]);

            graph[node1][node2] = true;
            graph[node2][node1] = true;
        }

        visited[startNode] = true;
        StringBuilder dfs = dfs(startNode, new StringBuilder());
        visited = new boolean[node + 1];

        String bfs = bfs(startNode);
        System.out.println(dfs);
        System.out.println(bfs);
    }


    public static StringBuilder dfs(int start, StringBuilder sb) {
        sb.append(start + " ");

        boolean[] childs = graph[start];

        for (int i = 1; i < childs.length; i++) {
            if (childs[i] && !visited[i]) {
                visited[i] = true;
                dfs(i, sb);
            }
        }
        return sb;
    }

    public static String bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder result = new StringBuilder();

        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            Integer visitNode = queue.poll();
            result.append(visitNode + " ");
            boolean[] childs = graph[visitNode];

            for (int i = 1; i < childs.length; i++) {
                if (childs[i] && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
        return result.toString();
    }
}

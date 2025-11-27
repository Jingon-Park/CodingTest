package workbook_8707;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class num_1260 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int start = Integer.parseInt(input[2]);

        boolean[][] graph = new boolean[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            String[] line = br.readLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);

            graph[x][y] = graph[y][x] = true;
        }

        String dfs = dfs(graph, start);
        String bfs = bfs(graph, start);

        System.out.println(dfs);
        System.out.println(bfs);


    }

    private static String bfs(boolean[][] graph, int start) {

        StringBuilder sb = new StringBuilder();

        boolean[] visited = new boolean[graph.length];
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            Integer current = queue.pop();
            sb.append(current).append(" ");

            boolean[] childs = graph[current];

            for (int i = 1; i < graph.length; i++) {
                if (childs[i] && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }

        return sb.toString();
    }

    private static String dfs(boolean[][] graph, int start) {
        StringBuilder sb = new StringBuilder();

        boolean[] visited = new boolean[graph.length];
        Deque<Integer> stack = new ArrayDeque<>();

        stack.addLast(start);

        while (!stack.isEmpty()) {
            Integer current = stack.pollLast();
            if (visited[current]) {
                continue;
            }
            sb.append(current).append(" ");
            visited[current] = true;
            boolean[] childs = graph[current];

            for (int i = childs.length - 1; i >= 1; i--) {
                if (childs[i]) {
                    stack.addLast(i);
                }
            }
        }
        return sb.toString();
    }

}

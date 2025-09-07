package group_study.week_13;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 바이러스
 * https://www.acmicpc.net/problem/2606
 */
public class Num1 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        int count = Integer.parseInt(br.readLine());

        boolean[][] network = new boolean[num + 1][num + 1];

        for (int i = 0; i < count; i++) {
            String[] split = br.readLine().split(" ");
            int node1 = Integer.parseInt(split[0]);
            int node2 = Integer.parseInt(split[1]);

             network[node1][node2] = true;
             network[node2][node1] = true;
        }

        int result = bfs(1, network);

        System.out.println(result);

    }

    public static int bfs (int start, boolean[][] network) {
        boolean[] visited = new boolean[network.length + 1];

        visited[start] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        int counter = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            boolean[] linked = network[current];

            for (int i = 1; i < linked.length; i++) {
                if (linked[i] && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                    counter++;
                }
            }
        }
        return counter;
    }

}

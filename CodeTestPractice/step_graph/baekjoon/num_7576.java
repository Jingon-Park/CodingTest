package step_graph.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class num_7576 {

    static int numX;
    static int numY;

    static int[][] graph;

    static int MAX = Integer.MIN_VALUE;

    static Queue<Point> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] xy = br.readLine().split(" ");
        numY = Integer.parseInt(xy[0]);
        numX = Integer.parseInt(xy[1]);


        graph = new int[numX + 1][numY + 1];

        for (int i = 0; i < numX; i++) {
            String[] inputs = br.readLine().split(" ");
            for (int j = 0; j < numY; j++) {
                if (inputs[j].equalsIgnoreCase("1")) {
                    graph[i + 1][j + 1] = 1;
                    queue.add(new Point(i + 1, j + 1, 0));
                } else if (inputs[j].equalsIgnoreCase("-1")) {
                    graph[i + 1][j + 1] = -1;
                }
            }
        }

        bfs();
//        for (int i = 1; i <= numX; i++) {
//            for (int j = 1; j <= numY; j++) {
//                    System.out.print(graph[i][j] + " ");
//            }
//            System.out.println("");
//        }
        for (int i = 1; i <= numX; i++) {
            for (int j = 1; j <= numY; j++) {
                if (graph[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(Math.max(MAX, 0));


    }

    static void bfs() {
        while (!queue.isEmpty()) {
            Point now = queue.poll();
            int x = now.x;
            int y = now.y;
            int level = now.level + 1;
            boolean added = false;

            if (y - 1 > 0 && graph[x][y - 1] == 0) {
                graph[x][y - 1] = level;
                queue.add(new Point(x, y - 1, level));
                added = true;
            }

            if (y + 1 <= numY && graph[x][y + 1] == 0) {
                graph[x][y + 1] = level;
                queue.add(new Point(x, y + 1, level));added = true;
            }

            if (x - 1 > 0 && graph[x - 1][y] == 0) {
                graph[x - 1][y] = level;
                queue.add(new Point(x - 1, y, level));added = true;
            }
            if (x + 1 <= numX && graph[x + 1][y] == 0) {
                graph[x + 1][y] = level;
                queue.add(new Point(x + 1, y, level));added = true;
            }
            if (added) {
                MAX = Math.max(MAX, level);
            }
        }
    }

    static class Point{
        int x;
        int y;
        int level;

        public Point(int x, int y, int level) {
            this.x = x;
            this.y = y;
            this.level = level;
        }
    }
}

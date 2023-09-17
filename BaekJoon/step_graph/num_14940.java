package step_graph;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class num_14940 {
    static int x;
    static int y;

    static int[][] graph;
    static int[][] levels;

    static boolean[][] checker;
    static Point start;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();
        String[] splited = line.split(" ");

        x = Integer.parseInt(splited[0]);
        y = Integer.parseInt(splited[1]);

        graph = new int[x + 1][y + 1];
        levels = new int[x + 1][y + 1];
        checker = new boolean[x + 1][y + 1];

        for (int i = 1; i <= x; i++) {
            String inputLine = br.readLine();
            String[] inputSplit = inputLine.split(" ");
            for (int j = 0; j < y; j++) {
                if (inputSplit[j].equalsIgnoreCase("1")) {
                    graph[i][j + 1] = 1;
                    levels[i][j + 1] = -1;

                } else if (inputSplit[j].equalsIgnoreCase("2")) {
                    start = new Point(i, j + 1, 0);
                }
            }
        }

        bfs();

        levels[start.x][start.y] = 0;
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                bw.write(levels[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();

    }

    static void bfs() {

        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
        checker[start.x][start.y] = true;
        while (!queue.isEmpty()) {

            Point now = queue.poll();

            int level = now.level + 1;
            //위
            if (now.y - 1 > 0 && graph[now.x][now.y - 1] == 1 && !checker[now.x][now.y - 1]) {
                queue.add(new Point(now.x, now.y - 1, level));
                levels[now.x][now.y - 1] = level;
                checker[now.x][now.y - 1] = true;
            }
            //아래
            if (now.y + 1 <= y && graph[now.x][now.y + 1] == 1 && !checker[now.x][now.y + 1]) {
                queue.add(new Point(now.x, now.y + 1, level));
                levels[now.x][now.y + 1] = level;
                checker[now.x][now.y + 1] = true;
            }
            //좌
            if (now.x - 1 > 0 && graph[now.x - 1][now.y] == 1 && !checker[now.x - 1][now.y]) {
                queue.add(new Point(now.x - 1, now.y, level));
                levels[now.x - 1][now.y] = level;
                checker[now.x - 1][now.y] = true;

            }
            //우
            if (now.x + 1 <= x && graph[now.x + 1][now.y] == 1 && !checker[now.x + 1][now.y]) {
                queue.add(new Point(now.x + 1, now.y, level));
                levels[now.x + 1][now.y] = level;
                checker[now.x + 1][now.y] = true;
            }

        }

    }


    static class Point {
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



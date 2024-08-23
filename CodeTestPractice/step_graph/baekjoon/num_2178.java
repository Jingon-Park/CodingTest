package step_graph.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class num_2178 {


    static int M;
    static int N;

    static int[][] graph;
    static boolean[][] checker;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);

        graph = new int[N + 1][M + 1];
        checker = new boolean[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String read = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = read.charAt(j);
                if (c == '1') {
                    graph[i][j + 1] = 1;
                }
            }
        }

        bfs(1, 1);
        System.out.println(graph[N][M]);


    }

    public static void bfs(int x, int y) {

        Queue<Point> queue = new LinkedList<>();
        if (!checker[x][y]) {
            checker[x][y] = true;
            Point point = new Point(x, y);
            queue.add(point);
        } else {
            return;
        }

        while (!queue.isEmpty()) {
            Point target = queue.poll();
            int level = graph[target.x][target.y] + 1;
            //완쪽
            if (target.y - 1 > 0 && !checker[target.x][target.y - 1] && graph[target.x][target.y - 1] == 1) {
                queue.add(new Point(target.x, target.y - 1));

                graph[target.x][target.y - 1] = level;
                checker[target.x][target.y - 1] = true;
            }
            //위쪽
            if (target.x - 1 > 0 && !checker[target.x - 1][target.y] && graph[target.x - 1][target.y] == 1) {
                queue.add(new Point(target.x - 1, target.y));
                graph[target.x - 1][target.y] = level;
                checker[target.x - 1][target.y] = true;
            }

            //오른쪽
            if (target.y + 1 <= M && !checker[target.x][target.y + 1] && graph[target.x][target.y + 1] == 1) {
                queue.add(new Point(target.x, target.y + 1));
                graph[target.x][target.y + 1] = level;
                checker[target.x][target.y + 1] = true;
            }

            //아래
            if (target.x + 1 <= N && !checker[target.x + 1][target.y] && graph[target.x + 1][target.y] == 1) {
                queue.add(new Point(target.x + 1, target.y));
                graph[target.x + 1][target.y] = level;
                checker[target.x + 1][target.y] = true;
            }
        }
    }



}

class Point {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

}

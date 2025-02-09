package step_graph.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class GameMapQueue {


    static class Position {

        public int x;
        public int y;
        public int counter;

        public Position(int x, int y, int counter) {
            this.x = x;
            this.y = y;
            this.counter = counter;
        }
    }
    static class Solution {

        static int X, Y;
        static int[] dx = {1, 0, -1, 0}; // 우, 하, 좌, 상
        static int[] dy = {0, 1, 0, -1};
        static boolean[][] visited;
        static int result = -1; // 기본값을 -1로 설정하여, 도달하지 못하면 -1 반환
        static Queue<Position> queue = new LinkedList<>();

        public int solution(int[][] maps) {
            X = maps.length;
            Y = maps[0].length;
            visited = new boolean[X][Y];

            bfs(0, 0, maps, 1);

            return result;
        }

        public void bfs(int x, int y, int[][] maps, int counter) {

            Position position = new Position(x, y, counter);
            queue.add(position);
            visited[x][y] = true;


            while (!queue.isEmpty()) {
                Position current = queue.poll();
                // 목표 지점에 도달하면 최소 거리 갱신
                if (current.x == X - 1 && current.y == Y - 1) {
                    result = current.counter;
                    return;
                }

                // 4방향 탐색
                for (int i = 0; i < 4; i++) {
                    int nx = current.x + dx[i];
                    int ny = current.y + dy[i];

                    if (nx >= 0 && nx < X && ny >= 0 && ny < Y && maps[nx][ny] == 1 && !visited[nx][ny]) {
                        Position next = new Position(nx, ny, current.counter + 1);
                        queue.add(next);
                        visited[next.x][next.y] = true; //큐에 add이후 바로 visited를 해주어야 중복 처리를 방지
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] maps = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1},
            {0, 0, 0, 0, 1}};
        Solution solution = new Solution();
        int result = solution.solution(maps);
        System.out.println(result);

    }
}

package step_graph.programmers;

import java.util.PriorityQueue;

public class GameMap {


    static class Solution {
    static int X, Y;
    static int[] dx = {1, 0, -1, 0}; // 우, 하, 좌, 상
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;
    static int result = -1; // 기본값을 -1로 설정하여, 도달하지 못하면 -1 반환

    public int solution(int[][] maps) {
        X = maps.length;
        Y = maps[0].length;
        visited = new boolean[X][Y];

        dfs(0, 0, maps, 1);

        return result;
    }

    public void dfs(int x, int y, int[][] maps, int counter) {
        // 목표 지점에 도달하면 최소 거리 갱신
        if (x == X - 1 && y == Y - 1) {
            if (result == -1 || counter < result) {
                result = counter;
            }
            return;
        }

        visited[x][y] = true;

        // 4방향 탐색
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < X && ny >= 0 && ny < Y && maps[nx][ny] == 1 && !visited[nx][ny]) {
                dfs(nx, ny, maps, counter + 1);
            }
        }

        // 백트래킹 - 탐색이 끝나면 방문 해제
        visited[x][y] = false;
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

package step_graph.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class ItemGet {

    static class Position {

        public int x;
        public int y;
        public int moved;

        public Position(int x, int y, int moved) {
            this.x = x;
            this.y = y;
            this.moved = moved;
        }

        @Override
        public String toString() {
            return "position= " + this.x + ", " + this.y + " m : " + moved;
        }
    }

    static class Solution {

        static int[][] map = new int[102][102];
        static int[][] customMap = new int[102][102];
        static int[] moveX = {1, 0, -1, 0, 1, -1, 1, -1};
        static int[] moveY = {0, 1, 0, -1, 1, -1, -1, 1};
        static boolean[][] visited = new boolean[102][102];



        public int solution(int[][] rectangle, int characterX, int characterY, int itemX,
            int itemY) {
            int answer = 0;
            characterX *= 2;
            characterY *= 2;
            itemX *= 2;
            itemY *= 2;

            for (int i = 0; i < rectangle.length; i++) {

                int leftX = rectangle[i][0] * 2;
                int leftY = rectangle[i][1] * 2;
                int rightX = rectangle[i][2] * 2;
                int rightY = rectangle[i][3] * 2;

                for (int x = leftX; x <= rightX; x++) {
                    for (int y = leftY; y <= rightY; y++) {
                        map[x][y] = 2;
                    }
                }
            }

            for (int y = 0; y <= 101; y++) {
                for (int x = 0; x <= 101; x++) {
                    if (map[x][y] == 2) {
                        for (int i = 0; i < 8; i++) {
                            int nextX = x + moveX[i];
                            int nextY = y + moveY[i];
                            if (nextX >= 0 && nextX <= 101 && nextY >= 0 && nextY <= 101) {
                                //TODO customMap을 생성했지만, 인풋 예제 1의 3,5와 3,6은 서로 연결된 외각선이 아닌데 연결된 외각선으로 판단 중
                                //위 문제를 해결하기 위해 index를 2배로 늘려 그래프의 정밀도를 올림
                                if (map[nextX][nextY] == 0) {
                                    customMap[x][y] = 1;
                                    break;
                                }
                            }
                        }
                    }
                }
            }

            Position startPosition = new Position(characterX, characterY, 0);
            Queue<Position> queue = new LinkedList<>();

            queue.add(startPosition);
            visited[startPosition.x][startPosition.y] = true;

            while (!queue.isEmpty()) {
                Position currentPosition = queue.poll();


                if (currentPosition.x == itemX && currentPosition.y == itemY) {
                    return currentPosition.moved / 2;
                }

                for (int i = 0; i < 4; i++) {
                    int nextX = currentPosition.x + moveX[i];
                    int nextY = currentPosition.y + moveY[i];
                    if (nextX >= 0 && nextX <= 101 && nextY >= 0 && nextY <= 101
                        && customMap[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                        Position nextPosition = new Position(nextX, nextY, currentPosition.moved + 1);
                        queue.add(nextPosition);
                        visited[nextPosition.x][nextPosition.y] = true;
                    }
                }
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        int[][] rectangle = {{1, 1, 7, 4}, {3, 2, 5, 5}, {4, 3, 6, 9}, {2, 6, 8, 8}};
        int characterX = 1;
        int characterY = 3;
        int itemX = 7;
        int itemY = 8;
        Solution solution = new Solution();
        int result = solution.solution(rectangle, characterX, characterY, itemX, itemY);

        System.out.println(result);
    }

}

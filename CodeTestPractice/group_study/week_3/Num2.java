package group_study.week_3;

import java.util.LinkedList;
import java.util.Queue;

public class Num2 {
    static class Solution {

        int[] mX = {1, -1, 0, 0};
        int[] mY = {0, 0, 1, -1};

        boolean[][] visited;
        int sizeX;
        int sizeY;
        int[][] searchLand;
        Queue<Integer> pX = new LinkedList<>();
        Queue<Integer> pY = new LinkedList<>();
        int counter = 0;

        public int solution(int[][] land) {
            int answer = 0;
            sizeX = land.length;
            sizeY = land[0].length;

            searchLand = new int[sizeX][sizeY];
            visited = new boolean[sizeX][sizeY];

            for (int i = 0; i < sizeX; i++) {
                for (int j = 0; j < sizeY; j++) {
                    if (land[i][j] == 1 && !visited[i][j]) {
                        bfs(i, j, land);
                    }
                    counter = 0;
                }
            }

            for (int[] ints : searchLand) {
                for (int anInt : ints) {
                    System.out.print( anInt + " ");
                }
                System.out.println("");
            }

            for (int i = 0; i < sizeY; i++) {
                int counter = 0;
                boolean check = true;
                for (int j = 0; j < sizeX; j++) {
                    if (searchLand[j][i] > 0 && check) {
                        counter += searchLand[j][i];
                        check = false;
                    }

                    if (searchLand[j][i] == 0) {
                        check = true;
                    }
                }
                answer = Math.max(counter, answer);
            }

            return answer;
        }

        public int bfs(int x, int y, int[][] land) {

            visited[x][y] = true;
            pX.add(x);
            pY.add(y);
            counter++;


            while (!pX.isEmpty() && !pY.isEmpty()) {
                int currentX = pX.poll();
                int currentY = pY.poll();

                for (int i = 0; i < mX.length; i++) {
                    int moveX = currentX + mX[i];
                    int moveY = currentY + mY[i];
                    if (moveX >= 0 && moveX < sizeX && moveY >= 0 && moveY < sizeY) {
                        if (land[moveX][moveY] == 1 && !visited[moveX][moveY]) {
                            pX.add(moveX);
                            pY.add(moveY);
                            counter = bfs(moveX, moveY, land);
                        }
                    }
                }
            }
            searchLand[x][y] = counter;
            return counter;
        }
    }

    public static void main(String[] args) {

        int[][] land = {{0, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 1, 1, 0, 0},
            {1, 1, 0, 0, 0, 1, 1, 0}, {1, 1, 1, 0, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0, 1, 1}};

        Solution solution = new Solution();

        int result = solution.solution(land);
        System.out.println(result);
    }
    

}

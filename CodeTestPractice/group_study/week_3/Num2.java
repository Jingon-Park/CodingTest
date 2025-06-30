package group_study.week_3;

import java.util.ArrayList;
import java.util.List;

public class Num2 {
    static class Solution {

        int[] mX = {1, -1, 0, 0};
        int[] mY = {0, 0, 1, -1};

        boolean[][] visited;
        int sizeX;
        int sizeY;
        int[][] searchLand;
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
                    System.out.print(anInt + " ");
                }
                System.out.println("");
            }

            for (int x = 0; x < sizeY; x++) {
                int sum = 0;
                boolean check = true;
                for (int y = 0; y < sizeX; y++) {
                    if (searchLand[y][x] > 0 && check) {
                        sum += searchLand[y][x];
                        check = false;
                    }
                    if (searchLand[y][x] == 0) {
                        check = true;
                    }
                }
                answer = Math.max(answer, sum);
            }


            return answer;
        }

        public void bfs(int x, int y, int[][] land) {

            List<Integer> listX = new ArrayList<>();
            List<Integer> listY = new ArrayList<>();
            int index = 0;
            visited[x][y] = true;
            listX.add(x);
            listY.add(y);
            counter++;


            while (listX.size() > index) {
                int currentX = listX.get(index);
                int currentY = listY.get(index);
                index++;

                for (int i = 0; i < mX.length; i++) {
                    int moveX = currentX + mX[i];
                    int moveY = currentY + mY[i];
                    if (moveX >= 0 && moveX < sizeX && moveY >= 0 && moveY < sizeY) {
                        if (land[moveX][moveY] == 1 && !visited[moveX][moveY]) {
                            listX.add(moveX);
                            listY.add(moveY);
                            visited[moveX][moveY] = true;
                            counter++;
                        }
                    }
                }
            }
            for (int i = 0; i < index; i++) {
                searchLand[listX.get(i)][listY.get(i)] = counter;
            }
        }
    }

    public static void main(String[] args) {

//        int[][] land = {{0, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 1, 1, 0, 0},
//            {1, 1, 0, 0, 0, 1, 1, 0}, {1, 1, 1, 0, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0, 1, 1}};
//
        int[][] land = {{1, 0, 1, 0, 1, 1}, {1, 0, 1, 0, 0, 0}, {1, 0, 1, 0, 0, 1},
            {1, 0, 0, 1, 0, 0}, {1, 0, 0, 1, 0, 1}, {1, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1}};

        Solution solution = new Solution();

        int result = solution.solution(land);
        System.out.println(result);
    }
    

}

package group_study.week_3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Num2 {
    static class Solution {

        int[] mX = {1, -1, 0, 0};
        int[] mY = {0, 0, 1, -1};

        boolean[][] visited;
        int sizeX;
        int sizeY;
        int[][] searchLand;
        int counter = 0;

        int[] oil;

        public int solution(int[][] land) {
            int answer = 0;
            sizeY = land.length;
            sizeX = land[0].length;

            searchLand = new int[sizeY][sizeX];
            visited = new boolean[sizeY][sizeX];
            oil = new int[sizeX];

            for (int x = 0; x < sizeX; x++) {
                for (int y = 0; y < sizeY; y++) {
                    if (land[y][x] == 1 && !visited[y][x]) {
                        bfs(x, y, land);
                    }
                    counter = 0;
                }
            }
            for (int i : oil) {
                answer = Math.max(answer, i);
            }



            return answer;
        }

        public void bfs(int x, int y, int[][] land) {

            List<Integer> listX = new ArrayList<>();
            List<Integer> listY = new ArrayList<>();
            int index = 0;
            visited[y][x] = true;
            listX.add(x);
            listY.add(y);
            counter++;
            Set<Integer> line = new HashSet<>();

            while (listX.size() > index) {
                int currentX = listX.get(index);
                int currentY = listY.get(index);
                index++;
                line.add(currentX);

                for (int i = 0; i < mX.length; i++) {
                    int moveX = currentX + mX[i];
                    int moveY = currentY + mY[i];
                    if (moveX >= 0 && moveX < sizeX && moveY >= 0 && moveY < sizeY) {
                        if (land[moveY][moveX] == 1 && !visited[moveY][moveX]) {
                            listX.add(moveX);
                            listY.add(moveY);
                            visited[moveY][moveX] = true;
                            counter++;
                        }
                    }
                }
            }
            for (int i = 0; i < index; i++) {
                searchLand[listY.get(i)][listX.get(i)] = counter;
            }

            for (Integer integer : line) {
                oil[integer] += counter;
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

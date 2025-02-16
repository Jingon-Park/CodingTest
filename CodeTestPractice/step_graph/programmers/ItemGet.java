package step_graph.programmers;

public class ItemGet {

    static class Solution {

        static int[][] map = new int[51][51];
        static int[] moveX = {1, 0, -1, 0};
        static int[] moveY = {0, 1, 0, -1};



        public int solution(int[][] rectangle, int characterX, int characterY, int itemX,
            int itemY) {
            int answer = 0;

            for (int i = 0; i < rectangle.length; i++) {

                int leftX = rectangle[i][0];
                int leftY = rectangle[i][1];
                int rightX = rectangle[i][2];
                int rightY = rectangle[i][3];

                for (int x = leftX; x <= rightX; x++) {
                    for (int y = leftY; y <= rightY; y++) {
                        map[x][y] = 1;
                    }
                }
            }

            for (int y = 50; y >= 0; y--) {
                for (int x = 0; x <= 50; x++) {
                    System.out.print(map[x][y]);
                }
                System.out.println("");
            }

            System.out.println("");



            for (int y = 0; y <= 50; y++) {
                for (int x = 0; x <= 50; x++) {
                    boolean checker = false;
                    for (int i = 0; i < 4; i++) {
                        int nextX = x + moveX[i];
                        int nextY = y + moveY[i];
                        if (nextX >= 0 && nextX <= 50 && nextY >= 0 && nextY <= 50) {
                            //TODO map 변환 중 경계가 아니라 0으로 바꾼 x,y 때문에 다음에 경계를 확인하는 과정에서 경계가 아닌 x,y 인데도 경계로 판별됨
                            if (map[nextX][nextY] == 0) {
                                checker = true;
                            }
                        }
                    }
                    if (!checker) {
                        map[x][y] = 0;
                    }
                }
            }

            for (int y = 50; y >= 0; y--) {
                for (int x = 0; x <= 50; x++) {
                    System.out.print(map[x][y]);
                }
                System.out.println("");
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

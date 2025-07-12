package group_study.week_5;

public class Num1 {
    static class Solution {

        static int[][][] checker = {{
            {0, 0}, {0, 1}, {0, 2}},
            {{1, 0}, {1, 1}, {1, 2}},
            {{2, 0}, {2, 1}, {2, 2}},
            {{0, 0}, {1, 0}, {2, 0}},
            {{0, 1}, {1, 1}, {2, 1}},
            {{0, 2}, {1, 2}, {2, 2}},
            {{0, 0}, {1, 1}, {2, 2}},
            {{0, 2}, {1, 1}, {2, 0}}};
        public int solution(String[] board) {
            int answer = 0;
            int oRemain = 0;
            int xRemain = 0;
            boolean oWin = false;
            boolean xWin = false;

            for (String s : board) {
                String[] split = s.split("");
                for (String s1 : split) {
                    if (s1.equals("O")) {
                        oRemain++;
                    } else if (s1.equals("X")) {
                        xRemain++;
                    }
                }
            }

            if (xRemain > oRemain || Math.abs(xRemain - oRemain) > 1) {
                return 0;
            }

            for (int[][] ints : checker) {
                boolean check = true;
                for (int[] anInt : ints) {
                    int x = anInt[0];
                    int y = anInt[1];
                    char c = board[x].charAt(y);
                    if (c != 'X') {
                        check = false;
                    }
                }
                if (check) {
                    xWin = true;
                }
            }

            for (int[][] ints : checker) {
                boolean check = true;
                for (int[] anInt : ints) {
                    int x = anInt[0];
                    int y = anInt[1];
                    char c = board[x].charAt(y);
                    if (c != 'O') {
                        check = false;
                    }
                }
                if (check) {
                    oWin = true;
                }
            }

            if (xWin && oWin) {
                return 0;
            }

            if (xWin && !oWin && xRemain == oRemain) {
                return 1;
            }

            if (oWin && !xWin && oRemain > xRemain) {
                return 1;
            }
            if (!oWin && !xWin) {
                return 1;
            }

            return answer;
        }
    }
    public static void main(String[] args) {
        String[] board = {"O.X", ".O.", "..X"};

        Solution solution = new Solution();
        int result = solution.solution(board);

        System.out.println(result);


    }

}

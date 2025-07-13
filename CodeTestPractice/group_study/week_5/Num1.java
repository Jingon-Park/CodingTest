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

            oWin = winnerChecker('O', board);
            xWin = winnerChecker('X', board);

            //승자가 둘 인경우
            if (xWin && oWin) {
                return 0;
            }

            //X가 승자이고, X와 O의 사용 갯수가 같은 경우
            if (xWin && !oWin && xRemain == oRemain) {
                return 1;
            }

            //O가 승자이고, O의 갯수가 더 많은 경우
            if (oWin && !xWin && oRemain > xRemain) {
                return 1;
            }

            //승자가 없는 경우
            if (!oWin && !xWin) {
                return 1;
            }

            return answer;
        }

        public boolean winnerChecker(char target, String[] board) {

            for (int[][] ints : checker) {
                boolean check = true;
                for (int[] anInt : ints) {
                    int x = anInt[0];
                    int y = anInt[1];
                    char c = board[x].charAt(y);
                    if (c != target) {
                        check = false;
                    }
                }
                if (check) {
                    return true;
                }
            }

            return false;
        }
    }
    public static void main(String[] args) {
        String[] board = {"O.X", ".O.", "..X"};

        Solution solution = new Solution();
        int result = solution.solution(board);

        System.out.println(result);


    }

}

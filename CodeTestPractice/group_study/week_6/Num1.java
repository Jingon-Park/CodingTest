package group_study.week_6;

public class Num1 {
    static class Solution {
        public int[] solution(int n, long left, long right) {
            int size = (int)(right - left);
            int[] answer = new int[size + 1];
            int index = 0;
            for(long i = left; i <= right ; i++) {
                answer[index++] = getNum(n, i);
            }
            return answer;
        }

        public int getNum(int n, long index){
            int row = (int) (index / n);
            int col = (int) (index % n);
            if (col  < row) {
                return row + 1;
            }else {
                return col + 1;
            }
        }
    }
    public static void main(String[] args) {
        int n = 3;
        int left = 2;
        int right = 5;
        Solution solution = new Solution();
        int[] solution1 = solution.solution(n, left, right);

        for (int i : solution1) {
            System.out.print(i + " ");

        }

    }

}

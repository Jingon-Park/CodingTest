package group_study.week_6;

public class Num1 {
    static class Solution {
        public int[] solution(int n, long left, long right) {
            int size = (int)(right - left);//리턴할 배열 크기
            int[] answer = new int[size + 1];
            int index = 0;//리턴할 배열의 인덱스
            for(long i = left; i <= right ; i++) {//1차원으로 변경한 배열의 인덱스
                answer[index++] = getNum(n, i);
            }
            return answer;
        }

        //1차원 배열의 인덱스가 원래 x행 y 열에 있는지 확인하여, 값 응닶
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

package group_study.week_8;

import java.util.PriorityQueue;
import java.util.Queue;

public class Num3 {

    static class Solution {

        public int solution(int[] A, int[] B) {
            int answer = 0;
            //랜덤으로 할당받은 수 배열 중에 가장 큰 수를 조회하기 위한 큐
            Queue<Integer> qpA = new PriorityQueue<>((o1,o2) -> o2 - o1);
            Queue<Integer> qpB = new PriorityQueue<>((o1, o2) -> o2 - o1);

            for (int i = 0; i < A.length; i++) {
                qpA.add(A[i]);
                qpB.add(B[i]);
            }

            //A 큐가 빌때까지 반복
            while (!qpA.isEmpty()) {
                Integer aNum = qpA.poll();//A 큐는 무조건 꺼냄
                if (aNum < qpB.peek()) {//B큐는 이길 수 있으면 꺼냄
                    answer++;
                    qpB.poll();
                }
            }
            return answer;
        }
    }
    public static void main(String[] args) {

        int[] A = {1, 3, 5, 7};
        int[] B = {2, 2, 6, 8};
        Solution solution = new Solution();

        int result = solution.solution(A, B);
        System.out.println(result);

    }

}

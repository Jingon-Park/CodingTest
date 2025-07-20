package group_study.week_6;

import java.util.LinkedList;
import java.util.Queue;

public class Num3 {

    static class Solution {
        public long solution(int[] sequence) {

            int[] plusSq = new int[sequence.length];
            int[] minusSq = new int[sequence.length];

            //최초 시퀀스에 펄스 적용
            for (int i = 0; i < sequence.length; i++) {
                if (i % 2 == 0) {
                    plusSq[i] = sequence[i];
                    minusSq[i] = sequence[i] * -1;
                }else {
                    plusSq[i] = sequence[i] * -1;
                    minusSq[i] = sequence[i];
                }
            }

            //각각 펄스의 최대 값과 현재 부분 수열의 합
            long pSqMax = Integer.MIN_VALUE;
            long mSqMax = Integer.MIN_VALUE;
            long pSum = 0;
            long mSum = 0;

            for (int i = 0; i < sequence.length; i++) {

                //이전 부분수열의 합이 음수가 되면 버림
                pSum = Math.max(plusSq[i], pSum + plusSq[i]);
                mSum = Math.max(minusSq[i], mSum + minusSq[i]);

                //부분 수열의 합의 최대값 확인
                pSqMax = Math.max(pSqMax, pSum);
                mSqMax = Math.max(mSqMax, mSum);

            }
            return Math.max(pSqMax, mSqMax);
        }
    }
    public static void main(String[] args) {

        int[] seq = {2, 3, -6, 1, 3, -1, 2, 4};
        Solution solution = new Solution();

        long result = solution.solution(seq);

        System.out.println(result);
    }

}

package group_study.week_6;

import java.util.LinkedList;
import java.util.Queue;

public class Num3 {

    static class Solution {
        public long solution(int[] sequence) {
            //
            long answer = 0;

            LinkedList<Integer> plusQ = new LinkedList<>();
            LinkedList<Integer> minusQ = new LinkedList<>();
            long pSumMax = 0;
            long mSumMax = 0;
            long pSum = 0;
            long mSum = 0;

            for (int i = 0; i < sequence.length; i++) {
                int target = sequence[i];
                long pTemp = pSum;
                long mTemp = mSum;

                if (i % 2 == 0) {
                    plusQ.add(target);
                    minusQ.add(target * -1);
                }else {
                    plusQ.add(target * -1);
                    minusQ.add(target);
                }
                pSum += plusQ.getLast();
                mSum += minusQ.getLast();

                pSumMax = Math.max(pSumMax, pSum);
                mSumMax = Math.max(mSumMax, mSum);

                int pFirst = plusQ.getFirst();
                int mFirst = minusQ.getFirst();
                if (pSum - pFirst > pSum) {
                    pSum -= pFirst;
                    plusQ.removeFirst();
                    pSumMax = Math.max(pSumMax, pSum);
                }
                if (mSum - mFirst > mSum) {
                    mSum -= mFirst;
                    minusQ.removeFirst();
                    mSumMax = Math.max(mSumMax, mSum);
                }


            }


            return Math.max(mSumMax, pSumMax);
        }
    }
    public static void main(String[] args) {

        int[] seq = {2, 3, -6, 1, 3, -1, 2, 4};
        Solution solution = new Solution();

        long result = solution.solution(seq);

        System.out.println(result);
    }

}

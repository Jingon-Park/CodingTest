package step_stack.programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FunctionDevelop {

    static class Solution {
        public int[] solution(int[] progresses, int[] speeds) {

            List<Integer> answer = new ArrayList<>();

            Queue<ProgressInfo> progressQueue = new LinkedList<>();


            for (int i = 0; i < progresses.length; i++) {
                progressQueue.add(new ProgressInfo(progresses[i], speeds[i]));

            }

            while (!progressQueue.isEmpty()) {

                progressQueue.forEach(
                    progressInfo -> progressInfo.currentProgress += progressInfo.dayProgress);

                System.out.println(progressQueue);
                int count = 0;
                while (!progressQueue.isEmpty() && progressQueue.peek().currentProgress >= 100 ) {
                    count++;
                    progressQueue.poll();
                }
                if (count > 0) {
                    answer.add(count);
                }
            }

            return answer.stream().mapToInt(Integer::intValue).toArray();
        }
    }

    static class ProgressInfo{

        public int currentProgress;
        public int dayProgress;

        public ProgressInfo(int currentProgress, int dayProgress) {
            this.currentProgress = currentProgress;
            this.dayProgress = dayProgress;
        }
    }

    public static void main(String[] args) {

        int[] solution = new Solution().solution(new int[]{93, 30, 55}, new int[]{1, 30, 5});

        for (int i : solution) {
            System.out.println(i);
        }



    }

}

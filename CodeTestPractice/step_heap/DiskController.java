package step_heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class DiskController {


    static class Solution {
        public static int solution(int[][] jobs) {
            int answer = 0;
            int index = 0;
            int currentTime = 0;

            PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);


            Arrays.sort(jobs, (o1, o2) -> {
                return o1[0] - o2[0]; // 첫번째 숫자 기준 오름차순 {1,30}{2,10}{3,50}{4,20}{5,40}
            });

            //큐가 비어지않거나, index가 jobs의 길이보다 작을 때까지 반복
            while (!priorityQueue.isEmpty()|| index < jobs.length) {

                while (index < jobs.length && jobs[index][0] <= currentTime) {
                    //현재 시간보다 먼저 유입된 요청을 큐에 추가
                    priorityQueue.offer(jobs[index++]);
                }

                if (priorityQueue.isEmpty()) {
                    //큐가 비어있다면 가장 먼저 시작해야할 작업의 시작 시간을 현재시간으로 설정
                    currentTime = jobs[index][0];
                }else {
                    int[] poll = priorityQueue.poll();

                    int time = poll[1] + (currentTime - poll[0]);


                    answer += time;
                    currentTime += poll[1];
                }
            }


            return answer / jobs.length;
        }
    }


    public static void main(String[] args) {
        int[][] input = {{0, 3}, {1, 9}, {2, 6}};
        Solution solution = new Solution();

        int solution1 = solution.solution(input);



    }
}

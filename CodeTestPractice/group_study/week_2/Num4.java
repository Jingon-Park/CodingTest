package group_study.week_2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Num4 {

    static class Solution {
        public int solution(String[][] book_time) {
            int answer = 0;

            int[][] book_int = new int[book_time.length][2];

            for (int i = 0; i < book_time.length; i++) {
                String[] startSplit = book_time[i][0].split(":");
                String[] endSplit = book_time[i][1].split(":");
                int start = Integer.parseInt(startSplit[0] + endSplit[1]);
                int end = Integer.parseInt(endSplit[0] + endSplit[1]);
                book_int[i][0] = start;
                book_int[i][1] = end;
            }

            Arrays.sort(book_int, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });
            PriorityQueue<Integer> rooms = new PriorityQueue<>(new Comparator<Integer>(){
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });



            for (int[] ints : book_int) {

                if (rooms.size() == 0) {
                    rooms.add(ints[1]);
                    answer++;
                } else {
                    int firstEndTime = rooms.peek() + 10;
                    if (firstEndTime % 100 > 59) {
                        firstEndTime = (firstEndTime / 100) * 100 + 100 + (firstEndTime % 100 - 60);
                    }
                    if (ints[0] >= firstEndTime) {
                        rooms.poll();
                        rooms.add(ints[1]);
                    }else {
                        rooms.add(ints[1]);
                        answer++;
                    }
                }

            }
            return answer;
        }
    }

    public static void main(String[] args) {
        String[][] bookTime = {{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"},
            {"14:10", "19:20"}, {"18:20", "21:20"}};

        Solution solution = new Solution();
        int result = solution.solution(bookTime);
        System.out.println(result);

    }

}

package step_greedy.programmers;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class LifeBoat {

    static class Solution {
        public int solution(int[] people, int limit) {
//            int answer = 0;
//
//            // int 배열을 LinkedList<Integer>로 변환
//            LinkedList<Integer> linkedList = Arrays.stream(people)
//                .boxed() // int -> Integer (Auto-boxing)
//                .collect(Collectors.toCollection(LinkedList::new));
//
//            Collections.sort(linkedList);
//
//
//
//            while (!linkedList.isEmpty() && linkedList.peekFirst() <= limit / 2) {
//                Integer first = linkedList.pollFirst();
//                answer++;
//                if (!linkedList.isEmpty() && linkedList.peekFirst() <= limit - first) {
//                    for (int i = linkedList.size() - 1; i >= 0; i--) {
//                        Integer next = linkedList.get(i);
//                        if (next <= limit - first) {
//                            linkedList.remove(i);
//                            break;
//                        }
//                    }
//                }
//            }
//            answer += linkedList.size();
//            return answer;
            Arrays.sort(people); // O(N log N)
            int left = 0;
            int right = people.length - 1;
            int answer = 0;

            while (left <= right) {
                if (people[left] + people[right] <= limit) {
                    left++; // 가벼운 사람도 태운다.
                }
                right--; // 무거운 사람 태움
                answer++; // 보트 하나 사용
            }

            return answer;
        }
    }
    public static void main(String[] args) {

        Solution solution = new Solution();

        int[] people = {70, 50, 80, 50};
        int limit = 100;
        int result = solution.solution(people, limit);

        System.out.println(result);
    }

}

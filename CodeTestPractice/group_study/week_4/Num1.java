package group_study.week_4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 광물 캐기
 */
public class Num1 {

    static class Solution {
        public int solution(int[] picks, String[] minerals) {
            int answer = 0;
            int pickSize = 0;
            for (int pick : picks) {
                pickSize += pick;
            }

            List<Order> list = new ArrayList<>();

            Order order = new Order();
            int maxIndex = Math.min(pickSize * 5, minerals.length);
            for (int i = 0; i < maxIndex; i++) {
                if (i % 5 == 0) {
                    order = new Order();
                    order.index = i;
                    list.add(order);
                }
                String miner = minerals[i];
                if (miner.equals("diamond")) {
                    order.stoneSum += 25;
                    order.ironSum += 5;
                    order.diamondSum += 1;
                } else if (miner.equals("iron")) {
                    order.stoneSum += 5;
                    order.ironSum += 1;
                    order.diamondSum += 1;
                }else {
                    order.stoneSum += 1;
                    order.ironSum += 1;
                    order.diamondSum += 1;
                }
            }
            Collections.sort(list, new Comparator<Order>() {
                @Override
                public int compare(Order o1, Order o2) {
                    if (o2.stoneSum != o1.stoneSum) return o2.stoneSum - o1.stoneSum;
                    if (o2.ironSum != o1.ironSum) return o2.ironSum - o1.ironSum;
                    return o2.diamondSum - o1.diamondSum;
                }
            });

            int idx = 0;
            while (picks[0] + picks[1] + picks[2] > 0 && idx < list.size()) {

                if (picks[0] > 0) {
                    picks[0]--;
                    answer += list.get(idx++).diamondSum;
                } else if (picks[1] > 0) {
                    picks[1]--;
                    answer += list.get(idx++).ironSum;
                } else if (picks[2] > 0) {
                    picks[2]--;
                    answer += list.get(idx++).stoneSum;
                }
            }

            return answer;
        }
        class Order {
            public int index = 0;
            public int stoneSum = 0;
            public int ironSum = 0;
            public int diamondSum = 0;

            @Override
            public String toString() {
                return "Order{" +
                    "index=" + index +
                    ", stoneSum=" + stoneSum +
                    ", ironSum=" + ironSum +
                    ", diamondSum=" + diamondSum +
                    '}';
            }
        }
    }
    public static void main(String[] args) {

        int[] pick = {1, 3, 2};
        String[] minerals = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron",
            "stone"};

//        int[] pick = {0, 1, 1};
//        String[] minerals = {
//    "diamond", "diamond", "diamond", "diamond", "diamond",   // 그룹 A (다이아// 그룹 B (철)
//};

        Solution solution = new Solution();
        int result = solution.solution(pick, minerals);
        System.out.println(result);
    }
}

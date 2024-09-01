package step_stack.programmers;

import java.util.ArrayList;
import java.util.LinkedList;

public class StockPrice {

   static class Solution{

       public int[] solution(int[] price) {

           int[] answer = new int[price.length];
           LinkedList<Integer> stockPriceQueue = new LinkedList<>();

           for (int j : price) {
               stockPriceQueue.add(j);
           }

           int index = 0;
           while (!stockPriceQueue.isEmpty()) {
               Integer stand = stockPriceQueue.poll();

               if (stockPriceQueue.isEmpty()) {
                   break;
               }

               for (Integer currentPrice : stockPriceQueue) {
                   if (currentPrice < stand) {
                       answer[index]++;
                       break;
                   } else {
                       answer[index]++;
                   }
               }
               index++;
           }

           return answer;
       }
   }


    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] result = solution.solution(new int[]{1, 2, 3, 2, 3});

        for (int i : result) {
            System.out.println(i);
        }

    }

}

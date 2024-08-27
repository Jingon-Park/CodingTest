package step_hash.programmers;

import java.util.HashMap;
import java.util.Map;

public class Clothes {


    static class Solution{

        public static int solution(String[][] clothes) {

            Map<String, Integer> clothesMap = new HashMap<>();

            int answer = 1;
            for (String[] clothe : clothes) {
                String type = clothe[1];

                Integer number = clothesMap.getOrDefault(type, 0);
                number++;
                clothesMap.put(type, number);
            }

            for (String type : clothesMap.keySet()) {
                Integer integer = clothesMap.get(type);
                answer *= (integer + 1);
            }

            return --answer;
        }

    }
    public static void main(String[] args) {

        String[][] input = new String[][]{{"yellow_hat", "headgear"},
            {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};

        System.out.println(Solution.solution(input));

    }



}

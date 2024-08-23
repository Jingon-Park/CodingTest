package step_greedy.baekjoon;

import java.util.*;

public class num_1744 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int lineNum = sc.nextInt();

        List<Integer> plusList = new ArrayList<>();
        List<Integer> minusList = new ArrayList<>();



        for (int i = 0; i < lineNum; i++) {
            int next = sc.nextInt();
            if (next > 0) {
                plusList.add(next);
            }else{
                minusList.add(next);
            }
        }

        Collections.sort(plusList, Collections.reverseOrder());
        Collections.sort(minusList);

        long sum = 0;
        for (int i = 0; i < plusList.size(); i++) {
            if (i < plusList.size() - 1) {
                if (plusList.get(i) != 1 && plusList.get(i + 1) != 1){
                    sum += plusList.get(i) * plusList.get(i + 1);
                    i++;
                }else{
                    sum += plusList.get(i);
                }
            }else{
                sum += plusList.get(i);
            }
        }
        for (int i = 0; i < minusList.size(); i++) {
            if (i < minusList.size() - 1) {
                sum += minusList.get(i) * minusList.get(i + 1);
                i++;
            }else{
                sum += minusList.get(i);
            }
        }

        System.out.println(sum);

    }
}

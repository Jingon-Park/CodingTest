package step_greedy.baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class num_1758 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        long totalTip = 0;

        List<Integer> numList = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            numList.add(sc.nextInt());
        }

        Collections.sort(numList, Collections.reverseOrder());

        for (int i = 0; i < num; i++) {
            if (numList.get(i) - i <= 0) {
                break;
            }
            totalTip += numList.get(i) - i;
        }

        System.out.println(totalTip);



    }
}

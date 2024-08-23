package step_greedy.baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class num2217 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        List<Integer> loops = new ArrayList<>();

        int max = 0;

        for (int i = 0; i < num; i++) {
            loops.add(sc.nextInt());
        }
        Collections.sort(loops, Collections.reverseOrder());

        for (int i = 0; i < loops.size(); i++) {
            int loop = loops.get(i);
            if (max < loop * (i + 1)) {
                max = loop * (i + 1);
            }
        }

        System.out.println(max);


    }
}

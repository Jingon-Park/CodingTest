package step_greedy;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class num_1715 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        PriorityQueue<Long> queue = new PriorityQueue<>();

        for (int i = 0; i < num; i++) {
            queue.add(sc.nextLong());
        }





        long sum = 0;
        while (queue.size() > 1) {
            long num1 = queue.poll();
            long num2 = queue.poll();

            sum += num1 + num2;
            queue.add(num1 + num2);
        }

        System.out.println(sum);
    }
}

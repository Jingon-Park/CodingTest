package step_greedy.baekjoon;

import java.util.Scanner;

public class num_1292 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int start = sc.nextInt();
        int end = sc.nextInt();

        int sum1 = calculate(start - 1);
        int sum2 = calculate(end);

        System.out.println(sum2 - sum1);

    }

    public static int calculate(int end) {
        int beforeIndex = 0;
        int temp = 1;
        while (beforeIndex + temp < end) {
            beforeIndex +=temp;
            temp++;
        }
        temp--;
        int sum = 0;
        for (int i = 1; i <= temp; i++) {
            sum += i*i;
        }

        sum += (temp + 1) * (end - beforeIndex);
        return sum;

    }
}

package step_greedy.baekjoon;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class num_11399 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int result = 0;
        int number = sc.nextInt();
        int[] inputArr = new int[number];

        for (int i = 0; i < number; i++) {
            inputArr[i] = sc.nextInt();
        }

        Arrays.sort(inputArr);
        System.out.println(calculate(inputArr, 1));

    }

    public static int calculate(int[] arr, int end) {
        int result = 0;
        if (end > arr.length) {
            return 0;
        }
        for (int i = 0; i < end; i++) {
            result += arr[i];
        }
        return result + calculate(arr, ++end);
    }
}

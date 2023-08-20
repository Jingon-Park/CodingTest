package step_greedy;

import java.util.Arrays;
import java.util.Scanner;

public class num_1339 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int lineNum = sc.nextInt();

        int[] alpha = new int[26];

        String[] inputArr = new String[lineNum];

        for (int i = 0; i < lineNum; i++) {
            inputArr[i] = sc.next();
        }

        for (int i = 0; i < lineNum; i++) {
            int temp = (int) Math.pow(10, inputArr[i].length() - 1);

            for (int j = 0; j < inputArr[i].length(); j++) {
                alpha[(int)inputArr[i].charAt(j) - 65] += temp;
                temp /= 10;
            }
        }

        Arrays.sort(alpha);

        int index = 9;
        int result = 0;

        for (int i = alpha.length - 1; i >= 0; i--) {
            if (alpha[i] == 0) {
                break;
            }
            result += alpha[i] * index;
            index--;
        }
        System.out.println(result);

    }
}

package step_greedy;

import java.util.Scanner;

public class num_2839 {

    final static int BAG_5 = 5;
    final static int BAG_3 = 3;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int kiloGram = scanner.nextInt();
        System.out.println(minBagNum(kiloGram));




    }

    public static int minBagNum(int kiloGram) {
        int bag_5Num = 0;
        int minNum = Integer.MAX_VALUE;
        boolean result = false;
        while (true) {
            int tempKiloGram = kiloGram - (BAG_5 * bag_5Num);
            if (tempKiloGram < 0) {
                break;
            }

            if (tempKiloGram % BAG_3 == 0) {
                minNum = Math.min(minNum, bag_5Num + (tempKiloGram / BAG_3));
                result = true;
            }
            bag_5Num++;
        }
        return result ? minNum : -1;
    }

}

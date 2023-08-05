package step_greedy;

import java.util.Scanner;

public class num_4796 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = 1;

        while (true) {

            String input = sc.nextLine();
            if (input.equals("0 0 0")) {
                break;
            }
            String[] strArr = input.split(" ");

            int vacation = Integer.parseInt(strArr[2]);
            int period = Integer.parseInt(strArr[1]);
            int useDay = Integer.parseInt(strArr[0]);

            int useAmount = calculateUseAmount(vacation, period, useDay);
            System.out.println("Case " + i + ": " + useAmount);
            i++;

        }
    }

    public static int calculateUseAmount(int vacation, int period, int useDay) {
        int result = 0;
        result += (vacation / period) * useDay;
        vacation %= period;

        if (vacation > useDay) {
            result += useDay;
        }else{
            result += vacation;
        }

        return result;
    }
}

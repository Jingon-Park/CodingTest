package baekjoon;

import java.util.*;


class num_1436{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int input = sc.nextInt();
        int num = 666;
        int count = 1;

        while(count != input){
            num++;
            String str = Integer.toString(num);

            if(str.contains("666")){
                count++;
            }
        }
        sc.close();
        System.out.println(num);
    }

}
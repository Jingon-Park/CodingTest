package baekjoon;

import java.util.*;
class num_1018{
    static String startB = "BWBWBWBW";
    static String startW = "WBWBWBWB";
    public static void main(String[] args){
        int m, n;
        
        
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();
        int small = m * n;
        String[] input = new String[m];
        sc.nextLine();

        for(int i = 0; i < m; i++){
            input[i] = sc.nextLine().trim();
        }

        for(int j = 0; j < n - 7; j++){
            for(int k = 0; k < m - 7; k++){
                int count = 0;
                for(int x = 0; x < 8; x++){
                    String row = input[k + x].substring(j, j + 8);
                    if(x % 2 == 0){
                        count += compare(startB, row);
                    }else{
                        count += compare(startW, row);
                    }
                }
                if(count < small) small = count;
                
            }
        }

        for(int j = 0; j < n - 7; j++){
            for(int k = 0; k < m - 7; k++){
                int count = 0;
                for(int x = 0; x < 8; x++){
                    String row = input[k + x].substring(j, j + 8);
                    if(x % 2 == 0){
                        count += compare(startW, row);
                    }else{
                        count += compare(startB, row);
                    }
                }
                if(count < small) small = count;
                
            }
        }
        System.out.println(small);

    }

    public static int compare(String a, String b){
        int count = 0;
        for(int i = 0; i < 8; i++){
            if(a.charAt(i) != b.charAt(i)) count++;
        }
        return count;
    }

}
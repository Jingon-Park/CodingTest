package baekjoon;

import java.util.*;


public class num_2750 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = sc.nextInt();
        int[] input = new int[count];

        for(int i = 0; i < count; i++){
            input[i] = sc.nextInt();
        }

        quick(input, 0, input.length - 1);

        for(int i = 0; i < input.length; i++){
            System.out.println(input[i]);
        }

        sc.close();

    }
    
    public static void quick(int[] arr, int l, int r){
        if(r > l){
            int p = pivot(arr, l, r);

            quick(arr, l, p - 1);
            quick(arr, p + 1, r);
        }
    }

    public static int pivot(int[] arr, int l, int r){
        int pivot = arr[r];
        int i = (l - 1);

        for(int j = l; j <= r - 1; j++){
            if(arr[j] <= pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp; 
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[r];
        arr[r] = temp;
        
        return i + 1;
    }
}

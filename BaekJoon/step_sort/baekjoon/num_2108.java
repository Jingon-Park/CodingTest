package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class num_2108 {

    public static void main(String[] args) throws Exception {
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bf.readLine());
        int[] counter = new int[8001];

        ArrayList<Integer> input = new ArrayList<>();
        
        for(int i = 0; i < num; i++){
            input.add(Integer.parseInt(bf.readLine()));
        }

        for(int number : input){
            counter[number + 4000]++;
        }
        System.out.println(mean(counter, num));
        System.out.println(middle(counter, num));
        System.out.println(mode(counter));
        System.out.println(range(counter));

    }

    public static long mean(int[] sorted, int num){
        int result = 0;

        for(int i = 0; i < sorted.length; i++){
            result += ((i - 4000) * sorted[i]);
        }
        return Math.round(result / (double) num);
        
    }

    public static int middle(int[] sorted, int num){
        int result = 0;
        int counter = 0;
        int index = -1;
        while(counter < (num / 2) + 1){
            index++;
            counter += sorted[index];
        }
        result = index - 4000;
        return result;
    }

    public static int mode(int[] sorted){
        int result = 0;
        int max = 0;
        ArrayList<Integer> maxIndex = new ArrayList<>();
        for(int i = 0; i < sorted.length; i++){
            if(max < sorted[i]){
                max = sorted[i];
            }
        }

        for(int i = 0; i < sorted.length; i++){
            if(sorted[i] == max){
                maxIndex.add(i - 4000);
            }
        }
        if(maxIndex.size() > 1){
            result = maxIndex.get(1);
        }else{
            result = maxIndex.get(0);
        }

        return result;
    }

    public static int range(int[] sorted){
        int min = 0;
        int max = 0;

        for(int i = 0; i < sorted.length; i++){
            if(sorted[i] != 0){
                min = i - 4000;
                break;
            }
        }

        for(int i = sorted.length - 1; i >= 0; i--){
            if(sorted[i] != 0){
                max = i - 4000;
                break;
            }
        }
        return max - min;
    }
}

package Step_1_Array;

import java.util.Scanner;

public class num_4344 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int input = sc.nextInt();
		
		for(int i = 0; i < input; i++) {
			int count = 0;
			int number = sc.nextInt();
			int[] arr = new int[number];
			int sum = 0;
			for(int j = 0; j < number; j++) {
				arr[j] = sc.nextInt();
				sum += arr[j];
			}
			double avg = sum / number;
			
			for(int k = 0; k < number; k++) {
				if(arr[k] > avg)
					count++;
			}
			System.out.printf("%.3f" + "%%\n", ((double)count / (double)number)*100);
		}
	}

}

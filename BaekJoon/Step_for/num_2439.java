package Step_for;

import java.util.Scanner;

public class num_2439 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int input = sc.nextInt();
		
		for(int i = input; i > 0;i--) {
			for(int j = 0; j < input; j++) {
				if(j < i - 1) {
					System.out.print(" ");
				}else
					System.out.print("*");
			}
			System.out.println();
		}
	}

}

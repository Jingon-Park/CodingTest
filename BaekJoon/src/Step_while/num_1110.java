package Step_while;

import java.util.Scanner;

public class num_1110 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int input = sc.nextInt();
		int copy = input;
		int counter = 0;
		
		do {
			counter++;
			copy = ((copy % 10)*10) + (((copy / 10) + (copy % 10)) % 10);
		}while(copy != input);
		System.out.println(counter);
		
			
	}

}

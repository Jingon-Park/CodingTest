package Step_String;

import java.util.Scanner;

public class num_11720 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		String num = sc.next();
		int sum = 0;
		
		for(int i = 0; i < input; i++) {
			char plus = num.charAt(i);
			sum += plus - 48;
		}
		System.out.println(sum);
		sc.close();
	}

}

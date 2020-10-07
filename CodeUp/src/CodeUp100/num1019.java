package CodeUp100;

import java.util.Scanner;

public class num1019 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String in = sc.next();
		String[] sp = in.split("\\."); //자바에서 . << 은 예약어 이므로 \\. 으로 
		int year = Integer.parseInt(sp[0]);
		int month = Integer.parseInt(sp[1]);
		int day = Integer.parseInt(sp[2]);
		
		System.out.format("%04d.%02d.%02d",year,month,day);  //"%0xd"  x자리까지 채워서 출력
				
		sc.close();
	}

}

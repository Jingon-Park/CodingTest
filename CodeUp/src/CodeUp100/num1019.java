package CodeUp100;

import java.util.Scanner;

public class num1019 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String in = sc.next();
		String[] sp = in.split("\\."); //�ڹٿ��� . << �� ����� �̹Ƿ� \\. ���� 
		int year = Integer.parseInt(sp[0]);
		int month = Integer.parseInt(sp[1]);
		int day = Integer.parseInt(sp[2]);
		
		System.out.format("%04d.%02d.%02d",year,month,day);  //"%0xd"  x�ڸ����� ä���� ���
				
		sc.close();
	}

}

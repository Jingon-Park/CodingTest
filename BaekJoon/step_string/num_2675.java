package step_string;

import java.util.Scanner;

public class num_2675 {
	//���۸� �̿��� Ǯ�̵� �����ϴ� << �ӵ��� �� ����
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		for(int i = 0; i < num; i++) {
			int mutiple = sc.nextInt();
			String text = sc.next();
			for(int j = 0; j < text.length(); j++) {
				for(int k = 0 ;k < mutiple; k++){
					System.out.print(text.charAt(j));
				}
			}
			System.out.println();
		}

	}

}

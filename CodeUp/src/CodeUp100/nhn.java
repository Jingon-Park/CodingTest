package CodeUp100;

import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;
import java.util.List;
class Position{
		int row;
		int col;
		public Position(int row, int col){
			this.row = row;
			this.col = col;
		}
	}
class nhn {
	
  private static void solution(int sizeOfMatrix, int[][] matrix) {
    // TODO: �̰��� �ڵ带 �ۼ��ϼ���.
	  	System.out.println("����");
		Stack<Position> stack = new Stack<>();
		int[][] copy = matrix;
		ArrayList<Integer> numbers = new ArrayList<>();
		int counter = 0;
		for(int i = 0; i < sizeOfMatrix; i++){
			for(int j = 0; j < sizeOfMatrix; j++){
				if(copy[i][j] == 1){
					System.out.printf("1 �߰�\n");
					stack.push(new Position(i, j));
					System.out.println(stack.peek().row + " " + stack.peek().col);
					while(!stack.isEmpty()){
						Position top = stack.pop();
						copy[i][j] = 0;
						if(top.col - 1 > 0){
							System.out.println("���� �˻�");
							if(copy[top.row][top.col - 1] == 1){
								System.out.println("���� 1");
								counter++;
								stack.push(new Position(top.row, (top.col - 1)));
							}
						}
						if(top.col + 1 < sizeOfMatrix){
							System.out.println("������ �˻�");
							if(copy[top.row][top.col + 1] == 1){
								System.out.println("������ 1");
								counter++;
								stack.push(new Position(top.row, (top.col + 1)));
							}
						}
						if(top.row - 1 > 0){
							System.out.println("���� �˻�");
							if(copy[top.row - 1][top.col] == 1){
								System.out.println("���� 1");
								counter++;
								stack.push(new Position((top.row - 1), top.col));
							}
						}
						if(top.row + 1 < sizeOfMatrix){
							System.out.println("�Ʒ��˻�");
							if(copy[top.row + 1][top.col] == 1){
								System.out.println("�Ʒ�1");
								counter++;
								stack.push(new Position((top.row - 1), top.col));
							}
						}
						System.out.println("��");
					}
					System.out.println("��Ʈ��");
					numbers.add(counter);
					counter = 0;
				}else
					System.out.println("1�ƴ�");
			}
		}
		//System.out.println(numbers.size());
		
		
  }
  
  private static class InputData {
    int sizeOfMatrix;
    int[][] matrix;
  }

  private static InputData processStdin() {
    InputData inputData = new InputData();

    try (Scanner scanner = new Scanner(System.in)) {
      inputData.sizeOfMatrix = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));      
      
      inputData.matrix = new int[inputData.sizeOfMatrix][inputData.sizeOfMatrix];
      for (int i = 0; i < inputData.sizeOfMatrix; i++) {
        String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
        for (int j = 0; j < inputData.sizeOfMatrix; j++) {
          inputData.matrix[i][j] = Integer.parseInt(buf[j]);
        }
      }
    } catch (Exception e) {
      throw e;
    }

    return inputData;
  }

  public static void main(String[] args) throws Exception {
    InputData inputData = processStdin();

    solution(inputData.sizeOfMatrix, inputData.matrix);
  }
}
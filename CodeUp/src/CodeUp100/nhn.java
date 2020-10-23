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
    // TODO: 이곳에 코드를 작성하세요.
	  	System.out.println("시작");
		Stack<Position> stack = new Stack<>();
		int[][] copy = matrix;
		ArrayList<Integer> numbers = new ArrayList<>();
		int counter = 0;
		for(int i = 0; i < sizeOfMatrix; i++){
			for(int j = 0; j < sizeOfMatrix; j++){
				if(copy[i][j] == 1){
					System.out.printf("1 발견\n");
					stack.push(new Position(i, j));
					System.out.println(stack.peek().row + " " + stack.peek().col);
					while(!stack.isEmpty()){
						Position top = stack.pop();
						copy[i][j] = 0;
						if(top.col - 1 > 0){
							System.out.println("왼쪽 검사");
							if(copy[top.row][top.col - 1] == 1){
								System.out.println("왼쪽 1");
								counter++;
								stack.push(new Position(top.row, (top.col - 1)));
							}
						}
						if(top.col + 1 < sizeOfMatrix){
							System.out.println("오른쪽 검사");
							if(copy[top.row][top.col + 1] == 1){
								System.out.println("오른쪽 1");
								counter++;
								stack.push(new Position(top.row, (top.col + 1)));
							}
						}
						if(top.row - 1 > 0){
							System.out.println("위쪽 검사");
							if(copy[top.row - 1][top.col] == 1){
								System.out.println("위쪽 1");
								counter++;
								stack.push(new Position((top.row - 1), top.col));
							}
						}
						if(top.row + 1 < sizeOfMatrix){
							System.out.println("아래검사");
							if(copy[top.row + 1][top.col] == 1){
								System.out.println("아래1");
								counter++;
								stack.push(new Position((top.row - 1), top.col));
							}
						}
						System.out.println("끝");
					}
					System.out.println("세트끝");
					numbers.add(counter);
					counter = 0;
				}else
					System.out.println("1아님");
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
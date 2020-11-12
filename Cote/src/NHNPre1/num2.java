package NHNPre1;

import java.util.Scanner;

class num2 {
  private static void solution(int day, int width, int[][] blocks) {
	  int leftHigh, rightHigh;
	  int leftIndex, rightIndex;
	  int total = 0;
	  int[] dayBlocks = new int[width];
		
		
	  for(int i = 0; i < day; i++){
		  for(int j = 0; j < width; j++){ //일별 벽돌 쌓기
				dayBlocks[j] += blocks[i][j];
				System.out.print(dayBlocks[j] + " ");
			}
		  for(int k = 1; k <= width - 2; k++) {
			  if(dayBlocks[k] < dayBlocks[k - 1]) {
				  leftHigh = dayBlocks[k - 1];
				  leftIndex = k - 1;
			  }
			  if(dayBlocks[k] < dayBlocks[k + 1]) {
				  leftHigh = dayBlocks[k + 1];
				  leftIndex = k + 1;
			  }
		  }
	  }
		
		
  }
  
  private static class InputData {
    int day;
    int width;
    int[][] blocks;
  }

  private static InputData processStdin() {
    InputData inputData = new InputData();

    try (Scanner scanner = new Scanner(System.in)) {
      inputData.day = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));      
      inputData.width = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
      
      inputData.blocks = new int[inputData.day][inputData.width];
      for (int i = 0; i < inputData.day; i++) {
        String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
        for (int j = 0; j < inputData.width; j++) {
          inputData.blocks[i][j] = Integer.parseInt(buf[j]);
        }
      }
    } catch (Exception e) {
      throw e;
    }

    return inputData;
  }

  public static void main(String[] args) throws Exception {
    InputData inputData = processStdin();

    solution(inputData.day, inputData.width, inputData.blocks);
  }
}
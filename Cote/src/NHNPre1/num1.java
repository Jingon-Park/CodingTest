package NHNPre1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class num1 {
  private static void solution(int numOfAllPlayers, int numOfQuickPlayers, char[] namesOfQuickPlayers, int numOfGames, int[] numOfMovesPerGame){
    // TODO: �̰��� �ڵ带 �ۼ��ϼ���. �߰��� �ʿ��� �Լ��� ���������� �����ؼ� ����ϼŵ� �˴ϴ�.
	int set = 0; char how = 'A';
	int[] counter = new int[numOfAllPlayers];
	char A = 'A';
	ArrayList<Character> members = new ArrayList<>();
	counter[0] = 1;
	
	
	for(int i = 0 ; i < numOfAllPlayers - 1; i++) {
		members.add(++A);
		System.out.println(A);
	}
	
	for(int j = 0; j < numOfGames; j++) {
		if(set + numOfMovesPerGame[j] >= 0 && set + numOfMovesPerGame[j] <= numOfAllPlayers - 1) {
			set = set + numOfMovesPerGame[j];
			if(!Arrays.asList(namesOfQuickPlayers).contains(members.get(set + numOfMovesPerGame[j]))) {
				counter[set]++;
				char tmp = members.get(j);
				members.set(j, how);
				how = tmp;
				counter[how - 65]++;
			}else {
				counter[how - 65]++;
			}
		}else if(set + numOfMovesPerGame[j] < 0) {
			set = numOfAllPlayers + (set + numOfMovesPerGame[j]);
			if(!Arrays.asList(namesOfQuickPlayers).contains(members.get(set + numOfMovesPerGame[j]))) {
				counter[set]++;
				char tmp = members.get(j);
				members.set(j, how);
				how = tmp;
				counter[how - 65]++;
			}else {
				counter[how - 65]++;
			}
		}else {
			
		}
	}
	
	
  }

  private static class InputData {
    int numOfAllPlayers;
    int numOfQuickPlayers;
    char[] namesOfQuickPlayers;
    int numOfGames;
    int[] numOfMovesPerGame;
  }

  private static InputData processStdin() {
    InputData inputData = new InputData();

    try (Scanner scanner = new Scanner(System.in)) {
      inputData.numOfAllPlayers = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

      inputData.numOfQuickPlayers = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
      inputData.namesOfQuickPlayers = new char[inputData.numOfQuickPlayers];
      System.arraycopy(scanner.nextLine().trim().replaceAll("\\s+", "").toCharArray(), 0, inputData.namesOfQuickPlayers, 0, inputData.numOfQuickPlayers);

      inputData.numOfGames = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
      inputData.numOfMovesPerGame = new int[inputData.numOfGames];
      String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
      for(int i = 0; i < inputData.numOfGames ; i++){
        inputData.numOfMovesPerGame[i] = Integer.parseInt(buf[i]);
      }
    } catch (Exception e) {
      throw e;
    }

    return inputData;
  }

  public static void main(String[] args) throws Exception {
    InputData inputData = processStdin();

    solution(inputData.numOfAllPlayers, inputData.numOfQuickPlayers, inputData.namesOfQuickPlayers, inputData.numOfGames, inputData.numOfMovesPerGame);
  }
}
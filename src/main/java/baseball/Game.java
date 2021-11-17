package baseball;

import java.util.Scanner;

public class Game {
	public static void playGame(Scanner scanner){
		String playerNum = getPlayerNumber(scanner);
	}

	public static String getPlayerNumber(Scanner scanner){
		boolean flag = true;
		String playerNum = new String();
		while(flag){
			System.out.print("숫자를 입력해주세요 : ");
			String inputData = scanner.nextLine();
			if ((checkNumber(inputData) == true) && (checkLength(inputData) == true) && (checkDuplicateNumber(inputData) == true)){
				playerNum = inputData;
				flag = false;
			}
		}
		return playerNum;
	}

}

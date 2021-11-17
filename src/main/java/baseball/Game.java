package baseball;

import java.util.Scanner;
import utils.RandomUtils;

public class Game {
	public static void playGame(Scanner scanner){
		String randomNum = getRandomNumber();
		// test
		System.out.println(randomNum);
		boolean flag = true;
		while(true){
			String playerNum = getPlayerNumber(scanner);
			matchNumbers(randomNum,playerNum);
		}
	}

	public static String getRandomNumber(){
		String randomNum = new String();
		boolean flag = true;
		while(flag){
			randomNum = "";
			for (int i=0; i < 3; i++){
				int number = utils.RandomUtils.nextInt(1,9);
				randomNum += Integer.toString(number);
			}
			if (checkRandomNumer(randomNum)){
				flag = false;
			}
		}
		return randomNum;
	}

	public static boolean checkRandomNumer(String randomNum){
		if((randomNum.charAt(0) == randomNum.charAt(1)) || (randomNum.charAt(1) == randomNum.charAt(2)) || (randomNum.charAt(0) == randomNum.charAt(2))){
			return false;
		}
		return true;
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

	public static boolean checkNumber(String inputData){
		for(int i=0; i < inputData.length(); i++){
			int askiiNum = (int)inputData.charAt(i);
			if((askiiNum < 49) || (askiiNum > 57)){
				System.out.println("[ERROR] 입력한 숫자는 1에서 9 범위 내에서 입력해야 합니다.");
				return false;
			}
		}
		return true;
	}

	public static boolean checkLength(String inputData){
		int inputDataLength = (int)inputData.length();
		if (inputDataLength == 3){
			return true;
		}
		System.out.println("[ERROR] 입력한 숫자의 개수는 3개여야 합니다.");
		return false;
	}

	public static boolean checkDuplicateNumber(String inputData){
		if((inputData.charAt(0) == inputData.charAt(1)) || (inputData.charAt(1) == inputData.charAt(2)) || (inputData.charAt(0) == inputData.charAt(2))){
			System.out.println("[ERROR] 입력한 숫자는 서로 중복되지 않아야 합니다.");
			return false;
		}
		return true;
	}

	public static void matchNumbers(String randomNum, String playerNum){
		int strike = 0;
		int ball = 0;
		for (int i=0; i < 3; i++){
			char ch = randomNum.charAt(i);
			if (ch == playerNum.charAt(i)){
				++strike;
			}
			else if (randomNum.contains(ch)){
				++ball;
			}
		}

		// test
		System.out.println("strike: " + strike);
		System.out.println("ball: " + ball);
	}


}

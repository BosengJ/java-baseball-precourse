package baseball;

import java.util.Arrays;
import java.util.Scanner;
import utils.RandomUtils;

public class Game {
	public static void playGame(Scanner scanner){
		boolean flag = true;
		while(flag){
			String randomNum = getRandomNumber();
			// test
			System.out.println(randomNum);
			String playerNum = getPlayerNumber(scanner);
			int[] strikeBall = matchNumbers(randomNum,playerNum);
			printGameResult(strikeBall);
			int strike = strikeBall[0];
			if (strike == 3){
				flag = askReplayOrStop(scanner);
			}
			//test
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

	public static int[] matchNumbers(String randomNum, String playerNum){
		int strike = 0;
		int ball = 0;
		for (int i=0; i < 3; i++){
			char randomCh = randomNum.charAt(i);
			char playerCh = playerNum.charAt(i);
			if (randomCh == playerCh){
				++strike;
			}
			else if (checkBall(randomNum,playerCh)){
				++ball;
			}
		}
		int[] strikeBall = {strike, ball};
		return strikeBall;
	}

	public static boolean checkBall(String randomNum, char playerCh){
		for (int i=0; i < 3; i++){
			if (randomNum.charAt(i) == playerCh){
				return true;
			}
		}
		return false;
	}

	public static void printGameResult(int[] strikeBall){
		int strike = strikeBall[0]; int ball = strikeBall[1];
		if (ball > 0){
			System.out.print(ball + "볼 ");
		}
		if (strike > 0){
			System.out.println(strike + "스트라이크");
		}
		if ((ball == 0) && (strike == 0)){
			System.out.println("낫싱");
		}
	}

	public static boolean askReplayOrStop(Scanner scanner){
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
		int playStop;
		while(true){
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
			String inputData = scanner.nextLine();
			playStop = Integer.parseInt(inputData);
			if(playStop == 1 || playStop == 2){
				break;
			}
			System.out.println("[ERROR] 1 또는 2만 입력 가능합니다.");
		}
		if (playStop == 1){
			return true;
		}
		return false;
	}
}

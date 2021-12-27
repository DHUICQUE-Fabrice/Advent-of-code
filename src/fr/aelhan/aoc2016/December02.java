package fr.aelhan.aoc2016;

import fr.aelhan.tools.GeneralTools;
import fr.aelhan.tools.MathTools;
import fr.aelhan.tools.ReadFile;

public class December02 {
	ReadFile fileReader = new ReadFile();
	MathTools mathTools = new MathTools();
	GeneralTools generalTools = new GeneralTools();

	public void format(String input) {
		String[][] formatted = fileReader.toStringArray2D(input, "\r\n", "");
		solvePart1(formatted);
		solvePart2(formatted);
	}

	public void solvePart1(String[][] input) {
		String answer = new String();
		int[][] keyboard = new int[3][3];
		int value = 0;
		for (int i = 0; i < keyboard.length; i++) {
			for (int j = 0; j < keyboard[0].length; j++) {
				value++;
				keyboard[j][i] = value;
			}
		}
		int posX = 1;
		int posY = 1;
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[i].length; j++) {
				int moveX = 0;
				int moveY = 0;
				switch (input[i][j]) {
				case "U":
					moveY--;
					break;
				case "D":
					moveY++;
					break;
				case "L":
					moveX--;
					break;
				case "R":
					moveX++;
					break;
				default:
					break;
				}
				posX += moveX;
				posY += moveY;
				if (posX < 0 || posX >= 3 || posY < 0 || posY >= 3) {
					posX -= moveX;
					posY -= moveY;
				}
			}
			answer += keyboard[posX][posY];
		}
		System.out.println("Part 1 response : " + answer);
	}

	public void solvePart2(String[][] input) {
		String answer = new String();
		String[][] keyboard = new String[5][5];
		keyboard[2][0] = "1";
		keyboard[1][1] = "2";
		keyboard[2][1] = "3";
		keyboard[3][1] = "4";
		keyboard[0][2] = "5";
		keyboard[1][2] = "6";
		keyboard[2][2] = "7";
		keyboard[3][2] = "8";
		keyboard[4][2] = "9";
		keyboard[1][3] = "A";
		keyboard[2][3] = "B";
		keyboard[3][3] = "C";
		keyboard[2][4] = "D";

		int posX = 0;
		int posY = 2;
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[i].length; j++) {
				int moveX = 0;
				int moveY = 0;
				switch (input[i][j]) {
				case "U":
					moveY--;
					break;
				case "D":
					moveY++;
					break;
				case "L":
					moveX--;
					break;
				case "R":
					moveX++;
					break;
				default:
					break;
				}
				posX += moveX;
				posY += moveY;
				if (posX < 0 || posY < 0 || posX > 4 || posY > 4 || keyboard[posX][posY] == null) {
					posX -= moveX;
					posY -= moveY;
				}
			}
			answer += keyboard[posX][posY];
		}
		System.out.println("Part 2 response : " + answer);
	}

}
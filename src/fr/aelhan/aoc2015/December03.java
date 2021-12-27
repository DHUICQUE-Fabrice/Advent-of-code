package fr.aelhan.aoc2015;

import fr.aelhan.tools.GeneralTools;
import fr.aelhan.tools.MathTools;
import fr.aelhan.tools.ReadFile;

public class December03 {

	ReadFile fileReader = new ReadFile();
	MathTools mathTools = new MathTools();
	GeneralTools generalTools = new GeneralTools();

	public void format(String input) {
		String formatted = input;
		solvePart1(formatted);
		solvePart2(formatted);
	}

	public void solvePart1(String input) {
		int[][] map = new int[160][160];
		int startRow = map.length / 2;
		int startCol = map[0].length / 2;
		map[startRow][startCol]++;
		for (int i = 0; i < input.length(); i++) {
			switch (input.substring(i, i + 1)) {
			case "<":
				startCol--;
				break;
			case ">":
				startCol++;
				break;
			case "v":
				startRow++;
				break;
			case "^":
				startRow--;
				break;
			default:
				break;
			}
			map[startRow][startCol]++;
		}
		int houses = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] != 0) {
					houses++;
				}
			}
		}

		System.out.println("Part 1 response : " + houses);
	}

	public void solvePart2(String input) {
		int[][] map = new int[160][160];
		int startRow = map.length / 2;
		int startCol = map[0].length / 2;
		map[startRow][startCol]++;
		for (int i = 0; i < input.length(); i += 2) {
			switch (input.substring(i, i + 1)) {
			case "<":
				startCol--;
				break;
			case ">":
				startCol++;
				break;
			case "v":
				startRow++;
				break;
			case "^":
				startRow--;
				break;
			default:
				break;
			}
			map[startRow][startCol]++;
		}
		startRow = map.length / 2;
		startCol = map[0].length / 2;
		map[startRow][startCol]++;
		for (int i = 1; i < input.length(); i += 2) {
			switch (input.substring(i, i + 1)) {
			case "<":
				startCol--;
				break;
			case ">":
				startCol++;
				break;
			case "v":
				startRow++;
				break;
			case "^":
				startRow--;
				break;
			default:
				break;
			}
			map[startRow][startCol]++;
		}
		int houses = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] != 0) {
					houses++;
				}
			}
		}
		System.out.println("Part 2 response : " + houses);
	}
}
package fr.aelhan.aoc2017;

import fr.aelhan.tools.GeneralTools;
import fr.aelhan.tools.MathTools;
import fr.aelhan.tools.ReadFile;

public class December04 {
	ReadFile fileReader = new ReadFile();
	MathTools mathTools = new MathTools();
	GeneralTools generalTools = new GeneralTools();

	public void format(String input) {
		String[][] formatted = fileReader.toStringArray2D(input, "\r\n", " ");
		solvePart1(formatted);
		solvePart2(formatted);
	}

	public void solvePart1(String[][] input) {
		int answer = 0;
		for (int i = 0; i < input.length; i++) {
			boolean correct = true;
			for (int j = 0; j < input[i].length - 1; j++) {
				for (int j2 = j + 1; j2 < input[i].length; j2++) {
					if (input[i][j].equals(input[i][j2])) {
						correct = false;
					}
				}
			}
			if (correct) {
				answer++;
			}
		}
		System.out.println("Part 1 response : " + answer);
	}

	public void solvePart2(String[][] input) {
		int answer = 0;
		for (int i = 0; i < input.length; i++) {
			boolean correct = true;
			for (int j = 0; j < input[i].length - 1; j++) {
				for (int j2 = j + 1; j2 < input[i].length; j2++) {
					if (input[i][j].equals(input[i][j2])) {
						correct = false;
					} else {
						if (areAnagram(input[i][j], input[i][j2])) {
							correct = false;
						}
					}
				}
			}
			if (correct) {
				answer++;
			}
		}
		System.out.println("Part 2 response : " + answer);
	}

	private boolean areAnagram(String first, String second) {
		if (first.length() == second.length()) {
			for (int i = 0; i < first.length(); i++) {
				if (second.indexOf(first.substring(i, i + 1)) >= 0) {
					second = second.substring(0, second.indexOf(first.substring(i, i + 1)))
							+ second.substring(second.indexOf(first.substring(i, i + 1)) + 1);
				} else {
					return false;
				}
			}
		} else {
			return false;
		}
		return true;
	}

}
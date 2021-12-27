package fr.aelhan.aoc2015;

import fr.aelhan.tools.GeneralTools;
import fr.aelhan.tools.MathTools;
import fr.aelhan.tools.ReadFile;

public class December05 {

	ReadFile fileReader = new ReadFile();
	MathTools mathTools = new MathTools();
	GeneralTools generalTools = new GeneralTools();

	public void format(String input) {

		String[] formatted = fileReader.toStringArray1D(input, "\r\n");

		solvePart1(formatted);
		solvePart2(formatted);
	}

	public void solvePart1(String[] input) {

		int nices = 0;
		for (int i = 0; i < input.length; i++) {
			if (checkVowels(input[i], 3)) {
				if (checkDouble(input[i])) {
					if (checkForbidden(input[i])) {
						nices++;
					}
				}
			}
		}

		System.out.println("Part 1 response : " + nices);
	}

	private boolean checkForbidden(String input) {
		for (int i = 0; i < input.length() - 1; i++) {
			switch (input.substring(i, i + 2)) {
			case "ab":
			case "cd":
			case "pq":
			case "xy":
				return false;
			default:
				break;
			}
		}
		return true;
	}

	private boolean checkDouble(String string) {
		for (int i = 0; i < string.length() - 1; i++) {
			if (string.substring(i, i + 1).equals(string.substring(i + 1, i + 2))) {
				return true;
			}
		}
		return false;
	}

	public void solvePart2(String[] input) {
		int nices = 0;
		for (int i = 0; i < input.length; i++) {
			String toCheck = input[i];
			if (checkDoubleCouples(toCheck) && checkInterleaves(toCheck)) {
				nices++;
			}

		}
		System.out.println("Part 2 response : " + nices);
	}

	private boolean checkInterleaves(String toCheck) {
		for (int i = 0; i < toCheck.length() - 2; i++) {
			if (toCheck.substring(i, i + 1).equals(toCheck.substring(i + 2, i + 3))) {
				return true;
			}
		}
		return false;
	}

	private boolean checkDoubleCouples(String toCheck) {
		for (int i = 0; i < toCheck.length() - 3; i++) {
			for (int j = i + 2; j < toCheck.length() - 1; j++) {
				if (toCheck.substring(i, i + 2).equals(toCheck.substring(j, j + 2))) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean checkVowels(String input, int qty) {
		int vowels = 0;
		boolean nice = false;
		for (int i = 0; i < input.length(); i++) {
			switch (input.substring(i, i + 1)) {
			case "a":
			case "e":
			case "i":
			case "o":
			case "u":
				vowels++;
				break;
			default:
				break;
			}
		}
		if (vowels >= qty) {
			nice = true;
		}
		return nice;
	}

}
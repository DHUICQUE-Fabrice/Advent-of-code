package fr.aelhan.aoc2018;

import fr.aelhan.tools.GeneralTools;
import fr.aelhan.tools.MathTools;
import fr.aelhan.tools.ReadFile;

public class December02 {
	ReadFile fileReader = new ReadFile();
	MathTools mathTools = new MathTools();
	GeneralTools generalTools = new GeneralTools();

	public void format(String input) {
		String[] formatted = fileReader.toStringArray1D(input, "\r\n");
		solvePart1(formatted);
		solvePart2(formatted);
	}

	public void solvePart1(String[] input) {
		int twice = 0;
		int threeTimes = 0;
		for (int i = 0; i < input.length; i++) {
			int times = 0;
			boolean isTwice = false;
			boolean is3Times = false;
			for (int j = 0; j < input[i].length(); j++) {
				for (int j2 = 0; j2 < input[i].length(); j2++) {
					if (input[i].substring(j, j + 1).equals(input[i].substring(j2, j2 + 1))) {
						times++;
					}
				}
				if (times == 2) {
					isTwice = true;
				}
				if (times == 3) {
					is3Times = true;
				}
				times = 0;
			}
			if (isTwice) {
				twice++;
			}
			if (is3Times) {
				threeTimes++;
			}
			is3Times = false;
			isTwice = false;

		}
		System.out.println("Part 1 response : " + (twice * threeTimes));
	}

	public void solvePart2(String[] input) {
		String answer = new String();
		for (int i = 0; i < input.length - 1; i++) {
			for (int j = i + 1; j < input.length; j++) {
				answer = compare(input[i], input[j]);
				if (!answer.equals("")) {
					break;
				}
			}
			if (!answer.equals("")) {
				break;
			}
		}

		System.out.println("Part 2 response : " + answer);
	}

	private String compare(String string, String string2) {
		int diff = 0;
		int index = 0;
		for (int i = 0; i < string.length(); i++) {
			if (!string.substring(i, i + 1).equals(string2.substring(i, i + 1))) {
				diff++;
				index = i;
			}
		}
		if (diff == 1) {
			return string.substring(0, index) + string.substring(index + 1);
		}

		return "";
	}

}
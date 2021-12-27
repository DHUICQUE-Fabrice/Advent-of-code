package fr.aelhan.aoc2017;

import fr.aelhan.tools.GeneralTools;
import fr.aelhan.tools.MathTools;
import fr.aelhan.tools.ReadFile;

public class December01 {
	ReadFile fileReader = new ReadFile();
	MathTools mathTools = new MathTools();
	GeneralTools generalTools = new GeneralTools();

	public void format(String input) {
		int[] formatted = fileReader.toIntArray1D(input, "");
		solvePart1(formatted);
		solvePart2(formatted);
	}

	public void solvePart1(int[] input) {
		int answer = 0;
		for (int i = 0; i < input.length - 1; i++) {
			if (input[i] == input[i + 1]) {
				answer += input[i];
			}
		}
		if (input[0] == input[input.length - 1]) {
			answer += input[0];
		}
		System.out.println("Part 1 response : " + answer);
	}

	public void solvePart2(int[] input) {
		int answer = 0;
		for (int i = 0; i < input.length; i++) {
			try {
				if (input[i] == input[input.length / 2 + i]) {
					answer += input[i];
				}
			} catch (Exception e) {
				if (input[i] == input[i - input.length / 2]) {
					answer += input[i];
				}
			}
		}
		System.out.println("Part 2 response : " + answer);
	}

}
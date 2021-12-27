package fr.aelhan.aoc2015;

import fr.aelhan.tools.GeneralTools;
import fr.aelhan.tools.MathTools;
import fr.aelhan.tools.ReadFile;

public class December02 {

	ReadFile fileReader = new ReadFile();
	MathTools mathTools = new MathTools();
	GeneralTools generalTools = new GeneralTools();

	public void format(String input) {
		int[][] formatted = fileReader.toIntArray2D(input, "\r\n", "x");
		solvePart1(formatted);
		solvePart2(formatted);
	}

	public void solvePart1(int[][] input) {
		int totalSquareFeet = 0;
		for (int i = 0; i < input.length; i++) {
			int first = input[i][0] * input[i][1];
			int second = input[i][0] * input[i][2];
			int third = input[i][1] * input[i][2];
			int extra = mathTools.min(first, second, third);
			totalSquareFeet += 2 * first + 2 * second + 2 * third + extra;
		}
		System.out.println("Part 1 response : " + totalSquareFeet);
	}

	public void solvePart2(int[][] input) {
		int totalRibbon = 0;
		for (int i = 0; i < input.length; i++) {
			int a = input[i][0];
			int b = input[i][1];
			int c = input[i][2];
			int volume = a * b * c;
			int max = mathTools.max(a, b, c);
			int extra = 0;
			if (max == a) {
				extra = 2 * (b + c);
			} else if (max == b) {
				extra = 2 * (a + c);
			} else if (max == c) {
				extra = 2 * (b + a);
			}
			totalRibbon += volume + extra;
		}
		System.out.println("Part 2 response : " + totalRibbon);
	}
}
package fr.aelhan.aoc2017;

import fr.aelhan.tools.GeneralTools;
import fr.aelhan.tools.MathTools;
import fr.aelhan.tools.ReadFile;

public class December02 {
	ReadFile fileReader = new ReadFile();
	MathTools mathTools = new MathTools();
	GeneralTools generalTools = new GeneralTools();

	public void format(String input) {
		int[][] formatted = fileReader.toIntArray2D(input, "\r\n", "	");
		solvePart1(formatted);
		solvePart2(formatted);
	}

	public void solvePart1(int[][] input) {
		int answer = 0;
		for (int i = 0; i < input.length; i++) {
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < input[i].length; j++) {
				if (input[i][j] > max) {
					max = input[i][j];
				}
				if (input[i][j] < min) {
					min = input[i][j];
				}
			}
			answer += max - min;
		}
		System.out.println("Part 1 response : " + answer);
	}

	public void solvePart2(int[][] input) {
		int answer = 0;
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[i].length - 1; j++) {
				int toCheck1 = input[i][j];
				for (int k = j + 1; k < input.length; k++) {
					int toCheck2 = input[i][k];
					if (toCheck1 % toCheck2 == 0) {
						answer += toCheck1 / toCheck2;
						break;
					}
					if (toCheck2 % toCheck1 == 0) {
						answer += toCheck2 / toCheck1;
						break;
					}
				}
			}
		}
		System.out.println("Part 2 response : " + answer);
	}

}

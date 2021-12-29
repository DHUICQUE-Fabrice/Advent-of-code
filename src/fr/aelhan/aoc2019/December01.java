package fr.aelhan.aoc2019;

import fr.aelhan.tools.GeneralTools;
import fr.aelhan.tools.MathTools;
import fr.aelhan.tools.ReadFile;

public class December01 {
	ReadFile fileReader = new ReadFile();
	MathTools mathTools = new MathTools();
	GeneralTools generalTools = new GeneralTools();

	public void format(String input) {
		int[] formatted = fileReader.toIntArray1D(input, "\r\n");
		solvePart1(formatted);
		solvePart2(formatted);
	}

	public void solvePart1(int[] input) {
		int totalFuel = 0;
		for (int i = 0; i < input.length; i++) {
			totalFuel += (input[i] / 3) - 2;
		}
		System.out.println("Part 1 response : " + totalFuel);
	}

	public void solvePart2(int[] input) {
		int totalFuel = 0;
		for (int i = 0; i < input.length; i++) {
			while ((input[i] / 3) - 2 >= 0) {
				totalFuel += (input[i] / 3) - 2;
				input[i] = (input[i] / 3) - 2;
			}
		}

		System.out.println("Part 2 response : " + totalFuel);
	}

}
package fr.aelhan.aoc2018;

import java.util.ArrayList;
import java.util.List;

import fr.aelhan.tools.GeneralTools;
import fr.aelhan.tools.MathTools;
import fr.aelhan.tools.ReadFile;

public class December01 {
	ReadFile fileReader = new ReadFile();
	MathTools mathTools = new MathTools();
	GeneralTools generalTools = new GeneralTools();

	public void format(String input) {
		String[] formatted = fileReader.toStringArray1D(input, "\r\n");
		solvePart1(formatted);
		solvePart2(formatted);
	}

	public void solvePart1(String[] input) {
		int result = 0;
		for (int i = 0; i < input.length; i++) {
			String change = input[i];
			switch (change.substring(0, 1)) {
			case "+":
				result += Integer.parseInt(change.substring(1));
				break;
			case "-":
				result -= Integer.parseInt(change.substring(1));
				break;
			default:
				break;
			}
		}
		System.out.println("Part 1 response : " + result);
	}

	public void solvePart2(String[] input) {
		int result = 0;
		List<Integer> results = new ArrayList<>();
		results.add(0);
		boolean foundTwice = false;
		while (!foundTwice) {
			for (int i = 0; i < input.length; i++) {
				String change = input[i];
				switch (change.substring(0, 1)) {
				case "+":
					result += Integer.parseInt(change.substring(1));
					break;
				case "-":
					result -= Integer.parseInt(change.substring(1));
					break;
				default:
					break;
				}
				if (results.contains(result)) {
					foundTwice = true;
					break;
				}
				results.add(result);
			}
		}
		System.out.println("Part 2 response : " + result);
	}

}
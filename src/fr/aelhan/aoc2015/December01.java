package fr.aelhan.aoc2015;

import fr.aelhan.tools.GeneralTools;
import fr.aelhan.tools.MathTools;
import fr.aelhan.tools.ReadFile;

public class December01 {
	ReadFile fileReader = new ReadFile();
	MathTools mathTools = new MathTools();
	GeneralTools generalTools = new GeneralTools();

	public void format(String input) {
		String formatted = input;
		solvePart1(formatted);
		solvePart2(formatted);
	}

	public void solvePart1(String input) {
		int floor = 0;
		for (int i = 0; i < input.length(); i++) {
			floor = move(input, floor, i);
		}
		System.out.println("Part 1 response : " + floor);
	}

	public void solvePart2(String input) {

		int floor = 0;
		int answer = 0;
		for (int i = 0; i < input.length(); i++) {
			floor = move(input, floor, i);
			answer++;
			if (floor == -1) {
				break;
			}

		}
		System.out.println("Part 2 response : " + answer);
	}

	public int move(String input, int floor, int index) {
		switch (input.substring(index, index + 1)) {
		case "(":
			floor++;
			break;
		case ")":
			floor--;
			break;
		default:
			break;
		}
		return floor;
	}
}
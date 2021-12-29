package fr.aelhan.aoc2017;

import fr.aelhan.tools.GeneralTools;
import fr.aelhan.tools.MathTools;
import fr.aelhan.tools.ReadFile;

public class December05 {
	ReadFile fileReader = new ReadFile();
	MathTools mathTools = new MathTools();
	GeneralTools generalTools = new GeneralTools();

	public void format(String input) {
		int[] formatted1 = fileReader.toIntArray1D(input, "\r\n");
		int[] formatted2 = fileReader.toIntArray1D(input, "\r\n");
		solvePart1(formatted1);
		solvePart2(formatted2);
	}

	public void solvePart1(int[] input) {

		int steps = 0;
		int pos = 0;
		while (true) {
			try {
				int instruction = input[pos];
				input[pos]++;
				pos += instruction;
			} catch (Exception e) {
				break;
			}
			steps++;
		}
		System.out.println("Part 1 response : " + steps);
	}

	public void solvePart2(int[] input) {
		int steps = 0;
		int pos = 0;
		int instruction = 0;
		int prevPos = 0;
		while (true) {
			try {
				if (instruction >= 3) {
					input[prevPos] -= 2;
				}
				instruction = input[pos];
				input[pos]++;
				prevPos = pos;
				pos += instruction;
			} catch (Exception e) {
				break;
			}
			steps++;
		}
		System.out.println("Part 2 response : " + steps);
	}

}
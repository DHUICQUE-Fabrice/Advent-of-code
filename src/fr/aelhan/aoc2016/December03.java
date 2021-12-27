package fr.aelhan.aoc2016;

import fr.aelhan.tools.GeneralTools;
import fr.aelhan.tools.MathTools;
import fr.aelhan.tools.ReadFile;

public class December03 {
	ReadFile fileReader = new ReadFile();
	MathTools mathTools = new MathTools();
	GeneralTools generalTools = new GeneralTools();

	public void format(String input) {
		String[][] formatted = fileReader.toStringArray2D(input, "\r\n", "  ");
		solvePart1(formatted);
		solvePart2(formatted);
	}

	public void solvePart1(String[][] input) {
		int[][] map = new int[input.length][3];
		for (int i = 0; i < input.length; i++) {
			int j2 = 0;
			for (int j = 0; j < input[i].length; j++) {
				try {
					map[i][j2] = Integer.parseInt(input[i][j].trim());
					j2++;
				} catch (Exception e) {

				}
			}
		}
		int triangles = 0;
		for (int i = 0; i < input.length; i++) {

			int l0 = map[i][0];
			int l1 = map[i][1];
			int l2 = map[i][2];
			int maxL = mathTools.max(l0, l1, l2);
			int minL = mathTools.min(l0, l1, l2);
			int medL = mathTools.med(l0, l1, l2);
			if (maxL < minL + medL) {
				triangles++;
			}
		}

		System.out.println("Part 1 response : " + triangles);
	}

	public void solvePart2(String[][] input) {
		int[][] map = new int[input.length][3];
		for (int i = 0; i < input.length; i++) {
			int j2 = 0;
			for (int j = 0; j < input[i].length; j++) {
				try {
					map[i][j2] = Integer.parseInt(input[i][j].trim());
					j2++;
				} catch (Exception e) {

				}
			}
		}
		int triangles = 0;
		for (int i = 0; i < input.length - 2; i += 3) {

			int l0 = map[i][0];
			int l1 = map[i + 1][0];
			int l2 = map[i + 2][0];
			int maxL = mathTools.max(l0, l1, l2);
			int minL = mathTools.min(l0, l1, l2);
			int medL = mathTools.med(l0, l1, l2);
			if (maxL < minL + medL) {
				triangles++;
			}

			l0 = map[i][1];
			l1 = map[i + 1][1];
			l2 = map[i + 2][1];
			maxL = mathTools.max(l0, l1, l2);
			minL = mathTools.min(l0, l1, l2);
			medL = mathTools.med(l0, l1, l2);
			if (maxL < minL + medL) {
				triangles++;
			}

			l0 = map[i][2];
			l1 = map[i + 1][2];
			l2 = map[i + 2][2];
			maxL = mathTools.max(l0, l1, l2);
			minL = mathTools.min(l0, l1, l2);
			medL = mathTools.med(l0, l1, l2);
			if (maxL < minL + medL) {
				triangles++;
			}
		}
		System.out.println("Part 2 response : " + triangles);
	}

}
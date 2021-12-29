package fr.aelhan.aoc2018;

import fr.aelhan.tools.GeneralTools;
import fr.aelhan.tools.MathTools;
import fr.aelhan.tools.ReadFile;

public class December03 {
	ReadFile fileReader = new ReadFile();
	MathTools mathTools = new MathTools();
	GeneralTools generalTools = new GeneralTools();

	public void format(String input) {
		String[] formatted = fileReader.toStringArray1D(input, "\r\n");
		solvePart1(formatted);
		solvePart2(formatted);
	}

	public void solvePart1(String[] input) {
		int[][] map = new int[1000][1000];
		for (int i = 0; i < input.length; i++) {
			String coords = input[i].substring(input[i].indexOf("@") + 2);
			int startX = Integer.parseInt(coords.substring(0, coords.indexOf(",")));
			int startY = Integer.parseInt(coords.substring(coords.indexOf(",") + 1, coords.indexOf(":")));
			int width = Integer.parseInt(coords.substring(coords.indexOf(":") + 2, coords.indexOf("x")));
			int height = Integer.parseInt(coords.substring(coords.indexOf("x") + 1));
			for (int row = startX; row < startX + width; row++) {
				for (int col = startY; col < startY + height; col++) {
					map[row][col]++;
				}
			}
		}
		int overlaps = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] >= 2) {
					overlaps++;
				}
			}
		}
		System.out.println("Part 1 response : " + overlaps);
	}

	public void solvePart2(String[] input) {
		int[][] map = new int[1000][1000];
		for (int i = 0; i < input.length; i++) {
			String coords = input[i].substring(input[i].indexOf("@") + 2);
			int startX = Integer.parseInt(coords.substring(0, coords.indexOf(",")));
			int startY = Integer.parseInt(coords.substring(coords.indexOf(",") + 1, coords.indexOf(":")));
			int width = Integer.parseInt(coords.substring(coords.indexOf(":") + 2, coords.indexOf("x")));
			int height = Integer.parseInt(coords.substring(coords.indexOf("x") + 1));
			for (int row = startX; row < startX + width; row++) {
				for (int col = startY; col < startY + height; col++) {
					map[row][col]++;
				}
			}
		}
		int id = 0;
		for (int i = 0; i < input.length; i++) {
			boolean itsMe = true;
			id = Integer.parseInt(input[i].substring(1, input[i].indexOf("@") - 1));
			String coords = input[i].substring(input[i].indexOf("@") + 2);
			int startX = Integer.parseInt(coords.substring(0, coords.indexOf(",")));
			int startY = Integer.parseInt(coords.substring(coords.indexOf(",") + 1, coords.indexOf(":")));
			int width = Integer.parseInt(coords.substring(coords.indexOf(":") + 2, coords.indexOf("x")));
			int height = Integer.parseInt(coords.substring(coords.indexOf("x") + 1));
			for (int row = startX; row < startX + width; row++) {
				for (int col = startY; col < startY + height; col++) {
					if (map[row][col] >= 2) {
						itsMe = false;
					}
				}
			}
			if (itsMe) {
				break;
			}
		}
		System.out.println("Part 2 response : " + id);
	}

}
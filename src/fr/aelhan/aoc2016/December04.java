package fr.aelhan.aoc2016;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.aelhan.tools.GeneralTools;
import fr.aelhan.tools.MathTools;
import fr.aelhan.tools.ReadFile;

public class December04 {
	ReadFile fileReader = new ReadFile();
	MathTools mathTools = new MathTools();
	GeneralTools generalTools = new GeneralTools();

	public void format(String input) {
		String[] formatted = fileReader.toStringArray1D(input, "\r\n");
		solvePart1(formatted);
		solvePart2(formatted);
	}

	public void solvePart1(String[] input) {
		int realRoomSum = 0;
		for (int i = 0; i < input.length; i++) {
			realRoomSum += getSector(input[i]);
		}
		System.out.println("Part 1 response : " + realRoomSum);
	}

	private int getSector(String string) {
		String checkSum = string.substring(string.indexOf("[") + 1, string.length() - 1);
		int sectorId = Integer.parseInt(string.substring(string.lastIndexOf("-") + 1, string.indexOf("[")));
		String toCheck = string.substring(0, string.lastIndexOf("-"));
		Map<String, Integer> letters = new HashMap<>();
		for (int i = 0; i < toCheck.length(); i++) {
			String letterToCheck = toCheck.substring(i, i + 1);
			if (!letterToCheck.equals("-")) {
				if (letters.containsKey(letterToCheck)) {
					letters.put(letterToCheck, letters.get(letterToCheck) + 1);
				} else {
					letters.put(letterToCheck, 1);
				}
			}
		}
		StringBuilder lettersSorted = new StringBuilder();
		int prevQty = 0;
		int maxCommon = Integer.MIN_VALUE;
		for (String letter : letters.keySet()) {
			if (letters.get(letter) > maxCommon) {
				maxCommon = letters.get(letter);
			}
		}
		for (int i = maxCommon; i > 0; i--) {
			List<String> ties = new ArrayList<String>();
			for (String letter : letters.keySet()) {
				if (letters.get(letter) == i) {
					ties.add(letter);
				}
			}
			Collections.sort(ties);
			for (String letter : ties) {
				lettersSorted.append(letter);
			}
		}
		if (lettersSorted.toString().startsWith(checkSum)) {
			return sectorId;
		}

		return 0;
	}

	public void solvePart2(String[] input) {
		int sectorId = 0;
		for (int i = 0; i < input.length; i++) {
			sectorId = Integer.parseInt(input[i].substring(input[i].lastIndexOf("-") + 1, input[i].indexOf("[")));
			int rotations = sectorId % 26;
			String toCheck = input[i].substring(0, input[i].lastIndexOf("-"));
			String answer = new String();
			for (int j = 0; j < toCheck.length(); j++) {
				String letter = toCheck.substring(j, j + 1);
				for (int j2 = 0; j2 < rotations; j2++) {
					letter = rotate(letter);
				}
				answer += letter;
			}
			if (answer.contains("northpole object storage")) {
				break;
			}
		}
		System.out.println("Part 2 response : " + sectorId);
	}

	public String rotate(String letter) {
		switch (letter) {
		case "a":
			return "b";
		case "b":
			return "c";
		case "c":
			return "d";
		case "d":
			return "e";
		case "e":
			return "f";
		case "f":
			return "g";
		case "g":
			return "h";
		case "h":
			return "i";
		case "i":
			return "j";
		case "j":
			return "k";
		case "k":
			return "l";
		case "l":
			return "m";
		case "m":
			return "n";
		case "n":
			return "o";
		case "o":
			return "p";
		case "p":
			return "q";
		case "q":
			return "r";
		case "r":
			return "s";
		case "s":
			return "t";
		case "t":
			return "u";
		case "u":
			return "v";
		case "v":
			return "w";
		case "w":
			return "x";
		case "x":
			return "y";
		case "y":
			return "z";
		case "z":
			return "a";
		default:
			return " ";
		}
	}

}
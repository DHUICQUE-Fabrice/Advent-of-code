package fr.aelhan.aoc2016;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

import fr.aelhan.tools.GeneralTools;
import fr.aelhan.tools.MathTools;
import fr.aelhan.tools.ReadFile;

public class December05 {
	ReadFile fileReader = new ReadFile();
	MathTools mathTools = new MathTools();
	GeneralTools generalTools = new GeneralTools();

	public void format(String input) {
		String formatted = input;
		solvePart1(formatted);
		solvePart2(formatted);
	}

	public void solvePart1(String input) {
		String answer = new String();
		try {
			int i = 0;
			while (true) {
				i++;
				String toTest = input + i;
				MessageDigest messageDigest = MessageDigest.getInstance("MD5");
				messageDigest.update(toTest.getBytes());
				byte[] digest = messageDigest.digest();
				String myHash = DatatypeConverter.printHexBinary(digest);
				if (myHash.startsWith("00000")) {
					answer += myHash.substring(5, 6).toLowerCase();
				}
				if (answer.length() >= 8) {
					break;
				}
			}
		} catch (NoSuchAlgorithmException e) {
			// Do nothing
		}
		System.out.println("Part 1 response : " + answer);
	}

	public void solvePart2(String input) {
		String answer = "________";
		try {
			int i = 0;
			while (true) {
				i++;
				String toTest = input + i;
				MessageDigest messageDigest = MessageDigest.getInstance("MD5");
				messageDigest.update(toTest.getBytes());
				byte[] digest = messageDigest.digest();
				String myHash = DatatypeConverter.printHexBinary(digest);
				if (myHash.startsWith("00000")) {
					try {
						int position = Integer.parseInt(myHash.substring(5, 6));
						String newAnswer = answer;
						if (position < 8 && answer.substring(position, position + 1).equals("_")) {
							newAnswer = answer.substring(0, position);
							newAnswer += myHash.substring(6, 7).toLowerCase();
							newAnswer += answer.substring(position + 1);
						}
						answer = newAnswer;
					} catch (Exception e) {
						// Do nothing
					}
				}
				if (!answer.contains("_")) {
					break;
				}
			}
		} catch (NoSuchAlgorithmException e) {
			// Do nothing
		}
		System.out.println("Part 2 response : " + answer);
	}

}
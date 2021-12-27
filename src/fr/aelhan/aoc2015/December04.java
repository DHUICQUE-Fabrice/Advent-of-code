package fr.aelhan.aoc2015;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

import fr.aelhan.tools.GeneralTools;
import fr.aelhan.tools.MathTools;
import fr.aelhan.tools.ReadFile;

public class December04 {
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
					answer = String.valueOf(i);
					break;
				}
			}
		} catch (NoSuchAlgorithmException e) {
			// Do nothing
		}

		System.out.println("Part 1 response : " + answer);
	}

	public void solvePart2(String input) {
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
				if (myHash.startsWith("000000")) {
					answer = String.valueOf(i);
					break;
				}
			}
		} catch (NoSuchAlgorithmException e) {
			// Do nothing
		}

		System.out.println("Part 2 response : " + answer);
	}
}
package fr.aelhan.tools;

import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadFile {

	public ReadFile() {

	}

	public String toSimpleString(String year, String day) {
		String datas = new String();
		try {
			datas = new String(Files.readAllBytes(Paths.get("inputs/" + year + "/Day" + day + ".txt")));
		} catch (Exception e) {
			System.err.println("File " + day + " can't be read");
		}
		return datas;
	}

	public String[] toStringArray1D(String input, String expression) {
		return input.split(expression);
	}

	public String[][] toStringArray2D(String input, String expr1, String expr2) {
		String[] array1D = toStringArray1D(input, expr1);
		String[][] array2D = new String[array1D.length][];
		for (int i = 0; i < array1D.length; i++) {
			array2D[i] = toStringArray1D(array1D[i].trim(), expr2);
		}
		return array2D;
	}

	public int[] toIntArray1D(String input, String expression) {
		String[] stringArray = toStringArray1D(input, expression);
		int[] datas = new int[stringArray.length];
		for (int i = 0; i < datas.length; i++) {
			datas[i] = Integer.parseInt(stringArray[i].trim());
		}
		return datas;
	}

	public int[][] toIntArray2D(String input, String expr1, String expr2) {
		String[][] array2D = toStringArray2D(input, expr1, expr2);
		int[][] intArray2D = new int[array2D.length][array2D[0].length];
		for (int i = 0; i < intArray2D.length; i++) {
			for (int j = 0; j < intArray2D[0].length; j++) {
				intArray2D[i][j] = Integer.parseInt(array2D[i][j].trim());
			}
		}
		return intArray2D;
	}

}

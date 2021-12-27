package fr.aelhan.tools;

public class GeneralTools {
	public void display(int[][] input) {
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[0].length; j++) {
				System.out.print(input[i][j] + " ");
			}
			System.out.println();
		}
	}
}

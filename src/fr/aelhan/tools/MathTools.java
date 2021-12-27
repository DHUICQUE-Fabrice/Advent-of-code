package fr.aelhan.tools;

public class MathTools {

	public int min(int a, int b, int c) {
		int min = Integer.MAX_VALUE;
		min = Math.min(min, a);
		min = Math.min(min, b);
		min = Math.min(min, c);
		return min;
	}

	public int max(int a, int b, int c) {
		int max = Integer.MIN_VALUE;
		max = Math.max(max, a);
		max = Math.max(max, b);
		max = Math.max(max, c);
		return max;
	}
}

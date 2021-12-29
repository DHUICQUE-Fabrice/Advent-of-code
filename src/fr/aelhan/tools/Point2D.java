package fr.aelhan.tools;

public class Point2D {
	private int x;
	private int y;
	private int value;

	public Point2D(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Point2D(int x, int y, int value) {
		this.x = x;
		this.y = y;
		this.value = value;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Point2D [x=" + x + ", y=" + y + ", value=" + value + "]";
	}

}

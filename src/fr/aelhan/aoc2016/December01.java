package fr.aelhan.aoc2016;

import java.util.ArrayList;
import java.util.List;

import fr.aelhan.tools.GeneralTools;
import fr.aelhan.tools.MathTools;
import fr.aelhan.tools.Point2D;
import fr.aelhan.tools.ReadFile;

public class December01 {
	ReadFile fileReader = new ReadFile();
	MathTools mathTools = new MathTools();
	GeneralTools generalTools = new GeneralTools();

	public void format(String input) {
		String[] formatted = fileReader.toStringArray1D(input, ", ");
		solvePart1(formatted);
		solvePart2(formatted);
	}

	public void solvePart1(String[] input) {
		Direction direction = Direction.NORTH;
		int posX = 0;
		int posY = 0;
		for (int i = 0; i < input.length; i++) {
			switch (input[i].substring(0, 1)) {
			case "L":
				try {
					direction = Direction.values()[direction.ordinal() - 1];
				} catch (Exception e) {
					direction = Direction.WEST;
				}
				break;
			case "R":
				try {
					direction = Direction.values()[direction.ordinal() + 1];
				} catch (Exception e) {
					direction = Direction.NORTH;
				}
				break;
			}
			int blocks = Integer.parseInt(input[i].substring(1));
			switch (direction) {
			case NORTH:
				posY += blocks;
				break;
			case EAST:
				posX += blocks;
				break;
			case WEST:
				posX -= blocks;
				break;
			case SOUTH:
				posY -= blocks;
				break;
			}
		}
		int distance = Math.abs(posX) + Math.abs(posY);
		System.out.println("Part 1 response : " + distance);
	}

	public void solvePart2(String[] input) {
		Direction direction = Direction.NORTH;
		int posX = 0;
		int posY = 0;
		int distance = 0;
		List<Point2D> visited = new ArrayList<>();
		for (int i = 0; i < input.length; i++) {
			if (distance == 0) {
				switch (input[i].substring(0, 1)) {
				case "L":
					try {
						direction = Direction.values()[direction.ordinal() - 1];
					} catch (Exception e) {
						direction = Direction.WEST;
					}
					break;
				case "R":
					try {
						direction = Direction.values()[direction.ordinal() + 1];
					} catch (Exception e) {
						direction = Direction.NORTH;
					}
					break;
				}
				int blocks = Integer.parseInt(input[i].substring(1));
				switch (direction) {
				case NORTH:
					for (int j = 0; j < blocks; j++) {
						posY++;
						Point2D here = new Point2D(posX, posY);
						for (Point2D point2d : visited) {
							if (here.getX() == point2d.getX() && here.getY() == point2d.getY()) {
								distance = Math.abs(posX) + Math.abs(posY);
							}
						}
						visited.add(here);
					}
					break;
				case EAST:
					for (int j = 0; j < blocks; j++) {
						posX++;
						Point2D here = new Point2D(posX, posY);
						for (Point2D point2d : visited) {
							if (here.getX() == point2d.getX() && here.getY() == point2d.getY()) {
								distance = Math.abs(posX) + Math.abs(posY);
							}
						}
						visited.add(here);
					}

					break;
				case WEST:
					for (int j = 0; j < blocks; j++) {
						posX--;
						Point2D here = new Point2D(posX, posY);
						for (Point2D point2d : visited) {
							if (here.getX() == point2d.getX() && here.getY() == point2d.getY()) {
								distance = Math.abs(posX) + Math.abs(posY);
							}
						}
						visited.add(here);
					}

					break;
				case SOUTH:
					for (int j = 0; j < blocks; j++) {
						posY--;
						Point2D here = new Point2D(posX, posY);
						for (Point2D point2d : visited) {
							if (here.getX() == point2d.getX() && here.getY() == point2d.getY()) {
								distance = Math.abs(posX) + Math.abs(posY);
							}
						}
						visited.add(here);
					}
					break;
				}
			}
		}
		System.out.println("Part 2 response : " + distance);
	}

	private enum Direction {
		NORTH, EAST, SOUTH, WEST
	};

}
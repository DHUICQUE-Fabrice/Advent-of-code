package fr.aelhan.aoc2017;

import java.util.ArrayList;
import java.util.List;

import fr.aelhan.tools.GeneralTools;
import fr.aelhan.tools.MathTools;
import fr.aelhan.tools.Point2D;
import fr.aelhan.tools.ReadFile;

public class December03 {
	ReadFile fileReader = new ReadFile();
	MathTools mathTools = new MathTools();
	GeneralTools generalTools = new GeneralTools();

	public void format(String input) {
		int formatted = Integer.parseInt(input);
		solvePart1(formatted);
		solvePart2(formatted);
	}

	public void solvePart1(int input) {
		int caseValue = 1;
		int moves = 1;
		int coordX = 0;
		int coordY = 0;
		int displacements = 1;
		while (caseValue <= input) {
			switch (moves % 4) {
			case 1:
				for (int i = 0; i < displacements; i++) {
					coordX++;
					caseValue++;
					if (caseValue == input) {
						break;
					}
				}
				break;
			case 2:
				for (int i = 0; i < displacements; i++) {
					coordY++;
					caseValue++;
					if (caseValue == input) {
						break;
					}
				}
				displacements++;
				break;
			case 3:
				for (int i = 0; i < displacements; i++) {
					coordX--;
					caseValue++;
					if (caseValue == input) {
						break;
					}
				}
				break;
			case 0:
				for (int i = 0; i < displacements; i++) {
					coordY--;
					caseValue++;
					if (caseValue == input) {
						break;
					}
				}
				displacements++;
				break;
			default:
				break;
			}
			moves++;
		}
		int distance = Math.abs(coordX) + Math.abs(coordY);
		System.out.println("Part 1 response : " + distance);
	}

	public void solvePart2(int input) {
		int answer = 0;
		List<Point2D> points = new ArrayList<Point2D>();
		int caseValue = 1;
		int moves = 1;
		int coordX = 0;
		int coordY = 0;
		int displacements = 1;
		points.add(new Point2D(coordX, coordY, caseValue));
		while (caseValue <= input) {
			switch (moves % 4) {
			case 1:
				for (int i = 0; i < displacements; i++) {
					coordX++;
					caseValue = 0;
					for (Point2D point2d : points) {
						if (point2d.getX() >= coordX - 1 && point2d.getX() <= coordX + 1 && point2d.getY() >= coordY - 1
								&& point2d.getY() <= coordY + 1) {
							caseValue += point2d.getValue();
						}
					}
					points.add(new Point2D(coordX, coordY, caseValue));
					if (caseValue >= input) {
						break;
					}
				}
				break;
			case 2:
				for (int i = 0; i < displacements; i++) {
					coordY++;
					caseValue = 0;
					for (Point2D point2d : points) {
						if (point2d.getX() >= coordX - 1 && point2d.getX() <= coordX + 1 && point2d.getY() >= coordY - 1
								&& point2d.getY() <= coordY + 1) {
							caseValue += point2d.getValue();
						}
					}

					points.add(new Point2D(coordX, coordY, caseValue));
					if (caseValue >= input) {
						break;
					}
				}
				displacements++;
				break;
			case 3:
				for (int i = 0; i < displacements; i++) {
					coordX--;
					caseValue = 0;
					for (Point2D point2d : points) {
						if (point2d.getX() >= coordX - 1 && point2d.getX() <= coordX + 1 && point2d.getY() >= coordY - 1
								&& point2d.getY() <= coordY + 1) {
							caseValue += point2d.getValue();
						}
					}

					points.add(new Point2D(coordX, coordY, caseValue));
					if (caseValue >= input) {
						break;
					}
				}
				break;
			case 0:
				for (int i = 0; i < displacements; i++) {
					coordY--;
					caseValue = 0;
					for (Point2D point2d : points) {
						if (point2d.getX() >= coordX - 1 && point2d.getX() <= coordX + 1 && point2d.getY() >= coordY - 1
								&& point2d.getY() <= coordY + 1) {
							caseValue += point2d.getValue();

						}
					}

					points.add(new Point2D(coordX, coordY, caseValue));
					if (caseValue >= input) {
						break;
					}
				}
				displacements++;
				break;
			default:
				break;
			}
			moves++;
		}
		System.out.println("Part 2 response : " + caseValue);
	}

}
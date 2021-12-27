package fr.aelhan.main;

import fr.aelhan.aoc2015.YearManager2015;
import fr.aelhan.aoc2016.YearManager2016;
import fr.aelhan.aoc2017.YearManager2017;
import fr.aelhan.aoc2018.YearManager2018;
import fr.aelhan.aoc2019.YearManager2019;
import fr.aelhan.aoc2020.YearManager2020;
import fr.aelhan.aoc2021.YearManager2021;

public class CalendarManager {

	public static void main(String[] args) {
		YearManager2015 year2015 = new YearManager2015();
		year2015.start();
		YearManager2016 year2016 = new YearManager2016();
		year2016.start();
		YearManager2017 year2017 = new YearManager2017();
		year2017.start();
		YearManager2018 year2018 = new YearManager2018();
		year2018.start();
		YearManager2019 year2019 = new YearManager2019();
		year2019.start();
		YearManager2020 year2020 = new YearManager2020();
		year2020.start();
		YearManager2021 year2021 = new YearManager2021();
		year2021.start();
	}

}

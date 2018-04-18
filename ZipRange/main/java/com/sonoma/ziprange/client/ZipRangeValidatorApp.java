package com.sonoma.ziprange.client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.sonoma.ziprange.model.ZipRange;
import com.sonoma.ziprange.utils.ZipRangeComparator;

/**
 * @author deepko
 *
 */
public class ZipRangeValidatorApp {

	// Constants used for this program
	private static final String RANGES = "Enter the number of ranges : ";
	private static final String INVALID_ENTRY = "Invalid Entry, Exiting the application";
	private static final String START_RANGE = "Enter the starting range : ";
	private static final String END_RANGE = "Enter the end range : ";
	private static final String ENTERED_RANGE = "The ranges entered are :";
	private static final String RESULTS = "The results are :";

	/**
	 * Main method . This is the starting point of execution.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		calculateZipRanges(scanner);

	}

	/**
	 * Method to calculate the zip ranges . User input is accepted here.
	 * 
	 * @param scan
	 */
	private static void calculateZipRanges(Scanner scan) {
		System.out.print(RANGES);
		int counter = scan.nextInt();
		List<ZipRange> ranges = new ArrayList<ZipRange>();
		while (counter > 0) {
			System.out.print(START_RANGE);
			int start = scan.nextInt();
			System.out.print(END_RANGE);
			int end = scan.nextInt();
			ZipRange range = new ZipRange(start, end);
			/* Validating if the range entered is valid or not */
			if (range.isValidRange()) {
				ranges.add(range);
				counter--;
			} else {
				System.out.println(INVALID_ENTRY);
				System.exit(0);
			}
		}
		System.out.println(ENTERED_RANGE);
		for (ZipRange zip : ranges) {
			System.out.println(zip.toString());
		}
		System.out.println("------------------------------------");
		calculateZipRanges(ranges);

	}

	/**
	 * Method to calculate the zip code ranges
	 * 
	 * @param ranges
	 */
	public static void calculateZipRanges(List<ZipRange> ranges) {
		/* The list of ranges is compared using ZipRangeComparator */
		Collections.sort(ranges, new ZipRangeComparator());
		ZipRange startRange = null;
		ZipRange nextRange = null;
		/* Iterating the list and merging the overlapping ranges */
		for (int i = 0; i < ranges.size() - 1; i++) {
			startRange = ranges.get(i);
			nextRange = ranges.get(i + 1);
			if (startRange.contains(nextRange.getStartRange())) {
				startRange.setEndRange(Math.max(nextRange.getEndRange(),
						startRange.getEndRange()));
				ranges.set(i, startRange);
				ranges.remove(i + 1);
				i--;
			}
		}
		/* Printing the results after calculation */
		System.out.println(RESULTS);
		for (ZipRange range : ranges) {
			System.out.println(range.toString());
		}
		System.out.println("------------------------------------");
	}
}

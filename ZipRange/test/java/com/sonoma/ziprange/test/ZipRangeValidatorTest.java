/**
 * 
 */
package com.sonoma.ziprange.test;

import java.util.ArrayList;
import java.util.List;

import com.sonoma.ziprange.client.ZipRangeValidatorApp;
import com.sonoma.ziprange.model.ZipRange;

/**
 * @author deepko
 *
 */
public class ZipRangeValidatorTest {

	public static void main(String[] args) {
		ZipRangeValidatorTest test = new ZipRangeValidatorTest();
		test.testInValidRange();
		test.testStartRangeGTEndRange();
		test.testValidRange();
		test.testZipCodeValidation();

	}

	/**
	 * This test is to verify the negative test scenario for zip codes with
	 * length lesser than 5 digits
	 */
	public void testInValidRange() {
		ZipRange range = new ZipRange();
		range.setStartRange(6000);
		range.setEndRange(5000);
		System.out.println("Executing Invalid Range test with data , "
				+ "Starting Range : " + range.getStartRange()
				+ " Ending Range : " + range.getEndRange());
		if (!range.isValidRange()) {
			System.out.println("The range entered is invalid .");
		}
	}

	/**
	 * This test is to verify the negative test scenario for zip codes with a
	 * start range greater than the end range
	 */
	public void testStartRangeGTEndRange() {
		ZipRange range = new ZipRange();
		range.setStartRange(6000);
		range.setEndRange(5000);
		System.out.println("Executing Invalid zip range test with "
				+ "start Range greater than end range with data , "
				+ "Starting Range : " + range.getStartRange()
				+ " Ending Range : " + range.getEndRange());
		if (!range.isValidRange()) {
			System.out.println("The range entered is invalid .");
		}
	}

	/**
	 * Testing the positive zip code range
	 */
	public void testValidRange() {
		ZipRange range = new ZipRange();
		range.setStartRange(60001);
		range.setEndRange(65000);
		System.out.println("Executing Valid Range test with data , "
				+ "Starting Range : " + range.getStartRange()
				+ " Ending Range : " + range.getEndRange());
		if (range.isValidRange()) {
			System.out.println("The range entered is valid .");
		}
	}

	/**
	 * Test the zip code validation program. It accepts 4 different ranges and
	 * provide the result.
	 */
	public void testZipCodeValidation() {
		System.out.println("Executing Zip Code validation ");
		List<ZipRange> ranges = new ArrayList<ZipRange>();
		ZipRange range = new ZipRange();
		range.setStartRange(60001);
		range.setEndRange(65000);
		ranges.add(range);
		range = new ZipRange();
		range.setStartRange(63000);
		range.setEndRange(70000);
		ranges.add(range);
		range = new ZipRange();
		range.setStartRange(95000);
		range.setEndRange(96000);
		ranges.add(range);
		range = new ZipRange();
		range.setStartRange(15000);
		range.setEndRange(16000);
		ranges.add(range);
		System.out
				.println("The data entered for validation are [60001 , 65000]  [63000 , 70000] "
						+ " [95000 , 96000]  [15000 , 16000]");
		ZipRangeValidatorApp.calculateZipRanges(ranges);

	}
}

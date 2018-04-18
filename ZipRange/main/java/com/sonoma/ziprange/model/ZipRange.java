package com.sonoma.ziprange.model;

import java.io.Serializable;

/**
 * Model Class which represents range for zip codes.
 * @author deepko
 *
 */
public class ZipRange implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer startRange;
	private Integer endRange;

	public ZipRange() {

	}

	public ZipRange(Integer startRange, Integer endRange) {
		this.startRange = startRange;
		this.endRange = endRange;
	}

	/**
	 * @return the startRange
	 */
	public Integer getStartRange() {
		return startRange;
	}

	/**
	 * @param startRange
	 *            the startRange to set
	 */
	public void setStartRange(Integer startRange) {
		this.startRange = startRange;
	}

	/**
	 * @return the endRange
	 */
	public Integer getEndRange() {
		return endRange;
	}

	/**
	 * @param endRange
	 *            the endRange to set
	 */
	public void setEndRange(Integer endRange) {
		this.endRange = endRange;
	}

	/*
	 * Method displays the start and end range in [] brackets
	 * 
	 */
	@Override
	public String toString() {
		return "[ " + startRange + ", " + endRange + " ] ";
	}

	/**
	 * Method to validate the ranges which should be between 10000 and 99999.
	 * @return boolean
	 */
	public boolean isValidRange() {
		if (this.startRange < 10000 || this.startRange > 99999
				|| this.endRange < 10000 || this.endRange > 99999
				|| this.startRange > this.endRange) {
			return false;
		}
		return true;
	}

	/**
	 * Method to check if the zip code is between the start and end range.
	 * @param zipCode
	 * @return boolean
	 */
	public boolean contains(Integer zipCode) {
		if (this.startRange <= zipCode && this.endRange >= zipCode) {
			return true;
		}
		return false;
	}
}

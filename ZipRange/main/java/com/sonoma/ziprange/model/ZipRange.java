package com.sonoma.ziprange.model;

import java.io.Serializable;

/**
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
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[ " + startRange + ", " + endRange + " ] ";
	}

	public boolean isValidRange() {
		if (this.startRange < 10000 || this.startRange > 99999
				|| this.endRange < 10000 || this.endRange > 99999
				|| this.startRange > this.endRange) {
			return false;
		}
		return true;
	}

	public boolean contains(Integer zip) {
		if (this.startRange <= zip && this.endRange >= zip) {
			return true;
		}
		return false;
	}
}

/**
 * 
 */
package com.sonoma.ziprange.utils;

import java.util.Comparator;

import com.sonoma.ziprange.model.ZipRange;

/**
 * @author deepko
 *
 */
public class ZipRangeComparator implements Comparator<ZipRange> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(ZipRange first, ZipRange second) {
		return first.getStartRange() - second.getStartRange();
	}

}

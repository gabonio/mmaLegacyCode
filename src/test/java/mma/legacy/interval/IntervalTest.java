package mma.legacy.interval;

import static org.junit.Assert.*;
import mma.legacy.interval.Interval;
import mma.legacy.interval.IntervalFactory;
import mma.legacy.interval.Opening;

import org.junit.Test;

public class IntervalTest {

	@Test
	public void midPointTest() {
		assertEquals(5, IntervalFactory.getInterval(0, 10, Opening.BOTH_OPENED).midPoint(), 0.0);
		assertEquals(5, IntervalFactory.getInterval(0, 10, Opening.LEFT_OPENED).midPoint(), 0.0);
		assertEquals(5, IntervalFactory.getInterval(0, 10, Opening.RIGHT_OPENED).midPoint(), 0.0);
		assertEquals(5, IntervalFactory.getInterval(0, 10, Opening.BOTH_CLOSED).midPoint(), 0.0);
		assertEquals(0, IntervalFactory.getInterval(-10, 10, Opening.BOTH_OPENED).midPoint(), 0.0);
		assertEquals(0, IntervalFactory.getInterval(-10, 10, Opening.LEFT_OPENED).midPoint(), 0.0);
		assertEquals(0, IntervalFactory.getInterval(-10, 10, Opening.RIGHT_OPENED).midPoint(), 0.0);
		assertEquals(0, IntervalFactory.getInterval(-10, 10, Opening.BOTH_CLOSED).midPoint(), 0.0);
		assertEquals(-10, IntervalFactory.getInterval(-15, -5, Opening.BOTH_OPENED).midPoint(), 0.0);
		assertEquals(-10, IntervalFactory.getInterval(-15, -5, Opening.LEFT_OPENED).midPoint(), 0.0);
		assertEquals(-10, IntervalFactory.getInterval(-15, -5, Opening.RIGHT_OPENED).midPoint(), 0.0);
		assertEquals(-10, IntervalFactory.getInterval(-15, -5, Opening.BOTH_CLOSED).midPoint(), 0.0);
	}

	@Test
	public void includeValueTest() {
		assertFalse(IntervalFactory.getInterval(0, 10, Opening.BOTH_OPENED).includes(-3));
		assertFalse(IntervalFactory.getInterval(0, 10, Opening.LEFT_OPENED).includes(-3));
		assertFalse(IntervalFactory.getInterval(0, 10, Opening.RIGHT_OPENED).includes(-3));
		assertFalse(IntervalFactory.getInterval(0, 10, Opening.BOTH_CLOSED).includes(-3));
		assertFalse(IntervalFactory.getInterval(0, 10, Opening.BOTH_OPENED).includes(0));
		assertFalse(IntervalFactory.getInterval(0, 10, Opening.LEFT_OPENED).includes(0));
		assertTrue(IntervalFactory.getInterval(0, 10, Opening.RIGHT_OPENED).includes(0));
		assertTrue(IntervalFactory.getInterval(0, 10, Opening.BOTH_CLOSED).includes(0));
		assertTrue(IntervalFactory.getInterval(0, 10, Opening.BOTH_OPENED).includes(5));
		assertTrue(IntervalFactory.getInterval(0, 10, Opening.LEFT_OPENED).includes(5));
		assertTrue(IntervalFactory.getInterval(0, 10, Opening.RIGHT_OPENED).includes(5));
		assertTrue(IntervalFactory.getInterval(0, 10, Opening.BOTH_CLOSED).includes(5));
		assertFalse(IntervalFactory.getInterval(0, 10, Opening.BOTH_OPENED).includes(10));
		assertTrue(IntervalFactory.getInterval(0, 10, Opening.LEFT_OPENED).includes(10));
		assertFalse(IntervalFactory.getInterval(0, 10, Opening.RIGHT_OPENED).includes(10));
		assertTrue(IntervalFactory.getInterval(0, 10, Opening.BOTH_CLOSED).includes(10));
		assertFalse(IntervalFactory.getInterval(0, 10, Opening.BOTH_OPENED).includes(13));
		assertFalse(IntervalFactory.getInterval(0, 10, Opening.LEFT_OPENED).includes(13));
		assertFalse(IntervalFactory.getInterval(0, 10, Opening.RIGHT_OPENED).includes(13));
		assertFalse(IntervalFactory.getInterval(0, 10, Opening.BOTH_CLOSED).includes(13));
	}

	@Test
	public void includeIntervalTest() {

		Interval bothOpenedPivot = IntervalFactory.getInterval(20, 35, Opening.BOTH_OPENED);

		assertTrue(bothOpenedPivot.includes(IntervalFactory.getInterval(10, 15, Opening.BOTH_OPENED)));
		assertTrue(bothOpenedPivot.includes(IntervalFactory.getInterval(15, 20, Opening.BOTH_OPENED)));
		assertTrue(bothOpenedPivot.includes(IntervalFactory.getInterval(20, 25, Opening.BOTH_OPENED)));
		assertTrue(bothOpenedPivot.includes(IntervalFactory.getInterval(25, 30, Opening.BOTH_OPENED)));
		assertTrue(bothOpenedPivot.includes(IntervalFactory.getInterval(30, 35, Opening.BOTH_OPENED)));
		assertFalse(bothOpenedPivot.includes(IntervalFactory.getInterval(35, 40, Opening.BOTH_OPENED)));
		assertFalse(bothOpenedPivot.includes(IntervalFactory.getInterval(40, 45, Opening.BOTH_OPENED)));
		assertFalse(bothOpenedPivot.includes(IntervalFactory.getInterval(10, 15, Opening.LEFT_OPENED)));
		assertFalse(bothOpenedPivot.includes(IntervalFactory.getInterval(15, 20, Opening.LEFT_OPENED)));
		assertTrue(bothOpenedPivot.includes(IntervalFactory.getInterval(20, 25, Opening.LEFT_OPENED)));
		assertTrue(bothOpenedPivot.includes(IntervalFactory.getInterval(25, 30, Opening.LEFT_OPENED)));
		assertFalse(bothOpenedPivot.includes(IntervalFactory.getInterval(30, 35, Opening.LEFT_OPENED)));
		assertFalse(bothOpenedPivot.includes(IntervalFactory.getInterval(35, 40, Opening.LEFT_OPENED)));
		assertFalse(bothOpenedPivot.includes(IntervalFactory.getInterval(40, 45, Opening.LEFT_OPENED)));
		assertFalse(bothOpenedPivot.includes(IntervalFactory.getInterval(10, 15, Opening.RIGHT_OPENED)));
		assertFalse(bothOpenedPivot.includes(IntervalFactory.getInterval(15, 20, Opening.RIGHT_OPENED)));
		assertFalse(bothOpenedPivot.includes(IntervalFactory.getInterval(20, 25, Opening.RIGHT_OPENED)));
		assertTrue(bothOpenedPivot.includes(IntervalFactory.getInterval(25, 30, Opening.RIGHT_OPENED)));
		assertTrue(bothOpenedPivot.includes(IntervalFactory.getInterval(30, 35, Opening.RIGHT_OPENED)));
		assertFalse(bothOpenedPivot.includes(IntervalFactory.getInterval(35, 40, Opening.RIGHT_OPENED)));
		assertFalse(bothOpenedPivot.includes(IntervalFactory.getInterval(40, 45, Opening.RIGHT_OPENED)));
		assertFalse(bothOpenedPivot.includes(IntervalFactory.getInterval(10, 15, Opening.BOTH_CLOSED)));
		assertFalse(bothOpenedPivot.includes(IntervalFactory.getInterval(15, 20, Opening.BOTH_CLOSED)));
		assertFalse(bothOpenedPivot.includes(IntervalFactory.getInterval(20, 25, Opening.BOTH_CLOSED)));
		assertTrue(bothOpenedPivot.includes(IntervalFactory.getInterval(25, 30, Opening.BOTH_CLOSED)));
		assertFalse(bothOpenedPivot.includes(IntervalFactory.getInterval(30, 35, Opening.BOTH_CLOSED)));
		assertFalse(bothOpenedPivot.includes(IntervalFactory.getInterval(35, 40, Opening.BOTH_CLOSED)));
		assertFalse(bothOpenedPivot.includes(IntervalFactory.getInterval(40, 45, Opening.BOTH_CLOSED)));
		Interval leftOpenedPivot = IntervalFactory.getInterval(20, 35, Opening.LEFT_OPENED);
		assertFalse(leftOpenedPivot.includes(IntervalFactory.getInterval(10, 15, Opening.BOTH_OPENED)));
		assertFalse(leftOpenedPivot.includes(IntervalFactory.getInterval(15, 20, Opening.BOTH_OPENED)));
		assertTrue(leftOpenedPivot.includes(IntervalFactory.getInterval(20, 25, Opening.BOTH_OPENED)));
		assertTrue(leftOpenedPivot.includes(IntervalFactory.getInterval(25, 30, Opening.BOTH_OPENED)));
		assertTrue(leftOpenedPivot.includes(IntervalFactory.getInterval(30, 35, Opening.BOTH_OPENED)));
		assertFalse(leftOpenedPivot.includes(IntervalFactory.getInterval(35, 40, Opening.BOTH_OPENED)));
		assertFalse(leftOpenedPivot.includes(IntervalFactory.getInterval(40, 45, Opening.BOTH_OPENED)));
		assertFalse(leftOpenedPivot.includes(IntervalFactory.getInterval(10, 15, Opening.LEFT_OPENED)));
		assertFalse(leftOpenedPivot.includes(IntervalFactory.getInterval(15, 20, Opening.LEFT_OPENED)));
		assertTrue(leftOpenedPivot.includes(IntervalFactory.getInterval(20, 25, Opening.LEFT_OPENED)));
		assertTrue(leftOpenedPivot.includes(IntervalFactory.getInterval(25, 30, Opening.LEFT_OPENED)));
		assertTrue(leftOpenedPivot.includes(IntervalFactory.getInterval(30, 35, Opening.LEFT_OPENED)));
		assertFalse(leftOpenedPivot.includes(IntervalFactory.getInterval(35, 40, Opening.LEFT_OPENED)));
		assertFalse(leftOpenedPivot.includes(IntervalFactory.getInterval(40, 45, Opening.LEFT_OPENED)));
		assertFalse(leftOpenedPivot.includes(IntervalFactory.getInterval(10, 15, Opening.RIGHT_OPENED)));
		assertFalse(leftOpenedPivot.includes(IntervalFactory.getInterval(15, 20, Opening.RIGHT_OPENED)));
		assertFalse(leftOpenedPivot.includes(IntervalFactory.getInterval(20, 25, Opening.RIGHT_OPENED)));
		assertTrue(leftOpenedPivot.includes(IntervalFactory.getInterval(25, 30, Opening.RIGHT_OPENED)));
		assertTrue(leftOpenedPivot.includes(IntervalFactory.getInterval(30, 35, Opening.RIGHT_OPENED)));
		assertFalse(leftOpenedPivot.includes(IntervalFactory.getInterval(35, 40, Opening.RIGHT_OPENED)));
		assertFalse(leftOpenedPivot.includes(IntervalFactory.getInterval(40, 45, Opening.RIGHT_OPENED)));
		assertFalse(leftOpenedPivot.includes(IntervalFactory.getInterval(10, 15, Opening.BOTH_CLOSED)));
		assertFalse(leftOpenedPivot.includes(IntervalFactory.getInterval(15, 20, Opening.BOTH_CLOSED)));
		assertFalse(leftOpenedPivot.includes(IntervalFactory.getInterval(20, 25, Opening.BOTH_CLOSED)));
		assertTrue(leftOpenedPivot.includes(IntervalFactory.getInterval(25, 30, Opening.BOTH_CLOSED)));
		assertTrue(leftOpenedPivot.includes(IntervalFactory.getInterval(30, 35, Opening.BOTH_CLOSED)));
		assertFalse(leftOpenedPivot.includes(IntervalFactory.getInterval(35, 40, Opening.BOTH_CLOSED)));
		assertFalse(leftOpenedPivot.includes(IntervalFactory.getInterval(40, 45, Opening.BOTH_CLOSED)));
		Interval rightOpenedPivot = IntervalFactory.getInterval(20, 35, Opening.RIGHT_OPENED);
		assertFalse(rightOpenedPivot.includes(IntervalFactory.getInterval(10, 15, Opening.BOTH_OPENED)));
		assertFalse(rightOpenedPivot.includes(IntervalFactory.getInterval(15, 20, Opening.BOTH_OPENED)));
		assertTrue(rightOpenedPivot.includes(IntervalFactory.getInterval(20, 25, Opening.BOTH_OPENED)));
		assertTrue(rightOpenedPivot.includes(IntervalFactory.getInterval(25, 30, Opening.BOTH_OPENED)));
		assertTrue(rightOpenedPivot.includes(IntervalFactory.getInterval(30, 35, Opening.BOTH_OPENED)));
		assertFalse(rightOpenedPivot.includes(IntervalFactory.getInterval(35, 40, Opening.BOTH_OPENED)));
		assertFalse(rightOpenedPivot.includes(IntervalFactory.getInterval(40, 45, Opening.BOTH_OPENED)));
		assertFalse(rightOpenedPivot.includes(IntervalFactory.getInterval(10, 15, Opening.LEFT_OPENED)));
		assertFalse(rightOpenedPivot.includes(IntervalFactory.getInterval(15, 20, Opening.LEFT_OPENED)));
		assertTrue(rightOpenedPivot.includes(IntervalFactory.getInterval(20, 25, Opening.LEFT_OPENED)));
		assertTrue(rightOpenedPivot.includes(IntervalFactory.getInterval(25, 30, Opening.LEFT_OPENED)));
		assertFalse(rightOpenedPivot.includes(IntervalFactory.getInterval(30, 35, Opening.LEFT_OPENED)));
		assertFalse(rightOpenedPivot.includes(IntervalFactory.getInterval(35, 40, Opening.LEFT_OPENED)));
		assertFalse(rightOpenedPivot.includes(IntervalFactory.getInterval(40, 45, Opening.LEFT_OPENED)));
		assertFalse(rightOpenedPivot.includes(IntervalFactory.getInterval(10, 15, Opening.RIGHT_OPENED)));
		assertFalse(rightOpenedPivot.includes(IntervalFactory.getInterval(15, 20, Opening.RIGHT_OPENED)));
		assertTrue(rightOpenedPivot.includes(IntervalFactory.getInterval(20, 25, Opening.RIGHT_OPENED)));
		assertTrue(rightOpenedPivot.includes(IntervalFactory.getInterval(25, 30, Opening.RIGHT_OPENED)));
		assertTrue(rightOpenedPivot.includes(IntervalFactory.getInterval(30, 35, Opening.RIGHT_OPENED)));
		assertFalse(rightOpenedPivot.includes(IntervalFactory.getInterval(35, 40, Opening.RIGHT_OPENED)));
		assertFalse(rightOpenedPivot.includes(IntervalFactory.getInterval(40, 45, Opening.RIGHT_OPENED)));
		assertFalse(rightOpenedPivot.includes(IntervalFactory.getInterval(10, 15, Opening.BOTH_CLOSED)));
		assertFalse(rightOpenedPivot.includes(IntervalFactory.getInterval(15, 20, Opening.BOTH_CLOSED)));
		assertTrue(rightOpenedPivot.includes(IntervalFactory.getInterval(20, 25, Opening.BOTH_CLOSED)));
		assertTrue(rightOpenedPivot.includes(IntervalFactory.getInterval(25, 30, Opening.BOTH_CLOSED)));
		assertFalse(rightOpenedPivot.includes(IntervalFactory.getInterval(30, 35, Opening.BOTH_CLOSED)));
		assertFalse(rightOpenedPivot.includes(IntervalFactory.getInterval(35, 40, Opening.BOTH_CLOSED)));
		assertFalse(rightOpenedPivot.includes(IntervalFactory.getInterval(40, 45, Opening.BOTH_CLOSED)));
		Interval unopenedOpenedPivot = IntervalFactory.getInterval(20, 35, Opening.BOTH_CLOSED);
		assertFalse(unopenedOpenedPivot.includes(IntervalFactory.getInterval(10, 15, Opening.BOTH_OPENED)));
		assertFalse(unopenedOpenedPivot.includes(IntervalFactory.getInterval(15, 20, Opening.BOTH_OPENED)));
		assertTrue(unopenedOpenedPivot.includes(IntervalFactory.getInterval(20, 25, Opening.BOTH_OPENED)));
		assertTrue(unopenedOpenedPivot.includes(IntervalFactory.getInterval(25, 30, Opening.BOTH_OPENED)));
		assertTrue(unopenedOpenedPivot.includes(IntervalFactory.getInterval(30, 35, Opening.BOTH_OPENED)));
		assertFalse(unopenedOpenedPivot.includes(IntervalFactory.getInterval(35, 40, Opening.BOTH_OPENED)));
		assertFalse(unopenedOpenedPivot.includes(IntervalFactory.getInterval(40, 45, Opening.BOTH_OPENED)));
		assertFalse(unopenedOpenedPivot.includes(IntervalFactory.getInterval(10, 15, Opening.LEFT_OPENED)));
		assertFalse(unopenedOpenedPivot.includes(IntervalFactory.getInterval(15, 20, Opening.LEFT_OPENED)));
		assertTrue(unopenedOpenedPivot.includes(IntervalFactory.getInterval(20, 25, Opening.LEFT_OPENED)));
		assertTrue(unopenedOpenedPivot.includes(IntervalFactory.getInterval(25, 30, Opening.LEFT_OPENED)));
		assertTrue(unopenedOpenedPivot.includes(IntervalFactory.getInterval(30, 35, Opening.LEFT_OPENED)));
		assertFalse(unopenedOpenedPivot.includes(IntervalFactory.getInterval(35, 40, Opening.LEFT_OPENED)));
		assertFalse(unopenedOpenedPivot.includes(IntervalFactory.getInterval(40, 45, Opening.LEFT_OPENED)));
		assertFalse(unopenedOpenedPivot.includes(IntervalFactory.getInterval(10, 15, Opening.RIGHT_OPENED)));
		assertFalse(unopenedOpenedPivot.includes(IntervalFactory.getInterval(15, 20, Opening.RIGHT_OPENED)));
		assertTrue(unopenedOpenedPivot.includes(IntervalFactory.getInterval(20, 25, Opening.RIGHT_OPENED)));
		assertTrue(unopenedOpenedPivot.includes(IntervalFactory.getInterval(25, 30, Opening.RIGHT_OPENED)));
		assertTrue(unopenedOpenedPivot.includes(IntervalFactory.getInterval(30, 35, Opening.RIGHT_OPENED)));
		assertFalse(unopenedOpenedPivot.includes(IntervalFactory.getInterval(35, 40, Opening.RIGHT_OPENED)));
		assertFalse(unopenedOpenedPivot.includes(IntervalFactory.getInterval(40, 45, Opening.RIGHT_OPENED)));

		assertFalse(unopenedOpenedPivot.includes(IntervalFactory.getInterval(10, 15, Opening.BOTH_CLOSED)));
		assertFalse(unopenedOpenedPivot.includes(IntervalFactory.getInterval(15, 20, Opening.BOTH_CLOSED)));
		assertTrue(unopenedOpenedPivot.includes(IntervalFactory.getInterval(20, 25, Opening.BOTH_CLOSED)));
		assertTrue(unopenedOpenedPivot.includes(IntervalFactory.getInterval(25, 30, Opening.BOTH_CLOSED)));
		assertTrue(unopenedOpenedPivot.includes(IntervalFactory.getInterval(30, 35, Opening.BOTH_CLOSED)));
		assertFalse(unopenedOpenedPivot.includes(IntervalFactory.getInterval(35, 40, Opening.BOTH_CLOSED)));
		assertFalse(unopenedOpenedPivot.includes(IntervalFactory.getInterval(40, 45, Opening.BOTH_CLOSED)));
	}

	@Test
	public void hasIntersectionTest() {

		Interval bothOpenedPivot = IntervalFactory.getInterval(20, 40, Opening.BOTH_OPENED);

		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, Opening.BOTH_OPENED)));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, Opening.BOTH_OPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, Opening.BOTH_OPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, Opening.BOTH_OPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, Opening.BOTH_OPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, Opening.BOTH_OPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, Opening.BOTH_OPENED)));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, Opening.BOTH_OPENED)));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, Opening.BOTH_OPENED)));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, Opening.LEFT_OPENED)));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, Opening.LEFT_OPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, Opening.LEFT_OPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, Opening.LEFT_OPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, Opening.LEFT_OPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, Opening.LEFT_OPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, Opening.LEFT_OPENED)));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, Opening.LEFT_OPENED)));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, Opening.LEFT_OPENED)));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, Opening.RIGHT_OPENED)));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, Opening.RIGHT_OPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, Opening.RIGHT_OPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, Opening.RIGHT_OPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, Opening.RIGHT_OPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, Opening.RIGHT_OPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, Opening.RIGHT_OPENED)));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, Opening.RIGHT_OPENED)));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, Opening.RIGHT_OPENED)));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, Opening.BOTH_CLOSED)));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, Opening.BOTH_CLOSED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, Opening.BOTH_CLOSED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, Opening.BOTH_CLOSED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, Opening.BOTH_CLOSED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, Opening.BOTH_CLOSED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, Opening.BOTH_CLOSED)));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, Opening.BOTH_CLOSED)));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, Opening.BOTH_CLOSED)));

		Interval leftOpenedPivot = IntervalFactory.getInterval(20, 40, Opening.LEFT_OPENED);

		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, Opening.BOTH_OPENED)));
		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, Opening.BOTH_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, Opening.BOTH_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, Opening.BOTH_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, Opening.BOTH_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, Opening.BOTH_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, Opening.BOTH_OPENED)));
		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, Opening.BOTH_OPENED)));
		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, Opening.BOTH_OPENED)));
		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, Opening.LEFT_OPENED)));
		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, Opening.LEFT_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, Opening.LEFT_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, Opening.LEFT_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, Opening.LEFT_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, Opening.LEFT_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, Opening.LEFT_OPENED)));
		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, Opening.LEFT_OPENED)));
		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, Opening.LEFT_OPENED)));
		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, Opening.RIGHT_OPENED)));
		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, Opening.RIGHT_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, Opening.RIGHT_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, Opening.RIGHT_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, Opening.RIGHT_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, Opening.RIGHT_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, Opening.RIGHT_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, Opening.RIGHT_OPENED)));
		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, Opening.RIGHT_OPENED)));
		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, Opening.BOTH_CLOSED)));
		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, Opening.BOTH_CLOSED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, Opening.BOTH_CLOSED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, Opening.BOTH_CLOSED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, Opening.BOTH_CLOSED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, Opening.BOTH_CLOSED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, Opening.BOTH_CLOSED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, Opening.BOTH_CLOSED)));
		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, Opening.BOTH_CLOSED)));
		Interval rightOpenedPivot = IntervalFactory.getInterval(20, 40, Opening.RIGHT_OPENED);
		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, Opening.BOTH_OPENED)));
		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, Opening.BOTH_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, Opening.BOTH_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, Opening.BOTH_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, Opening.BOTH_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, Opening.BOTH_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, Opening.BOTH_OPENED)));
		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, Opening.BOTH_OPENED)));
		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, Opening.BOTH_OPENED)));
		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, Opening.LEFT_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, Opening.LEFT_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, Opening.LEFT_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, Opening.LEFT_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, Opening.LEFT_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, Opening.LEFT_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, Opening.LEFT_OPENED)));
		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, Opening.LEFT_OPENED)));
		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, Opening.LEFT_OPENED)));
		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, Opening.RIGHT_OPENED)));
		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, Opening.RIGHT_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, Opening.RIGHT_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, Opening.RIGHT_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, Opening.RIGHT_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, Opening.RIGHT_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, Opening.RIGHT_OPENED)));
		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, Opening.RIGHT_OPENED)));
		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, Opening.RIGHT_OPENED)));
		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, Opening.BOTH_CLOSED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, Opening.BOTH_CLOSED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, Opening.BOTH_CLOSED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, Opening.BOTH_CLOSED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, Opening.BOTH_CLOSED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, Opening.BOTH_CLOSED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, Opening.BOTH_CLOSED)));
		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, Opening.BOTH_CLOSED)));
		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, Opening.BOTH_CLOSED)));
		Interval unopenedPivot = IntervalFactory.getInterval(20, 40, Opening.BOTH_CLOSED);
		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, Opening.BOTH_OPENED)));
		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, Opening.BOTH_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, Opening.BOTH_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, Opening.BOTH_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, Opening.BOTH_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, Opening.BOTH_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, Opening.BOTH_OPENED)));
		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, Opening.BOTH_OPENED)));
		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, Opening.BOTH_OPENED)));
		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, Opening.LEFT_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, Opening.LEFT_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, Opening.LEFT_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, Opening.LEFT_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, Opening.LEFT_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, Opening.LEFT_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, Opening.LEFT_OPENED)));
		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, Opening.LEFT_OPENED)));
		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, Opening.LEFT_OPENED)));
		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, Opening.RIGHT_OPENED)));
		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, Opening.RIGHT_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, Opening.RIGHT_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, Opening.RIGHT_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, Opening.RIGHT_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, Opening.RIGHT_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, Opening.RIGHT_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, Opening.RIGHT_OPENED)));
		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, Opening.RIGHT_OPENED)));
		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, Opening.BOTH_CLOSED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, Opening.BOTH_CLOSED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, Opening.BOTH_CLOSED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, Opening.BOTH_CLOSED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, Opening.BOTH_CLOSED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, Opening.BOTH_CLOSED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, Opening.BOTH_CLOSED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, Opening.BOTH_CLOSED)));
		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, Opening.BOTH_CLOSED)));
	}

	@Test
	public void hasIntersectionTest2() {

		Interval bothOpenedPivot = IntervalFactory.getInterval(20, 40, Opening.BOTH_OPENED);

		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, Opening.BOTH_OPENED)));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, Opening.BOTH_OPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, Opening.BOTH_OPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, Opening.BOTH_OPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, Opening.BOTH_OPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, Opening.BOTH_OPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, Opening.BOTH_OPENED)));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, Opening.BOTH_OPENED)));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, Opening.BOTH_OPENED)));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, Opening.LEFT_OPENED)));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, Opening.LEFT_OPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, Opening.LEFT_OPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, Opening.LEFT_OPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, Opening.LEFT_OPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, Opening.LEFT_OPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, Opening.LEFT_OPENED)));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, Opening.LEFT_OPENED)));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, Opening.LEFT_OPENED)));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, Opening.RIGHT_OPENED)));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, Opening.RIGHT_OPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, Opening.RIGHT_OPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, Opening.RIGHT_OPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, Opening.RIGHT_OPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, Opening.RIGHT_OPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, Opening.RIGHT_OPENED)));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, Opening.RIGHT_OPENED)));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, Opening.RIGHT_OPENED)));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, Opening.BOTH_CLOSED)));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, Opening.BOTH_CLOSED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, Opening.BOTH_CLOSED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, Opening.BOTH_CLOSED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, Opening.BOTH_CLOSED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, Opening.BOTH_CLOSED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, Opening.BOTH_CLOSED)));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, Opening.BOTH_CLOSED)));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, Opening.BOTH_CLOSED)));

		Interval leftOpenedPivot = IntervalFactory.getInterval(20, 40, Opening.LEFT_OPENED);

		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, Opening.BOTH_OPENED)));
		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, Opening.BOTH_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, Opening.BOTH_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, Opening.BOTH_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, Opening.BOTH_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, Opening.BOTH_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, Opening.BOTH_OPENED)));
		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, Opening.BOTH_OPENED)));
		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, Opening.BOTH_OPENED)));
		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, Opening.LEFT_OPENED)));
		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, Opening.LEFT_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, Opening.LEFT_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, Opening.LEFT_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, Opening.LEFT_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, Opening.LEFT_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, Opening.LEFT_OPENED)));
		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, Opening.LEFT_OPENED)));
		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, Opening.LEFT_OPENED)));
		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, Opening.RIGHT_OPENED)));
		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, Opening.RIGHT_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, Opening.RIGHT_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, Opening.RIGHT_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, Opening.RIGHT_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, Opening.RIGHT_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, Opening.RIGHT_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, Opening.RIGHT_OPENED)));
		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, Opening.RIGHT_OPENED)));
		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, Opening.BOTH_CLOSED)));
		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, Opening.BOTH_CLOSED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, Opening.BOTH_CLOSED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, Opening.BOTH_CLOSED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, Opening.BOTH_CLOSED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, Opening.BOTH_CLOSED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, Opening.BOTH_CLOSED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, Opening.BOTH_CLOSED)));
		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, Opening.BOTH_CLOSED)));
		Interval rightOpenedPivot = IntervalFactory.getInterval(20, 40, Opening.RIGHT_OPENED);
		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, Opening.BOTH_OPENED)));
		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, Opening.BOTH_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, Opening.BOTH_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, Opening.BOTH_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, Opening.BOTH_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, Opening.BOTH_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, Opening.BOTH_OPENED)));
		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, Opening.BOTH_OPENED)));
		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, Opening.BOTH_OPENED)));
		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, Opening.LEFT_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, Opening.LEFT_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, Opening.LEFT_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, Opening.LEFT_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, Opening.LEFT_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, Opening.LEFT_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, Opening.LEFT_OPENED)));
		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, Opening.LEFT_OPENED)));
		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, Opening.LEFT_OPENED)));
		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, Opening.RIGHT_OPENED)));
		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, Opening.RIGHT_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, Opening.RIGHT_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, Opening.RIGHT_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, Opening.RIGHT_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, Opening.RIGHT_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, Opening.RIGHT_OPENED)));
		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, Opening.RIGHT_OPENED)));
		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, Opening.RIGHT_OPENED)));
		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, Opening.BOTH_CLOSED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, Opening.BOTH_CLOSED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, Opening.BOTH_CLOSED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, Opening.BOTH_CLOSED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, Opening.BOTH_CLOSED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, Opening.BOTH_CLOSED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, Opening.BOTH_CLOSED)));
		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, Opening.BOTH_CLOSED)));
		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, Opening.BOTH_CLOSED)));
		Interval unopenedPivot = IntervalFactory.getInterval(20, 40, Opening.BOTH_CLOSED);
		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, Opening.BOTH_OPENED)));
		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, Opening.BOTH_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, Opening.BOTH_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, Opening.BOTH_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, Opening.BOTH_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, Opening.BOTH_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, Opening.BOTH_OPENED)));
		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, Opening.BOTH_OPENED)));
		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, Opening.BOTH_OPENED)));
		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, Opening.LEFT_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, Opening.LEFT_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, Opening.LEFT_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, Opening.LEFT_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, Opening.LEFT_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, Opening.LEFT_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, Opening.LEFT_OPENED)));
		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, Opening.LEFT_OPENED)));
		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, Opening.LEFT_OPENED)));
		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, Opening.RIGHT_OPENED)));
		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, Opening.RIGHT_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, Opening.RIGHT_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, Opening.RIGHT_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, Opening.RIGHT_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, Opening.RIGHT_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, Opening.RIGHT_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, Opening.RIGHT_OPENED)));
		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, Opening.RIGHT_OPENED)));
		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, Opening.BOTH_CLOSED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, Opening.BOTH_CLOSED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, Opening.BOTH_CLOSED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, Opening.BOTH_CLOSED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, Opening.BOTH_CLOSED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, Opening.BOTH_CLOSED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, Opening.BOTH_CLOSED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, Opening.BOTH_CLOSED)));
		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, Opening.BOTH_CLOSED)));
	}

	@Test
	public void gettersAndSettersTest() {
		
		Interval intervalTest = IntervalFactory.getInterval(0, 0, Opening.BOTH_OPENED);
		
		intervalTest.setMinimum(50);
		intervalTest.setMaximum(100);
		intervalTest.setOpening(Opening.BOTH_OPENED);
		
		assertEquals(50, intervalTest.getMinimum(), 0.0);
		assertEquals(100, intervalTest.getMaximum(), 0.0);
		assertEquals(Opening.BOTH_OPENED, intervalTest.getOpening());
	}
	
	@Test
	public void isUpperLimitIncludedAndLowerEqualOrIncludedTest() {
		
		Interval interval1 = IntervalFactory.getInterval(10, 50, Opening.BOTH_OPENED);
		Interval interval2 = IntervalFactory.getInterval(10, 20, Opening.BOTH_OPENED);
		Interval interval3 = IntervalFactory.getInterval(20, 30, Opening.BOTH_OPENED);
		
		assertTrue(interval1.includes(interval3));
		
	}
	
}

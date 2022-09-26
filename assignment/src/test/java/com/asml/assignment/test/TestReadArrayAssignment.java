package com.asml.assignment.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.asml.assignment.ReadArrayAssignment;

public class TestReadArrayAssignment {

	int arr2d[][];

	@BeforeEach
	void setup() {
		int[][] arr2d = { 
				{ 1, 2, 3, 4 }, 
				{ 5, 6, 7, 8 }, 
				{ 9, 10, 11, 12 }, 
				{ 13, 14, 15, 16 } };
		
		this.arr2d = arr2d;
	}

	@Test
	public void testReadLeftToRight() {
		String str = ReadArrayAssignment.readLeftToRight(arr2d, 0, 0, 3);
		assertEquals("1, 2, 3, 4, ", str);
		
		str = ReadArrayAssignment.readLeftToRight(arr2d, 1, 1, 2);
		assertEquals("6, 7, ", str);
		
	}
	
	@Test
	public void testReadTopToBottom() {
		String str = ReadArrayAssignment.readTopToBottom(arr2d, 0, 3, 3);
		assertEquals("8, 12, 16, ", str);
		
		str = ReadArrayAssignment.readTopToBottom(arr2d, 0, 3, 0);
		assertEquals("5, 9, 13, ", str);
		
	}
	
	@Test
	public void testReadRightToLeft() {
		String str = ReadArrayAssignment.readRightToLeft(arr2d, 0, 0, 3);
		assertEquals("3, 2, 1, ", str);
		
		str = ReadArrayAssignment.readRightToLeft(arr2d, 1, 1, 2);
		assertEquals("6, ", str);
		
	}
	
	@Test
	public void testReadBottomToTop() {
		String str = ReadArrayAssignment.readBottomToTop(arr2d, 0, 3, 0);
		assertEquals("9, 5, ", str);
		
		str = ReadArrayAssignment.readBottomToTop(arr2d, 1, 2, 2);
		assertEquals("", str);
		
		str = ReadArrayAssignment.readBottomToTop(arr2d, 1, 3, 2);
		assertEquals("11, ", str);
		
	}
	
	@Test
	public void testReadArr() {
		String actual = ReadArrayAssignment.readArr(arr2d);
		String expected = "1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10, ";
		assertEquals(expected, actual);
		
		int [][] threeColTwoRowArr = {
				{1, 2, 3},
				{4, 5, 6}
		};
		expected = "1, 2, 3, 6, 5, 4, ";
		actual = ReadArrayAssignment.readArr(threeColTwoRowArr);
		
		assertEquals(expected, actual);
		
		int [][] towColThreeRowArr = {
				{1, 2},
				{3, 4},
				{5, 6}
		};
		expected = "1, 2, 4, 6, 5, 3, ";
		actual = ReadArrayAssignment.readArr(towColThreeRowArr);
		
		assertEquals(expected, actual);
		
		int [][] threeColThreeRowArr = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}
		};
		expected = "1, 2, 3, 6, 9, 8, 7, 4, 5, ";
		actual = ReadArrayAssignment.readArr(threeColThreeRowArr);
		
		assertEquals(expected, actual);
	}
	
	

}

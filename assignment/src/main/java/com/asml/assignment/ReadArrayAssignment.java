package com.asml.assignment;

import java.util.Scanner;

public class ReadArrayAssignment {

	/**
	 * 
	 * @param args
	 * 
	 * This is a main function it takes in input and then runs the spiral read on the given array 
	 * 
	 * The first line takes in number of rows (n) and number of columns(m). 
	 * Then it takes in n*m integers.
	 * 
	 * e.g. 
	 * 2 2 (n m)
	 * 1 2 //first row of 2d array 
	 * 3 4 //second row of 2d array
	 * 
	 * 1, 2, 4, 3, // Output.
	 */
	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			int rowSize = sc.nextInt();
			int colSize = sc.nextInt();
			int [][] arr2D = new int[rowSize][colSize];
			for(int i=0;i<rowSize;i++) {
				for(int j=0;j<colSize;j++) {
					arr2D[i][j] = sc.nextInt();
				}
			}
			
			System.out.println("final Answer --> " + readArr(arr2D));
		}

	}
	
	/**
	 * 
	 * @param 2 D Array
	 *
	 * @return Expected string 
	 * 
	 */
	public static String readArr(int [][] arr) {
		String readArrVals = "";
		
		int rowStart=0, colStart=0;
		int rowEnd=arr.length-1, colEnd=arr[0].length -1;
		while(rowStart <= rowEnd) {
			readArrVals += readLeftToRight(arr, rowStart, colStart, colEnd);
			readArrVals += readTopToBottom(arr, rowStart, rowEnd, colEnd);
			readArrVals += readRightToLeft(arr, rowEnd, colStart, colEnd);
			readArrVals += readBottomToTop(arr, rowStart, rowEnd, colStart);
			rowStart++;
			rowEnd--;
			colStart++;
			colEnd--;
			
		}
		return readArrVals;
	}
	
	/**
	 * 
	 * @param arr
	 * @param rowIdx
	 * @param colStart
	 * @param colEnd
	 * @return string
	 * 
	 * This method reads all column values between colStart to colEnd for a specified Row.
	 */
	public static String readLeftToRight(int [][] arr, int rowIdx, 
			int colStart, int colEnd) {
		String readArrVals = "";
		for(int idx = colStart; idx <= colEnd; idx++) {
			readArrVals += arr[rowIdx][idx]+", ";
		}
		System.out.println("readLeftToRight --> " + readArrVals);
		return readArrVals;
	}
	
	/**
	 * 
	 * @param arr
	 * @param rowStart
	 * @param rowEnd
	 * @param colIdx
	 * @return string
	 * 
	 * This method reads all row values between rowStart to rowEnd for a specified Column.
	 * This method skips first row value as thats already been read by previous method.
	 */
	public static String readTopToBottom(int [][] arr, int rowStart, 
			int rowEnd, int colIdx) {
		String readArrVals = "";
		for(int idx = ++rowStart; idx <= rowEnd; idx++) {
			readArrVals += arr[idx][colIdx]+", ";
		}
		System.out.println("readTopToBottom --> " + readArrVals);
		return readArrVals;
	}
	
	/**
	 * 
	 * @param arr
	 * @param rowIdx
	 * @param colStart
	 * @param colEnd
	 * @return string
	 * 
	 * This method reads all Column values between colEnd to colStart for a specified row.
	 * This method skips last col value as thats already been read by previous method.
	 */
	public static String readRightToLeft(int [][] arr, int rowIdx, 
			int colStart, int colEnd) {
		String readArrVals = "";
		for(int idx = --colEnd; idx >= colStart; idx--) {
			readArrVals += arr[rowIdx][idx]+", ";
		}
		System.out.println("readRightToLeft --> " + readArrVals);
		return readArrVals;
	}
	
	/**
	 * 
	 * @param arr
	 * @param rowStart
	 * @param rowEnd
	 * @param colIdx
	 * @return string
	 * 
	 * This method reads all Column values between rowEnd to rowStart for a specified column.
	 * This method skips the first and last row value as thats already been read.
	 */
	public static String readBottomToTop(int [][] arr, int rowStart, 
			int rowEnd, int colIdx) {
		String readArrVals = "";
		for(int idx = rowEnd-1; idx > rowStart; idx--) {
			readArrVals += arr[idx][colIdx]+", ";
		}
		System.out.println("readBottomToTop --> " + readArrVals);
		return readArrVals;
	}

}

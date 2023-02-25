// Given an array of positive and negative numbers, arrange them in an alternate 
// fashion such that every positive number is followed by negative and vice-versa. 
// Order of elements in output doesn’t matter. Extra positive or negative elements should be moved to end.

// Input :
// arr[] = {-2, 3, 4, -1}
// Output :
// arr[] = {-2, 3, -1, 4} OR {-1, 3, -2, 4} OR ..

// Input :
// arr[] = {-2, 3, 1}
// Output :
// arr[] = {-2, 3, 1} OR {-2, 1, 3} 


import java.io.*;
import java.lang.*;
import java.util.*;
public class ArrayOfAlternativePositiveAndNegatveNo {

	static void fill1(int a[], int neg, int pos) 	{
		if (neg % 2 == 1) {
			for (int i = 1; i < neg; i += 2) {
				int c = a[i];
				int d = a[i + neg];
				int temp = c;
				a[i] = d;
				a[i + neg] = temp;
			}
		}
		else {
			for (int i = 1; i <= neg; i += 2) {
				int c = a[i];
				int d = a[i + neg - 1];
				int temp = c;
				a[i] = d;
				a[i + neg - 1] = temp;
			}
		}
	}

	static void fill2(int a[], int neg, int pos)	{
		if (pos % 2 == 1) {
			for (int i = 1; i < pos; i += 2) {
				int c = a[i];
				int d = a[i + pos];
				int temp = c;
				a[i] = d;
				a[i + pos] = temp;
			}
		}
		else {
			for (int i = 1; i <= pos; i += 2) {
				int c = a[i];
				int d = a[i + pos - 1];
				int temp = c;
				a[i] = d;
				a[i + pos - 1] = temp;
			}
		}
	}

	static void reverse(int a[], int n) {
		int i, k, t;
		for (i = 0; i < n / 2; i++) {
			t = a[i];
			a[i] = a[n - i - 1];
			a[n - i - 1] = t;
		}
	}

	static void print(int a[], int n) {
		for (int i = 0; i < n; i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = { 2, 3, -4, -1, 6, -9 };
		int n = arr.length;
		System.out.println("Given array is ");
		System.out.print(arr, n);
		int neg = 0, pos = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] < 0)
				neg++;
			else
				pos++;
		}
		Arrays.sort(arr);

		if (neg <= pos) {
			fill1(arr, neg, pos);
		}
		else {
			reverse(arr, n);
			fill2(arr, neg, pos);
		}
		System.out.println("Rearranged array is ");
		print(arr, n);
	}
}

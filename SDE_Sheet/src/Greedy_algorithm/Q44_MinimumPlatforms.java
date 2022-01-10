package sde_sheet;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumPlatforms {

	public static int findPlatform(int[] arr, int[] dep, int n) {
		Arrays.sort(arr);
		Arrays.sort(dep);

		int platformsNeeded = 1, maxPlatforms = 1;
		int i = 1, j = 0; // indices for next arrival time and current departure time

		// Two pointer approach
		while (i < n && j < n) {

			if (arr[i] <= dep[j]) {
				platformsNeeded++;
				i++;
			} else {
				platformsNeeded--;
				j++;
			}

			if (platformsNeeded > maxPlatforms) {
				maxPlatforms = platformsNeeded;
			}

		}

		return maxPlatforms;

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] start = new int[n];
		for (int s = 0; s < n; s++) {
			start[s] = sc.nextInt();
		}
		int[] end = new int[n];
		for (int e = 0; e < n; e++) {
			end[e] = sc.nextInt();
		}
		int answer = findPlatform(start, end, n);
		System.out.println("Minimum platforms: " + answer);
		sc.close();

	}

}

/*
 * Example 1:
 * 
 * Input: n = 6
 * 
 * arr[] = {0900 0940 0950 1100 1500 1800}
 * 
 * dep[] = {0910 1200 1120 1130 1900 2000}
 * 
 * 
 * Output: 
 * 
 * Minimum platforms: 3
 */
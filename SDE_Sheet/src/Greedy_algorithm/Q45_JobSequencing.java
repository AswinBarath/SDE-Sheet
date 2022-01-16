package Greedy_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Job {
	int jobid;
	int deadline;
	int profit;

	public Job(int jobid, int deadline, int profit) {
		this.jobid = jobid;
		this.deadline = deadline;
		this.profit = profit;
	}
}

public class Q45_JobSequencing {

	public static int[] jobScheduling(Job arr[], int n) {

		// Sorting jobs w.r.t profit in decreasing order
		// The comparator is passed as a lambda expression
		Arrays.sort(arr, (a, b) -> (b.profit - a.profit));

		int maxi = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i].deadline > maxi) {
				maxi = arr[i].deadline;
			}
		}

		int[] result = new int[maxi + 1];

		for (int i = 0; i <= maxi; i++) {
			result[i] = -1;
		}

		int countJobs = 0, jobProfit = 0;

		for (int i = 0; i < n; i++) {
			for (int j = arr[i].deadline; j > 0; j--) {

				// Free slot found
				if (result[j] == -1) {
					result[j] = i;
					countJobs++;
					jobProfit += arr[i].profit;
					break;
				}
			}
		}

		int[] ans = new int[] { countJobs, jobProfit };
		return ans;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// test cases
		int t = Integer.parseInt(br.readLine().trim());
		while (t-- > 0) {
			String inputLine[] = br.readLine().trim().split(" ");

			// size of array
			int n = Integer.parseInt(inputLine[0]);
			Job[] arr = new Job[n];
			inputLine = br.readLine().trim().split(" ");

			// adding id, deadline, profit
			for (int i = 0, k = 0; i < n; i++) {
				arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]),
						Integer.parseInt(inputLine[k++]));
			}

			// function call
			int[] res = jobScheduling(arr, n);
			System.out.println(res[0] + " " + res[1]);
		}
	}

}

/*
 * I/P & O/P
 * 
 * 1
 * 
 * 4
 * 
 * 1 4 20 2 1 10 3 1 40 4 1 30
 * 
 * 2 60
 * 
 */

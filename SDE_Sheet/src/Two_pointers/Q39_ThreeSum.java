package sde_sheet;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {

	public static List<List<Integer>> threeSum(int[] nums) {

		Arrays.sort(nums);

		List<List<Integer>> res = new LinkedList<>();

		// Runs the loop till 3rd last index to form the final valid triplet
		for (int i = 0; i < nums.length - 2; i++) {

			// Avoid duplicates for choosing a using nums[i]!= nums[i-1])
			if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {

				int lo = i + 1;
				int hi = nums.length - 1;
				int sum = 0 - nums[i];

				// Two pointer approach
				while (lo < hi) {
					if (nums[lo] + nums[hi] == sum) {
						res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));

						// Ignore all the duplicates for choosing b and c for triplets
						while (lo < hi && nums[lo] == nums[lo + 1])
							lo++;
						while (lo < hi && nums[hi] == nums[hi - 1])
							hi--;

						lo++;
						hi--;
					} else if (nums[lo] + nums[hi] < sum)
						lo++;

					else
						hi--;
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {

		int[] nums = { -1, -2, -2, -1, -1, 2, 0, 2, 0, 0, 2 };
		List<List<Integer>> answer = threeSum(nums);

		System.out.println("Triplets resulting in 0 sum :");
		System.out.println("-----");
		for (List<Integer> triplet : answer) {
			System.out.println(triplet);
			System.out.println("-----");
		}

	}
}

/*
 * Output:
 * 
 * Triplets resulting in 0 sum : 
 * ----- 
 * [-2, 0, 2] 
 * -----
 * [-1, -1, 2] 
 * ----- 
 * [0, 0, 0] 
 * -----
 * 
 */
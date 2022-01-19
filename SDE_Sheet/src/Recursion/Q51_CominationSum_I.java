package Recursion;

/*
 * Leetcode problem link: https://leetcode.com/problems/combination-sum/
 * 
 * Use Recursion: Whenever you see Combination or subsequences
 * 
 * Apply "Pick and Don't Pick" idea
 * 
 * Time Complexity: O(2^t * k) --> Exponential
 * 					where 2^t is no. of times we explore combinations 
 * 							k is no. of times we add combination DS to answer DS  
 * 
 * Space Complexity: O(k * x) --> Hypothetical 
 * 					where k is the average length of DS
 * 						  x is the no. of combination
 * 
 */

import java.util.ArrayList;
import java.util.List;

public class Q51_CominationSum_I {

	public static void main(String[] args) {
		int[] candidates = { 2, 3, 6, 7 };
		int target = 7;

		List<List<Integer>> answer = combinationSum(candidates, target);

		for (List<Integer> sub : answer) {
			for (int num : sub) {
				System.out.print(num + ", ");
			}
			System.out.println();
		}

	}

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> answer = new ArrayList<>();
		combinationSum(0, candidates, target, answer, new ArrayList<Integer>());
		return answer;
	}

	public static void combinationSum(int ind, int[] candidates, int target, List<List<Integer>> answer,
			List<Integer> choices) {

		// Base case
		if (ind == candidates.length) {
			if (target == 0) {
				answer.add(new ArrayList<>(choices)); // This addition of choices to answer is O(size) --> Linear, not constant
				// we add choices only if they sum up to target
			}
			return;
		}

		// pick recursive case
		if (candidates[ind] <= target) {
			choices.add(candidates[ind]);
			combinationSum(ind, candidates, target - candidates[ind], answer, choices);
			choices.remove(choices.lastIndexOf(candidates[ind]));
			// Remove the candidate to perform proper backtracking
		}
		
		// don't pick recursive case
		combinationSum(ind + 1, candidates, target, answer, choices);
	}

}

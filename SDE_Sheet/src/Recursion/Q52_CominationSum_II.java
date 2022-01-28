package Recursion;

/*
 * Leetcode problem link: https://leetcode.com/problems/combination-sum-ii/
 * 
 * Use Recursion: Whenever you see Combination or subsequences
 * 
 * Apply "Pick and Don't Pick" idea
 * 
 * Brute Force:-
 * -----------
 * 
 * Time Complexity: O(2^t * k * log(n)) --> Exponential
 * 					where 2^t is no. of times we explore combinations 
 * 							k is no. of times we add combination DS to answer DS  
 * 							log(n) is extra time for HashSet
 * 
 * Space Complexity: O(k * x) --> Hypothetical 
 * 					where k is the average length of DS
 * 						  x is the no. of combination
 * 
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q52_CominationSum_II {

	public static void main(String[] args) {
		int[] candidates = { 10, 1, 2, 7, 6, 1, 5 };
		int target = 8;

		List<List<Integer>> answer = combinationSum2BruteForce(candidates, target);
//		List<List<Integer>> answer = combinationSum2(candidates, target);

		for (List<Integer> sub : answer) {
			for (int num : sub) {
				System.out.print(num + ", ");
			}
			System.out.println();
		}

	}

	public static List<List<Integer>> combinationSum2BruteForce(int[] candidates, int target) {
		Set<List<Integer>> answer = new HashSet<>();
		combinationSum2BruteForce(0, candidates, target, answer, new ArrayList<Integer>());
		return new ArrayList<List<Integer>>(answer);
	}

	public static void combinationSum2BruteForce(int ind, int[] candidates, int target, Set<List<Integer>> answer,
			List<Integer> choices) {

		// Base case
		if (ind == candidates.length) {
			if (target == 0) {
				List<Integer> c = new ArrayList<>(choices);
				Collections.sort(c);
				answer.add(c);
				// This addition of choices to answer is O(size)
				// --> Linear, not constant
				// we add choices only if they sum up to target
			}
			return;
		}

		// pick recursive case
		if (candidates[ind] <= target) {
			choices.add(candidates[ind]);
			combinationSum2BruteForce(ind + 1, candidates, target - candidates[ind], answer, choices);
			choices.remove(choices.lastIndexOf(candidates[ind]));
			// Remove the candidate to perform proper backtracking
		}

		// don't pick recursive case
		combinationSum2BruteForce(ind + 1, candidates, target, answer, choices);
	}

}
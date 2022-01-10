package sde_sheet;

public class ContainerWithMostWater {

	public static void main(String[] args) {
		int[] heights = { 4, 3, 2, 1, 4 };
		// int answer = bruteForceSoln(heights);
		int answer = optimalSoln(heights);
		System.out.println(answer);
	}

	private static int optimalSoln(int[] heights) {

		// Time Complexity: O(N)
		// Space Complexity: O(1)

		// Sifting Two-pointer technique (Greedy)
		int maxArea = 0;
		int p1 = 0, p2 = heights.length - 1;
		while (p1 < p2) {
			// System.out.println(p1 + " " + p2);
			int height = Math.min(heights[p1], heights[p2]);
			int width = (p2 - p1);
			int area = height * width;
			maxArea = Math.max(maxArea, area);
			if (heights[p1] < heights[p2]) {
				p1++;
			} else {
				p2--;
			}
		}
		return maxArea;
	}

	private static int bruteForceSoln(int[] heights) {
		// Time Complexity: O(N^2)
		// Space Complexity: O(1)

		// Two-pointer technique
		int maxArea = 0;
		for (int p1 = 0; p1 < heights.length; p1++) {
			for (int p2 = p1 + 1; p2 < heights.length; p2++) {
				int height = Math.min(heights[p1], heights[p2]);
				int width = (p2 - p1);
				int area = height * width;
				maxArea = Math.max(maxArea, area);
			}
		}
		return maxArea;
	}

}

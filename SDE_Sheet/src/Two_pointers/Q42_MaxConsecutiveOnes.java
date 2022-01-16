package Two_pointers;

public class Q42_MaxConsecutiveOnes {

	public static int findMaxConsecutiveOnes(int[] nums) {
		int count = 0;
		int maxi = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 1) {
				count++;
			} else {
				count = 0;
			}
			maxi = Math.max(maxi, count);
		}
		return maxi;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 0, 1, 1, 1 };
		System.out.println("Answer: " + findMaxConsecutiveOnes(nums));
	}

}

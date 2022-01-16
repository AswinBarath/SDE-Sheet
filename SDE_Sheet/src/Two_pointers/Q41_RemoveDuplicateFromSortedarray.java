package Two_pointers;

public class Q41_RemoveDuplicateFromSortedarray {

	public static int removeDuplicates(int[] nums) {

		// Base cases
		if (nums.length == 0 || nums.length == 1) {
			return nums.length;
		}

		// Two pointer approach
		int i = 0, j = 1;
		while (j < nums.length) {
			if (nums[i] == nums[j]) {
				j++;
			} else {
				i++;
				nums[i] = nums[j];
			}
		}
		return i + 1;
	}

	public static void main(String[] args) {

		int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };

		System.out.println("Original array");
		for (int i : nums) {
			System.out.print(i + ", ");
		}
		System.out.println();

		System.out.println("Unique elements: " + removeDuplicates(nums));

		System.out.println("New array");
		for (int i : nums) {
			System.out.print(i + ", ");
		}
		System.out.println();

	}

}



import java.util.Arrays;
import java.util.Scanner;

public class Q1_Sort012 {

	public void sortColorsOptimal(int[] nums) {
		int low = 0, mid = 0, high = nums.length - 1;
		int temp;
		while (mid <= high) {
			switch (nums[mid]) {
				case 0: {
					temp = nums[mid];
					nums[mid] = nums[low];
					nums[low] = temp;
					mid++;
					low++;
					break;
				}
				case 1: {
					mid++;
					break;
				}
				case 2: {
					temp = nums[mid];
					nums[mid] = nums[high];
					nums[high] = temp;
					high--;
					break;
				}
			}
		}
	}

	public void sortColorsBetter(int[] nums) {
		int low = 0, mid = 0, high = nums.length - 1;
		int count0 = 0, count1 = 0, count2 = 0;
		for (int i = 0; i < high; i++) {
			switch (nums[i]) {
				case 0:
					count0++;
					break;
				case 1:
					count1++;
					break;
				case 2:
					count2++;
					break;
			}
		}
		int i = 0;
		while (i < high) {
			while (count0 != 0) {
				nums[i] = 0;
				count0--;
				i++;
			}
			while (count1 != 0) {
				nums[i] = 1;
				count1--;
				i++;
			}
			while (count2 != 0) {
				nums[i] = 2;
				count2--;
				i++;
			}
		}
	}

	public void sortColorsBrute(int[] nums) {
		// code
		Arrays.sort(nums);
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Array length followed by array elements:-");
		int n = input.nextInt();
		int[] nums = new int[n];
		for(int i=0; i<n; i++) {
			nums[i] = input.nextInt();
		}
		input.close();
		Q1_Sort012 obj = new Q1_Sort012();
		obj.sortColorsOptimal(nums);
		obj.sortColorsBetter(nums);
		obj.sortColorsBrute(nums);
	}

}

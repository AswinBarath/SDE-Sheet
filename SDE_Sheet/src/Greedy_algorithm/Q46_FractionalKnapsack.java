package Greedy_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

class Item {
	int value, weight;

	Item(int x, int y) {
		this.value = x;
		this.weight = y;
	}
}

class ItemComparator implements Comparator<Item> {
	@Override
	public int compare(Item a, Item b) {
		double r1 = (double) (a.value) / (double) (a.weight);
		double r2 = (double) (b.value) / (double) (b.weight);
		if (r1 < r2)
			return 1;
		else if (r1 > r2)
			return -1;
		else
			return 0;
	}
}

public class Q46_FractionalKnapsack {

	public static double fractionalKnapsack(int W, Item arr[], int n) {
		Arrays.sort(arr, new ItemComparator());

		int curWeight = 0;
		double finalvalue = 0.0;

		for (int i = 0; i < n; i++) {

			if (curWeight + arr[i].weight <= W) {
				curWeight += arr[i].weight;
				finalvalue += arr[i].value;
			}

			else {
				int remain = W - curWeight;
				finalvalue += ((double) arr[i].value / (double) arr[i].weight) * (double) remain;
				break;
			}
		}

		return finalvalue;

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while (t-- > 0) {
			String inputLine[] = br.readLine().trim().split(" ");
			int n = Integer.parseInt(inputLine[0]);
			int w = Integer.parseInt(inputLine[1]);
			Item[] arr = new Item[n];
			inputLine = br.readLine().trim().split(" ");
			for (int i = 0, k = 0; i < n; i++) {
				arr[i] = new Item(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
			}
			System.out.println(String.format("%.2f", fractionalKnapsack(w, arr, n)));
		}
	}

}

//Input & Output:
//1
//3 50
//60 10 100 20 120 30
//
//
//240.00

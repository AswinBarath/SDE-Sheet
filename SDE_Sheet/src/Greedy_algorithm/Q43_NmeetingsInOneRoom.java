package Greedy_algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class meeting {
	int start;
	int end;
	int pos;

	meeting(int start, int end, int pos) {
		this.start = start;
		this.end = end;
		this.pos = pos;
	}
}

class meetingComparator implements Comparator<meeting> {
	@Override
	public int compare(meeting o1, meeting o2) {
		if (o1.end < o2.end)
			return -1;
		else if (o1.end > o2.end)
			return 1;
		else if (o1.pos < o2.pos)
			return -1;
		return 1;
	}
}

public class Q43_NmeetingsInOneRoom {

	public static int nMeetings(int[] start, int[] end, int n) {
		ArrayList<meeting> meet = new ArrayList<>();

		for (int i = 0; i < start.length; i++)
			meet.add(new meeting(start[i], end[i], i + 1));

		meetingComparator mc = new meetingComparator();
		Collections.sort(meet, mc);

		int limit = meet.get(0).end;
		int count = 1;
		for (int i = 1; i < start.length; i++) {
			if (meet.get(i).start > limit) {
				limit = meet.get(i).end;
				count++;
			}
		}

		return count;
	}

	public static void nMeetings_printMeetings(int[] start, int[] end, int n) {
		ArrayList<meeting> meet = new ArrayList<>();

		for (int i = 0; i < start.length; i++)
			meet.add(new meeting(start[i], end[i], i + 1));

		meetingComparator mc = new meetingComparator();
		Collections.sort(meet, mc);

		ArrayList<Integer> answer = new ArrayList<>();
		answer.add(meet.get(0).pos);

		int limit = meet.get(0).end;
		for (int i = 1; i < start.length; i++) {
			if (meet.get(i).start > limit) {
				limit = meet.get(i).end;
				answer.add(meet.get(i).pos);
			}
		}

		for (int i = 0; i < answer.size(); i++) {
			System.out.print(answer.get(i) + " ");
		}
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
		int answer = nMeetings(start, end, n);
		System.out.println("Maximum meetings: " + answer);
		sc.close();

	}

}

/*
 * I/P & O/P:
 *
 * 6
 * 
 * 1 0 3 8 5 8
 * 
 * 2 6 4 9 7 9
 * 
 * Maximum meetings: 4
 * 
 */
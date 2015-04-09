package datastructs;

import java.util.ArrayList;

public class MergeSort {
	private static ArrayList<Node> aux; // auxiliary array for merges

	public static void sort(ArrayList<Node> a) {
		aux = new ArrayList<Node>(a.size()); // Allocate space just once.
		sort(a, 0, a.size() - 1);
		System.out.println("RUN");
	}

	private static void sort(ArrayList<Node> a, int lo, int hi) { // Sort
																// a[lo..hi].
		if (hi <= lo)
			return;
		int mid = lo + (hi - lo) / 2;
		sort(a, lo, mid); // Sort left half.
		sort(a, mid + 1, hi); // Sort right half.
		merge(a, lo, mid, hi); // Merge results (code on page 271).
	}

	public static void merge(ArrayList<Node> a, int lo, int mid, int hi) { // Merge
		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; k++)
			// Copy a[lo..hi] to aux[lo..hi].
			aux.set(k, a.get(k));
		for (int k = lo; k <= hi; k++)
			// Merge back to a[lo..hi].
			if (i > mid)
				a.set(k, aux.get(j++));
			else if (j > hi)
				a.set(k, aux.get(i++));
			else if (less(aux.get(j), aux.get(i)))
				a.set(k, aux.get(j++));
			else
				a.set(k, aux.get(i++));
	}
	
	private static boolean less(Node aux2, Node aux3)
	{
		if(aux2.compareTo(aux3) < 0 )
			return true;
		return false;
		
	}
}

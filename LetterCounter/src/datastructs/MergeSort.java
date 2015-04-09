package datastructs;

public class MergeSort {
	private static Comparable<Node>[] aux; // auxiliary array for merges

	public static void sort(Comparable<Node>[] a) {
		aux = new Node[a.length]; // Allocate space just once.
		sort(a, 0, a.length - 1);
	}

	private static void sort(Comparable<Node>[] a, int lo, int hi) { // Sort
																// a[lo..hi].
		if (hi <= lo)
			return;
		int mid = lo + (hi - lo) / 2;
		sort(a, lo, mid); // Sort left half.
		sort(a, mid + 1, hi); // Sort right half.
		merge(a, lo, mid, hi); // Merge results (code on page 271).
	}

	public static void merge(Comparable<Node>[] a, int lo, int mid, int hi) { // Merge
		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; k++)
			// Copy a[lo..hi] to aux[lo..hi].
			aux[k] = a[k];
		for (int k = lo; k <= hi; k++)
			// Merge back to a[lo..hi].
			if (i > mid)
				a[k] = aux[j++];
			else if (j > hi)
				a[k] = aux[i++];
			else if (less(aux[j], aux[i]))
				a[k] = aux[j++];
			else
				a[k] = aux[i++];
	}
	
	private static boolean less(Comparable<Node> aux2, Comparable<Node> aux3)
	{
		if(aux2.compareTo((Node) aux3) < 0 )
			return true;
		return false;
		
	}
}

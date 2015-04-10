package datastructs;


public class MergeSort 
{
	private static Node[] aux; 

	public static void sort(Node[] a) 
	{
		aux = new Node[a.length]; // Allocate space
		sort(a, 0, a.length - 1);
	}

	private static void sort(Node[] a, int lo, int hi) 
	{ 

		if (hi <= lo)
			return;
		int mid = lo + (hi - lo) / 2;
		sort(a, lo, mid); // Sort left half.
		sort(a, mid + 1, hi); // Sort right half.
		merge(a, lo, mid, hi); // Merge results 
	}

	public static void merge(Node[] a, int lo, int mid, int hi) 
	{ 
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
	
	private static boolean less(Node aux2, Node aux3)
	{
		if(aux2.compareTo(aux3) < 0 )
			return true;
		return false;
		
	}
}

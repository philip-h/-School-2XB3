package datastructs;

public class BinarySearch {
    public static Node search(String key, Node[] n) {
        int lo = 0;
        int hi = n.length - 1;
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if (key.compareTo(n[mid].getKey()) < 0)
                hi = mid - 1;
            else if (key.compareTo(n[mid].getKey()) > 0)
                lo = mid + 1;
            else return n[mid];
        }
        return null;
    }

    public static boolean contains(String key, Node [] n) {
        return search(key,n) != null;

    }
}
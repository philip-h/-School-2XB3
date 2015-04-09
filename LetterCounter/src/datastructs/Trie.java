package datastructs;

import java.util.ArrayList;
/**
 * 
 * Added By Theo on 08/05/15
 * 
 */
public class Trie {
    private static final int R = 256;        // Alphabet.. for now


    private Node root;      // root of trie
    private int N;          // number of keys in trie



    /*.**************************************************************************/
    /*.SIZE OPERATIONS*/
    /*.**************************************************************************/

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    /*.**************************************************************************/
    /*.CONTAINS*/
    /*.**************************************************************************/

    public boolean contains(String key) {
        return get(key) != null;
    }

    /*.**************************************************************************/
    /*.GET*/
    /*.**************************************************************************/

    public Integer get(String key) {
        Node x = get(root, key, 0);
        if (x == null)
            return null;
        return x.val;
    }

    private Node get(Node x, String key, int d) {
        if (x == null)
            return null;
        if (d == key.length())
            return x;
        char c = key.charAt(d);
        return get(x.next[c], key, d + 1);
    }

	public int getCount(String key) {
		Node x = get(root, key, 0);
		if (x == null)
			return 0;

		return x.val;
	}


    /*.**************************************************************************/
    /*.PUT*/
    /*.**************************************************************************/
	
	public void put(String key) {
		root = put(root, key, 0);
	}

	private Node put(Node x, String key, int d) {
		if (x == null)
			x = new Node(key);
		if (d == key.length()) 
		{
			x.val++;	//Increment Found Index
			return x;
		}

		char c = key.charAt(d); // Use dth key char to identify subtrie.

		x.next[c] = put(x.next[c], key, d + 1);

		return x;
	}

    /*.**************************************************************************/
    /*.NODES*/
    /*.**************************************************************************/
	
    public Iterable<Node> nodes()
    {
    	return getNodes();
    }
    
    private Iterable<Node> getNodes() {
        ArrayList<Node> results = new ArrayList<>();
        Node x = get(root, "", 0);
        collectNodes(x, results);
        return results;
    }

    private void collectNodes(Node x, ArrayList<Node> results) {
        if (x == null)
            return;
        if (x.val != 0)
            results.add(x);
        for (char c = 0; c < R; c++) {
            collectNodes(x.next[c], results);
        }
    }
	
    /*.**************************************************************************/
    /*.KEYS*/
    /*.**************************************************************************/

    public Iterable<String> keys() {
        return keysWithPrefix("");
    }
    


    /*.**************************************************************************/
    /*.KEYS WITH PREFIX OF*/
    /*.**************************************************************************/

    public Iterable<String> keysWithPrefix(String prefix) {
        ArrayList<String> results = new ArrayList<>();
        Node x = get(root, prefix, 0);
        collect(x, new StringBuilder(prefix), results);
        return results;
    }

    private void collect(Node x, StringBuilder prefix, ArrayList<String> results) {
        if (x == null)
            return;
        if (x.val != 0)
            results.add(prefix.toString());
        for (char c = 0; c < R; c++) {
            prefix.append(c);
            collect(x.next[c], prefix, results);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }

    /*.**************************************************************************/
    /*.KEYS THAT MATCH*/
    /*.**************************************************************************/

    public Iterable<String> keysThatMatch(String pattern) {
        ArrayList<String> results = new ArrayList<>();
        collect(root, new StringBuilder(), pattern, results);
        return results;
    }

    private void collect(Node x, StringBuilder prefix, String pattern, ArrayList<String> results) {
        if (x == null)
            return;

        int d = prefix.length();

        if (d == pattern.length() && x.val != null)
            results.add(prefix.toString());
        if (d == pattern.length())
            return;

        char c = pattern.charAt(d);
        if (c == '.') {
            for (char ch = 0; ch < R; ch++) {
                prefix.append(ch);
                collect(x.next[ch], prefix, pattern, results);
                prefix.deleteCharAt(prefix.length() - 1);
            }
        } else {
            prefix.append(c);
            collect(x.next[c], prefix, pattern, results);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }

    /*.**************************************************************************/
    /*.LONGEST PREFIX OF*/
    /*.**************************************************************************/

    public String longestPrefixOf(String query) {
        int length = longestPrefixOf(root, query, 0, 0);
        return query.substring(0, length);
    }

    private int longestPrefixOf(Node x, String query, int d, int length) {
        if (x == null) return length;
        if (x.val != null) length = d;
        if (d == query.length()) return length;
        char c = query.charAt(d);
        return longestPrefixOf(x.next[c], query, d + 1, length);
    }

    /*.**************************************************************************/
    /*.DELETE*/
    /*.**************************************************************************/

    public void delete(String key) {
        root = delete(root, key, 0);
    }

    private Node delete(Node x, String key, int d) {
        if (x == null)
            return null;
        if (d == key.length()) {
            if (x.val != null)
                N--;
            x.val = null;
        } else {
            char c = key.charAt(d);
            x.next[c] = delete(x.next[c], key, d + 1);
        }

        //Remove subtrie rooted at x if it is completely empty
        if (x.val != null) return x;
        for (int c = 0; c < R; c++)
            if (x.next[c] != null)
                return x;
        return null;
    }
    
    
    // TEST CODE
    
	public static void main(String [] args)
	{
		Trie t = new Trie();
		
		t.put("zz");
		t.put("zz");
		t.put("zz");
		t.put("zz");
		t.put("zz");
		t.put("zz");
		t.put("zz");
		t.put("zz");
		t.put("zz");
		t.put("er");
		t.put("ed");
		t.put("ev");
		t.put("ev");
		t.put("ev");
		t.put("ev");
		t.put("ev");
		t.put("ev");
		t.put("et");
		t.put("et");
		t.put("et");
		t.put("a");


		System.out.println(t.getCount("zz"));
		
		Iterable<Node> nodes = t.nodes();
		for(Node n : nodes)
		{
			System.out.println(n.val);
			System.out.println(n.key);
		}
		System.out.println(t.keys());
		
	}
}

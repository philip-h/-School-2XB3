package datastructs;

import java.util.ArrayList;

/**
 * 
 * Added By Theo on 08/05/15
 * 
 */
public class Trie
{
	private static final int R = 256; // Alphabet.. for now

	private Node root; // root of trie
	private int N; // number of keys in trie

	/*
	 * .*************************************************************************
	 */
	/* .SIZE OPERATIONS */
	/*
	 * .*************************************************************************
	 */

	public int size()
	{
		return N;
	}

	public boolean isEmpty()
	{
		return size() == 0;
	}

	/*
	 * .*************************************************************************
	 */
	/* .CONTAINS */
	/*
	 * .*************************************************************************
	 */

	public boolean contains(String key)
	{
		return get(key) != null;
	}

	/*
	 * .*************************************************************************
	 */
	/* .GET */
	/*
	 * .*************************************************************************
	 */

	public Integer get(String key)
	{
		Node x = get(root, key, 0);
		if (x == null)
			return null;
		return x.getValue();
	}

	private Node get(Node x, String key, int d)
	{
		if (x == null)
			return null;
		if (d == key.length())
			return x;
		char c = key.charAt(d);
		return get(x.getNextNodes()[c], key, d + 1);
	}

	public int getCount(String key)
	{
		Node x = get(root, key, 0);
		if (x == null)
			return 0;

		return x.getValue();
	}

	/* ************************************************************************* */
	/* PUT */
	/* ************************************************************************* */

	public void put(String key)
	{
		root = put(root, key, 0);
	}

	private Node put(Node x, String key, int d)
	{
		if (x == null)
			x = new Node(key);
		if (d == key.length())
		{
			x.incrementValue(); // Increment Found Index
			return x;
		}

		char c = key.charAt(d); // Use dth key char to identify subtrie.

		x.getNextNodes()[c] = put(x.getNextNodes()[c], key, d + 1);

		return x;
	}

	/*
	 * .*************************************************************************
	 */
	/* .NODES */
	/*
	 * .*************************************************************************
	 */

	public ArrayList<Node> nodes()
	{
		return getNodes("");
	}

	private ArrayList<Node> getNodes(String prefix)
	{
		ArrayList<Node> results = new ArrayList<>();
		Node x = get(root, "", 0);
		collectNodes(x, results, new StringBuilder(prefix));
		return results;
	}

	private void collectNodes(Node x, ArrayList<Node> results,
			StringBuilder prefix)
	{
		if (x == null)
			return;
		if (x.getValue() != 0)
			results.add(new Node(prefix.toString(), x.getValue()));
		for (char c = 0; c < R; c++)
		{
			prefix.append(c);
			collectNodes(x.getNextNodes()[c], results, prefix);
			prefix.deleteCharAt(prefix.length() - 1);
		}
	}

	/*
	 * .*************************************************************************
	 */
	/* .getKeyS */
	/*
	 * .*************************************************************************
	 */

	public Iterable<String> keys()
	{
		return keysWithPrefix("");
	}

	/*
	 * .*************************************************************************
	 */
	/* .getKeyS WITH PREFIX OF */
	/*
	 * .*************************************************************************
	 */

	public Iterable<String> keysWithPrefix(String prefix)
	{
		ArrayList<String> results = new ArrayList<>();
		Node x = get(root, prefix, 0);
		collect(x, new StringBuilder(prefix), results);
		return results;
	}

	private void collect(Node x, StringBuilder prefix, ArrayList<String> results)
	{
		if (x == null)
			return;
		if (x.getValue() != 0)
			results.add(prefix.toString());
		for (char c = 0; c < R; c++)
		{
			prefix.append(c);
			collect(x.getNextNodes()[c], prefix, results);
			prefix.deleteCharAt(prefix.length() - 1);
		}
	}

	/*
	 * .*************************************************************************
	 */
	/* .getKeyS THAT MATCH */
	/*
	 * .*************************************************************************
	 */

	public Iterable<String> keysThatMatch(String pattern)
	{
		ArrayList<String> results = new ArrayList<>();
		collect(root, new StringBuilder(), pattern, results);
		return results;
	}

	private void collect(Node x, StringBuilder prefix, String pattern,
			ArrayList<String> results)
	{
		if (x == null)
			return;

		int d = prefix.length();

		if (d == pattern.length() && x.getValue() != null)
			results.add(prefix.toString());
		if (d == pattern.length())
			return;

		char c = pattern.charAt(d);
		if (c == '.')
		{
			for (char ch = 0; ch < R; ch++)
			{
				prefix.append(ch);
				collect(x.getNextNodes()[ch], prefix, pattern, results);
				prefix.deleteCharAt(prefix.length() - 1);
			}
		} else
		{
			prefix.append(c);
			collect(x.getNextNodes()[c], prefix, pattern, results);
			prefix.deleteCharAt(prefix.length() - 1);
		}
	}

	/*
	 * .*************************************************************************
	 */
	/* .LONGEST PREFIX OF */
	/*
	 * .*************************************************************************
	 */

	public String longestPrefixOf(String query)
	{
		int length = longestPrefixOf(root, query, 0, 0);
		return query.substring(0, length);
	}

	private int longestPrefixOf(Node x, String query, int d, int length)
	{
		if (x == null)
			return length;
		if (x.getValue() != null)
			length = d;
		if (d == query.length())
			return length;
		char c = query.charAt(d);
		return longestPrefixOf(x.getNextNodes()[c], query, d + 1, length);
	}

	/*
	 * .*************************************************************************
	 */
	/* .DELETE */
	/*
	 * .*************************************************************************
	 */

	public void delete(String key)
	{
		root = delete(root, key, 0);
	}

	private Node delete(Node x, String key, int d)
	{
		if (x == null)
			return null;
		if (d == key.length())
		{
			if (x.getValue() != null)
				N--;
			x.setValue(null);;
		} else
		{
			char c = key.charAt(d);
			x.getNextNodes()[c] = delete(x.getNextNodes()[c], key, d + 1);
		}

		// Remove subtrie rooted at x if it is completely empty
		if (x.getValue() != null)
			return x;
		for (int c = 0; c < R; c++)
			if (x.getNextNodes()[c] != null)
				return x;
		return null;
	}

	public static Trie toTrie(String inString)
	{
		Trie t = new Trie();
		// The current item and next items
		char current = '\0';
		char next = '\0';
		boolean countLast = false;
		try
		{
			// while the input string still has elements
			while (!(inString.equals(null)))
			{
				try
				{
					// get the current first item in the trie
					current = inString.charAt(0);
					// get the second item in the trie
					next = inString.charAt(1);
					// add the first item AND the first + second pair
					t.put(current + "");
					t.put(current + "" + next);
				} catch (StringIndexOutOfBoundsException e)
				{
					// If we got one string exception already this means
					// that the current is now on the last digit that is yet to
					// be added
					if (countLast)
					{
						t.put(current + "");
					} else
						// Otherwise we set it to true so we can add it next
						// time
						countLast = true;
				}
				// take the first item off the string
				inString = inString.substring(1);

			}
		} catch (StringIndexOutOfBoundsException e)
		{

		}
		// return the Trie
		return t;
	}

	// public static void main(String [] args){
	// String test = "aabaab";
	// Trie t = Trie.toTrie(test);
	//
	//
	// ArrayList <Node> nArray = t.nodes();
	// for(Node n : nArray)
	// System.out.printf("%s, %d\n", n.getKey, n.getValue());
	// }
}

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


	/*
	 * .*************************************************************************
	 */
	/* .CONTAINS */
	/*
	 * .*************************************************************************
	 */

	public boolean contains(String key)
	{
		return getCount(key) != null;
	}

	/*
	 * .*************************************************************************
	 */
	/* .GET */
	/*
	 * .*************************************************************************
	 */
	public Integer getCount(String key)
	{
		Node x = get(root, key, 0);
		if (x == null)
			return 0;

		return x.getValue();
	}
	
/**
 * 
 * @param x Root Node
 * @param key String searched for.
 * @param d Depth of search
 * @return
 */
	private Node get(Node x, String key, int d)
	{
		if (x == null)
			return null;
		if (d == key.length())
			return x;
		char c = key.charAt(d);
		return get(x.getNextNodes()[c], key, d + 1);
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
		ArrayList<Node> results = new ArrayList<>();
		Node x = get(root, "", 0);
		collectNodes(x, results, new StringBuilder(""));
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
					if (current == '\n' || next == '\n'){
					//	continue;
					}
					// add the first item AND the first + second pair
					t.put(current + "");
					t.put(current + "" + next);
				} catch (StringIndexOutOfBoundsException e)
				{
					// If we got one string exception already this means
					// that the current is now on the last digit that is yet to
					// be added
						
						t.put(current + "");
						break;
						// Otherwise we set it to true so we can add it next
						// time
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


}

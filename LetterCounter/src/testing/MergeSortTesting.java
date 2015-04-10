package testing;

import datastructs.MergeSort;
import datastructs.Node;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class MergeSortTesting
{
	Node [] nodes;
	
	
	@Before
	public void setUp()
	{
		nodes = new Node [] {new Node("a", 3), new Node("V", 69), new Node("t", 10)};
	}
	
	@Test
	public void test()
	{
		assertTrue(!isSorted(nodes));	// Check if Not Sorted
		MergeSort.sort(nodes);			// Sort Array
		assertTrue(isSorted(nodes));	// Check if Sorted
		
	}

	private boolean isSorted(Node [] nArray)
	{
		for(int i = 0; i < nArray.length - 1; i++)
		{
			if(nArray[i].getValue() > nArray[i + 1].getValue())
				return false;
		}
		
		return true;
	}
}

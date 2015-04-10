package testing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import datastructs.Trie;

public class TrieTesting {

	Trie t;	//Trie Object
	char[] alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();	// Alphabet Array
	
	@Before
	public void setUp()
	{
		t = new Trie();
	}
	
	@Test
	public void testEmpty() 
	{
		for(int i = 0; i < alphabet.length; i++)
		{
			assertTrue(!t.contains(Character.toString(alphabet[i])));
		}
	}
	
	@Test
	public void testCountSingles()
	{
		// Add Characters 10 times.
		for(int q = 1; q < 10; q++)
		{
			for(int i = 0; i < alphabet.length; i++)
			{
				t.put(Character.toString(alphabet[i]));
			}
			
			for(int i = 0; i < alphabet.length; i++)
			{
				assertEquals((int)t.getCount(Character.toString(alphabet[i])), q);
			}
		}
	}
	
	@Test
	public void testCountDoubles()
	{
		//Add Double Characters 10 Times.
		for(int q = 1; q < 10; q++)
		{
			for(int i = 0; i < alphabet.length; i++)
			{
				t.put(Character.toString(alphabet[i]) + "D");
			}
			
			for(int i = 0; i < alphabet.length; i++)
			{
				assertEquals((int)t.getCount(Character.toString(alphabet[i]) + "D"), q);
			}
		}
	}

}

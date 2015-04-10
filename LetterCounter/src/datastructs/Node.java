package datastructs;


public class Node implements Comparable<Node>
{
	
	//Initialize Variables
	private static final int R = 256; //Max
	private String key;		//String Name
	private Integer val;	//Node Entry Coust
    private Node[] next;	//Next Nodes
    
    // create a node with a predetermied key, and val = 0
    public Node(String key)
    {
        val = 0;
        this.key = key;
        next = new Node[R];
    }
    // create a node with a predefined value an key
    public Node(String key, Integer val)
    {
        this.val = val;
        this.key = key;
        next = new Node[R];
    }
    // compare node 
	@Override
	public int compareTo(Node that) 
	{
		if(this.val < (that).val)
			return -1;
		else if(this.val == (that).val)
			return 0;
		else return 1;
	}
	
	public String getKey()
	{
		return key;
	}
	
	public Integer getValue()
	{
		return val;
	}
	
	public Node[] getNextNodes()
	{
		return next;
	}
	
	public void incrementValue()
	{
		val++;
	}
	
	public void setValue(Integer v)
	{
		val = v;
	}
}

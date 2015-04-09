package datastructs;


public class Node implements Comparable<Node>{
	private static final int R = 256; 
	String key;
	Integer val;
    Node[] next;
    public Node(String key)
    {
        val = 0;
        this.key = key;
        next = new Node[R];
    }
	@Override
	public int compareTo(Node that) {
		if(this.val < (that).val)
			return -1;
		else if(this.val == (that).val)
			return 0;
		else return 1;
	}
	
}

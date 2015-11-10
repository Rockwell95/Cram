
public class Node {

	public int maxPoint = 0;
	public Node[] child;
	public Node parent;
	
	private int childCount;
	
	public String assignedMove;
	
	public Node() {
		// Constructor for root.
		childCount = 0;
		child = new Node[5];
		assignedMove = null;
	}
	
	public Node(String move) {
		// Initializes children for node
		//Constructor for children
		childCount = 0;
		child = new Node[5];
		assignedMove = move;
	}
	
	public void createChild(String move)
	{
		child[childCount] = new Node(move);
		childCount++;
	}
	
	public boolean isTop()
	{
		boolean par = false;
		if (assignedMove.equals(null))
		{
			par = true;
		}
		return par;
	}


}

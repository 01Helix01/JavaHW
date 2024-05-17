import java.util.*;
import java.lang.*;
import java.io.*;
class MyBST {

	/*Analysis:
	 * In this program, we need to find the distance between
	 * two given values in a given Binary Tree.
	 * To do this, we will have to find the least common ancestor the two share.
	 * From this ancestor, we will be able to use it to easily find distance to our points
	 * By taking the distance from our left value to the ancestor and adding it to the
	 * right's distance to the ancestor, the problem will be solved.
	 */ 
	
	/* Design:
	 * When we first run getDistance, we must make sure b > a so that our LCA function doesn't run into issues
	 * Quickly check if the two values are the same, because if so we can simply return 0
	 * Find the Least Common Ancestor using recursion until the nodes are present on opposite sides
	 * Back in getDistance, call rootToNode and passing the LCA we found to it
	 * rootToNode calls itself until the node element is equal to the initial value given
	 * add the rootToNode for a to the rootToNode for b and we have found the distance
	 */
	
	TreeNode root;

	// return distance from the given node to root
	public int rootToNode(TreeNode node, int i)
	{
		// element has been found
		if(node.element == i)
			return 0;
		
		else if(node.element > i)
		{
			// recursively call left side - add one for each call
			return 1 + rootToNode(node.left, i);
		}
		
		// recursively call right side - add one for each call
		return 1 + rootToNode(node.right, i);
	}
	
	// Finds "Least Common Ancestor" which is the point where the two TreeNodes, a and b, are
	// present in the same part of the tree
	public TreeNode findLCA(TreeNode node, int a, int b)
	{
		// empty tree
		if(root == null)
		{
			return null;
		}
		
		// left subtree where both elements present
		if(node.element > a && node.element > b)
			return findLCA(node.left, a, b);
		
		// right subtree where both elements present
		if(node.element < a && node.element < b)
			return findLCA(node.right, a, b);
		
		// both nodes present on opposite sides - found LCA
		if(node.element >= a && node.element <= b)
			return node;
		
		// Ancestor not found (?)
		return null;
	}
	
	
    // find the distance between two nodes with given keys a and b
    public int getDistance(int a, int b){
        //Write your code here and you can add more methods
    	
    	// make sure b < a - if not, swap the two before proceeding
    	if(a > b)
    	{
    		int i = a;
    		a = b;
    		b = i;
    	}
    	
    	// make sure a isn't the same node as b before proceeding
    	else if (a == b)
    		return 0;
    	
    	TreeNode lca = findLCA(root, a, b);
    	return rootToNode(lca, a) + rootToNode(lca, b);
    }
    
    
    
    
 //---------------DO NOT CHANGE THE GIVEM METHODS---------------------------------   
   // insert method to add elements to BST 
		public void insert(int key){
		TreeNode newNode = new TreeNode(key);
		if(root == null){
			root = newNode;
		}else{
			TreeNode current = root;
			TreeNode parent;

			while(true){
				parent = current;
				if(key ==  current.element) return; //no duplicate
				else if(key < current.element){
					current = current.left;
					if(current == null){
						parent.left = newNode;
						return;
					}
				}else{
					current = current.right;
					if(current == null){
						parent.right = newNode;
						return;
					}
				}
			}
		}

	}
    //Print the elements of the BST level by level staring from root
    public void print(){
		Queue q = new LinkedList<TreeNode>();
		if(root!= null)
			q.add(root);
		while(!q.isEmpty()){
			TreeNode current = (TreeNode) q.remove();
			System.out.print(current.element + " ");
			if(current.left != null) 
				q.add(current.left);
			if(current.right != null) 
				q.add(current.right);
		}
	}

    
	private class TreeNode {
		
		int element;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(){}
		public TreeNode(int e){
			this.element = e;
		}

	}
}


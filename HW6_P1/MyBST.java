import java.util.*;
import java.lang.*;
import java.io.*;

//---------------DO NOT CHANGE ANYTHING IN THIS FILE---------------------------------

class MyBST {

	TreeNode root;

   // insert method, to add elements to MyBST 
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
    //Print the elements of the MyBST BFS
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


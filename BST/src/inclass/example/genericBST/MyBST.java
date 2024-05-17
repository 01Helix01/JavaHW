package inclass.example.genericBST;
import java.util.LinkedList;
import java.util.Queue;

public class MyBST<E extends Comparable<E>>{

	private MyTreeNode<E> root;
	
	public boolean isEmpty() {
		return (root == null);
	}
	
	public boolean insert(E element) {
		
		MyTreeNode<E> newTreeNode = new MyTreeNode<E>(element);
		
		if(!isEmpty()) {
			
			MyTreeNode<E> current = root;
			MyTreeNode<E> parent = root;
			
			while(current != null) {
				if(element.compareTo(current.element) < 0) {
					parent = current;
					current = current.left;
				}else if(element.compareTo(current.element) > 0) {
					parent = current;
					current = current.right;
				}else return false; // duplication
			}
			
			if(element.compareTo(parent.element) < 0) {
				parent.left = newTreeNode;
			}else {
				parent.right = newTreeNode;
			}
			
			
			
		}else { // the first element in tree
			root = newTreeNode;
		}
		
		return true;
	}
	
	
	public boolean search(E key) {
		MyTreeNode<E> current = root;
		while(current != null) {
			if(key.compareTo(current.element) < 0) {
				current = current.left;
			}else if(key.compareTo(current.element) > 0) {
				current = current.right;
			}else
				return true; // key found
		}
		return false; // key not found
	}
	
	public void print() {
		//dfs();
		bfs();
	}
	
	private void dfs() {//inorder - recursive
		dfs(root);
	}
	
	private void dfs(MyTreeNode<E> current) {
		
		if(current != null) {
			dfs(current.left);
			System.out.print(current.element + " ");
			dfs(current.right);
		}
		
	}
	
	public boolean delete(E element) {
		
		if(!isEmpty()) {
			MyTreeNode<E> current = root;
			MyTreeNode<E> parent = root;
			
			while(current != null) {
				if(element.compareTo(current.element) < 0) {
					parent = current;
					current = current.left;
				}else if(element.compareTo(current.element) > 0) {
					parent = current;
					current = current.right;
				}else break;
			}
			
			if(current.left == null) { //case 1
				if(current == root)
					root = current.right;
				else {
					if(element.compareTo(parent.element) < 0) {
						parent.left = current.right;
					}else {
						parent.right = current.right;
					}
				}
			} //case 1 end
			else { //case 2
				MyTreeNode<E> parentOfRightMost = current;
				MyTreeNode<E> rightMost = current.left;
				
				while(rightMost.right != null) {
					parentOfRightMost = rightMost;
					rightMost = rightMost.right;
				}
				
				current.element = rightMost.element;
				
				if(rightMost.equals(current.left)) {
					parentOfRightMost.left = rightMost.left;
				}else {
					parentOfRightMost.right = rightMost.left;
				}
			} //case 2 end
			return true;
		}
		return false;
	}
	
	private void bfs() {
		Queue<MyTreeNode<E>> q = new LinkedList<>();
		q.add(root);
		
		while(!q.isEmpty()) {
			MyTreeNode<E> temp = q.poll();
			System.out.print(temp.element + " ");
			
			if(temp.left != null) q.add(temp.left);
			if(temp.right != null)q.add(temp.right);
		}
		
		System.out.println("Tree is empty");
	}
}



class MyTreeNode<E>{
	
	E element;
	MyTreeNode<E> left;
	MyTreeNode<E> right;
	
	MyTreeNode(E element) {
		this.element = element;
	}
	
}
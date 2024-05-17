package inclass.example.genericBST;

public class TestMyBST {

	public static void main(String[] args) {
		
		
//		MyBST<Integer> bst = new MyBST<Integer>();
//		bst.insert(60);
//		bst.insert(55);
//		bst.insert(100);
//		bst.insert(45);
//		bst.insert(57);
//		bst.insert(67);
//		bst.insert(107);
//		bst.insert(101);
//		bst.insert(59);
//		
//		System.out.println(bst.insert(107));
//		
//		System.out.println(bst.search(107));
//		System.out.println(bst.search(108));
//		
//		bst.print();
		
		MyBST<Integer> bst = new MyBST<Integer>();
		bst.insert(20);
		bst.insert(10);
		bst.insert(40);
		bst.insert(16);
		bst.insert(30);
		bst.insert(80);
		bst.insert(14);
		bst.insert(27);
		bst.insert(50);
		
		bst.delete(20);
		bst.delete(16);
		bst.delete(14);
		bst.delete(10);
		
		bst.print();
	}
}

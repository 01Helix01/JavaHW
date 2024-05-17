public class AVLTree<Book extends Comparable<Book>> extends BST<Book> {
  /** Create a default AVL tree */
  public AVLTree() {
  }

  /** Create an AVL tree from an array of objects */
  public AVLTree(Book[] objects) {
    super(objects);
  }

  @Override /** Override createNewNode to create an AVLTreeNode */
  protected AVLTreeNode<Book> createNewNode(Book o) {
    return new AVLTreeNode<Book>(o);
  }

  @Override /** Insert an element and rebalance if necessary */
  public boolean insert(Book o) {
    boolean successful = super.insert(o);
    if (!successful)
      return false; // o is already in the tree
    else {
      balancePath(o); // Balance from o to the root if necessary
    }

    return true; // o is inserted
  }

  /** Update the height of a specified node */
  private void updateHeight(AVLTreeNode<Book> node) {
    if (node.left == null && node.right == null) // node is a leaf
      node.height = 0;
    else if (node.left == null) // node has no left subtree
      node.height = 1 + ((AVLTreeNode<Book>)(node.right)).height;
    else if (node.right == null) // node has no right subtree
      node.height = 1 + ((AVLTreeNode<Book>)(node.left)).height;
    else
      node.height = 1 +
        Math.max(((AVLTreeNode<Book>)(node.right)).height,
        ((AVLTreeNode<Book>)(node.left)).height);
  }

  /** Balance the nodes in the path from the specified
   * node to the root if necessary
   */
  private void balancePath(Book o) {
    java.util.ArrayList<TreeNode<Book>> path = path(o);
    for (int i = path.size() - 1; i >= 0; i--) {
      AVLTreeNode<Book> A = (AVLTreeNode<Book>)(path.get(i));
      updateHeight(A);
      AVLTreeNode<Book> parentOfA = (A == root) ? null :
        (AVLTreeNode<Book>)(path.get(i - 1));

      switch (balanceFactor(A)) {
        case -2:
          if (balanceFactor((AVLTreeNode<Book>)A.left) <= 0) {
            balanceLL(A, parentOfA); // Perform LL rotation
            
            System.out.println("Imbalance condition occurred at inserting ISBN " + o.toString() + "; fixed in Right Rotation");
          }
          else {
            balanceLR(A, parentOfA); // Perform LR rotation
            
            System.out.println("Imbalance condition occurred at inserting ISBN " + o.toString() + "; fixed in Left-Right Rotation");
          }
          break;
        case +2:
          if (balanceFactor((AVLTreeNode<Book>)A.right) >= 0) {
            balanceRR(A, parentOfA); // Perform RR rotation
            
            System.out.println("Imbalance condition occurred at inserting ISBN " + o.toString() + "; fixed in Left Rotation");
          }
          else {
            balanceRL(A, parentOfA); // Perform RL rotation
            
            System.out.println("Imbalance condition occurred at inserting ISBN " + o.toString() + "; fixed in Right-Left Rotation");
          }
      }
    }
  }

  /** Return the balance factor of the node */
  private int balanceFactor(AVLTreeNode<Book> node) {
    if (node.right == null) // node has no right subtree
      return -node.height;
    else if (node.left == null) // node has no left subtree
      return +node.height;
    else
      return ((AVLTreeNode<Book>)node.right).height -
        ((AVLTreeNode<Book>)node.left).height;
  }

  /** Balance LL (see Figure 9.1) */
  private void balanceLL(TreeNode<Book> A, TreeNode<Book> parentOfA) {
    TreeNode<Book> B = A.left; // A is left-heavy and B is left-heavy

    if (A == root) {
      root = B;
    }
    else {
      if (parentOfA.left == A) {
        parentOfA.left = B;
      }
      else {
        parentOfA.right = B;
      }
    }

    A.left = B.right; // Make T2 the left subtree of A
    B.right = A; // Make A the left child of B
    updateHeight((AVLTreeNode<Book>)A);
    updateHeight((AVLTreeNode<Book>)B);
  }

  /** Balance LR (see Figure 9.1(c)) */
  private void balanceLR(TreeNode<Book> A, TreeNode<Book> parentOfA) {
    TreeNode<Book> B = A.left; // A is left-heavy
    TreeNode<Book> C = B.right; // B is right-heavy

    if (A == root) {
      root = C;
    }
    else {
      if (parentOfA.left == A) {
        parentOfA.left = C;
      }
      else {
        parentOfA.right = C;
      }
    }

    A.left = C.right; // Make T3 the left subtree of A
    B.right = C.left; // Make T2 the right subtree of B
    C.left = B;
    C.right = A;

    // Adjust heights
    updateHeight((AVLTreeNode<Book>)A);
    updateHeight((AVLTreeNode<Book>)B);
    updateHeight((AVLTreeNode<Book>)C);
  }

  /** Balance RR (see Figure 9.1(b)) */
  private void balanceRR(TreeNode<Book> A, TreeNode<Book> parentOfA) {
    TreeNode<Book> B = A.right; // A is right-heavy and B is right-heavy

    if (A == root) {
      root = B;
    }
    else {
      if (parentOfA.left == A) {
        parentOfA.left = B;
      }
      else {
        parentOfA.right = B;
      }
    }

    A.right = B.left; // Make T2 the right subtree of A
    B.left = A;
    updateHeight((AVLTreeNode<Book>)A);
    updateHeight((AVLTreeNode<Book>)B);
  }

  /** Balance RL (see Figure 9.1(d)) */
  private void balanceRL(TreeNode<Book> A, TreeNode<Book> parentOfA) {
    TreeNode<Book> B = A.right; // A is right-heavy
    TreeNode<Book> C = B.left; // B is left-heavy

    if (A == root) {
      root = C;
    }
    else {
      if (parentOfA.left == A) {
        parentOfA.left = C;
      }
      else {
        parentOfA.right = C;
      }
    }

    A.right = C.left; // Make T2 the right subtree of A
    B.left = C.right; // Make T3 the left subtree of B
    C.left = A;
    C.right = B;

    // Adjust heights
    updateHeight((AVLTreeNode<Book>)A);
    updateHeight((AVLTreeNode<Book>)B);
    updateHeight((AVLTreeNode<Book>)C);
  }

  @Override /** Delete an element from the binary tree.
   * Return true if the element is deleted successfully
   * Return false if the element is not in the tree */
  public boolean delete(Book element) {
    if (root == null)
      return false; // Element is not in the tree

    // Locate the node to be deleted and also locate its parent node
    TreeNode<Book> parent = null;
    TreeNode<Book> current = root;
    while (current != null) {
      if (element.compareTo(current.element) < 0) {
        parent = current;
        current = current.left;
      }
      else if (element.compareTo(current.element) > 0) {
        parent = current;
        current = current.right;
      }
      else
        break; // Element is in the tree pointed by current
    }

    if (current == null)
      return false; // Element is not in the tree

    // Case 1: current has no left children (See Figure 23.6)
    if (current.left == null) {
      // Connect the parent with the right child of the current node
      if (parent == null) {
        root = current.right;
      }
      else {
        if (element.compareTo(parent.element) < 0)
          parent.left = current.right;
        else
          parent.right = current.right;
      }

      // Balance the tree if necessary
      balancePath(parent.element);
    }
    else {
      // Case 2: The current node has a left child
      // Locate the rightmost node in the left subtree of
      // the current node and also its parent
      TreeNode<Book> parentOfRightMost = current;
      TreeNode<Book> rightMost = current.left;

      while (rightMost.right != null) {
        parentOfRightMost = rightMost;
        rightMost = rightMost.right; // Keep going to the right
      }

      // Replace the element in current by the element in rightMost
      current.element = rightMost.element;

      // Eliminate rightmost node
      if (parentOfRightMost.right == rightMost)
        parentOfRightMost.right = rightMost.left;
      else
        // Special case: parentOfRightMost is current
        parentOfRightMost.left = rightMost.left;

      // Balance the tree if necessary
      balancePath(parentOfRightMost.element);
    }

    size--;
    return true; // Element inserted
  }

  /** AVLTreeNode is TreeNode plus height */
  protected static class AVLTreeNode<Book extends Comparable<Book>>
      extends BST.TreeNode<Book> {
    int height = 0; // New data field

    public AVLTreeNode(Book o) {
      super(o);
    }
  }
}

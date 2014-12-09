package binaryTree;

/*
 * 二叉树-Tree类
 * 二叉排序树（Binary Sort Tree）又称二叉查找树（Binary Search Tree），亦称二叉搜索树.
 *  它或者是一棵空树;或者是具有下列性质的二叉树:
 * (1)若左子树不空，则左子树上所有结点的值均小于它的根结点的值;
 * (2)若右子树不空，则右子树上所有结点的值均大于它的根结点的值; 
 * (3)左、右子树也分别为二叉排序树;
 * 本例包括对二叉树的各种操作
 * insert:
 * find:
 * delete:
 * traverse:
 * 中序遍历()、先序()、后序()
 */
public class Tree {
	private Node root;

	public Tree() {
		root = null;
	}

	// 由于是一棵二叉排序树,查找效率比较高O(logN)
	public Node find(int key) {
		Node current = root;
		while (current.iData != key) {
			if (key < current.iData) {
				current = current.leftChild;
			} else {
				current = current.rightChild;
			}

			if (current == null) {
				return null;
			}
		}
		return current;
	}

	// 插入关键字结点,本例以idata为关键字(key)
	public void insert(int idata, double ddata) {
		Node newNode = new Node();
		newNode.iData = idata;
		newNode.dData = ddata;
		// 原来是空树
		if (root == null) {
			root = newNode;
		}
		// 原来树非空
		else {
			Node current = root;
			Node parent;// 用于插入操作过程中保存父节点执行后续操作
			while (true) {
				parent = current;
				// 如果插入的关键字小于结点关键字就向左寻找插入位置
				if (idata < current.iData) {
					current = current.leftChild;
					if (current == null) {
						// current左边没有结点找打插入位置
						parent.leftChild = newNode;
						return;
					}
				} else {
					// 如果插入的关键字大于结点关键字就向右寻找插入位置
					current = current.rightChild;
					if (current == null) {
						// current左边没有结点找打插入位置
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}

	/*
	 * 删除一个关键字为key的结点,比较复杂 要分三种情况 被删除的点没有子节点 被删除的点有一个子节点 被删除的点有两个子节点
	 */
	public boolean delete(int key) {
		Node current = root;
		Node parent = root;
		boolean isLeftChild = true;// 标记是由哪个分支到达key(要删除)结点的
		while (current.iData != key) {
			parent = current;
			if (key < current.iData) {
				isLeftChild = true;
				current = current.leftChild;
			} else {
				isLeftChild = false;
				current = current.rightChild;
			}

			if (current == null)
				return false;
		}
		// 经过上述过程已经找到要删除的对象

		// 第1种情况，要删除的结点没有任何子节点
		if (current.leftChild == null && current.rightChild == null) {
			// 被删除的结点是根节点(每种情况删除时都要判断是否是根节点)
			if (current == root) {
				root = null;// 如果要删除的节点是根节点直接置空
			} else if (isLeftChild) {
				// 被删除的结点是上一个结点的左子结点
				parent.leftChild = null;
			} else {
				// 被删除的结点是上一个结点的右子结点
				parent.rightChild = null;
			}
		}

		// 第2种情况，要删除的结点只有一个(左)子节点
		else if (current.rightChild == null) {
			// 要删除的结点只有一个左子节点
			if (current == root)
				root = current.leftChild;// 如果要删除的节点是根节点
			else if (isLeftChild)
				parent.leftChild = current.leftChild;
			else
				parent.rightChild = current.leftChild;
		}

		// 第2种情况，要删除的结点只有一个(右)子节点
		else if (current.leftChild == null) {
			// 要删除的结点只有一个右子节点
			if (current == root)
				root = current.leftChild;// 如果要删除的节点是根节点
			else if (isLeftChild)
				parent.leftChild = current.rightChild;
			else
				parent.rightChild = current.rightChild;
		}

		// 第3种情况，要删除的节点(current)有两个子节点(左右结点都存在)
		else {
			// 通过getSuccessor寻找要删除的节点(current)的后继结点
			// (即顶替删除结点位置的那个结点,此过程可以看成寻找右子树的最小值)
			Node successor = getSuccessor(current);

			// 把current结点的父节点连接到successor上
			if (current == root)
				root = successor;
			else if (isLeftChild) {
				//后继是被删除节点的右子节点的左子孙结点
				parent.leftChild = successor;
			} else {
				//后继是被删除节点的右子节点
				parent.rightChild = successor;
			}

			// 把successor连接到current结点的左子节点上
			successor.leftChild = current.leftChild;
		}

		return true;
	}

	/*
	 * 被删除的点有两个子节点的情况下 寻找后继结点顶替被删除结点的方法 delNode表示要删除的结点
	 */
	private Node getSuccessor(Node delNode) {
		Node successorParent = delNode;
		Node successor = delNode;
		Node current = delNode.rightChild;
		while (current != null) {
			successorParent = successor;
			successor = current;
			current = current.leftChild;
		}

		// 如果找到的后继结点不是要删除的结点的右子节点
		if (successor != delNode.rightChild) {
			successorParent.leftChild = successor.rightChild;
			successor.rightChild = delNode.rightChild;
		}

		return successor;
	}

	// 遍历树的方法
	public void traverse(int traversType) {
		switch (traversType) {
		case 1:
			System.out.println("\nPreorder traversal:");
			preOrder(root);
			break;
		case 2:
			System.out.println("\nInorder traversal:");
			inOrder(root);
			break;
		case 3:
			System.out.println("\nPostorder traversal:");
			postOrder(root);
			break;

		default:
			System.out.println("输入错误,只有三种遍历类型！");
			break;
		}
		System.out.println("");
	}

	// 先序遍历,传入Node作为基值判断
	private void preOrder(Node localRoot) {
		if(localRoot!=null){
			System.out.println(localRoot.iData+" ");
			preOrder(localRoot.leftChild);
			preOrder(localRoot.rightChild);
		}
	}

	// 中序遍历,传入Node作为基值判断
	private void inOrder(Node localRoot) {
		if(localRoot!=null){
			inOrder(localRoot.leftChild);
			System.out.println(localRoot.iData+" ");
			inOrder(localRoot.rightChild);
		}
	}

	// 后序遍历,传入Node作为基值判断
	private void postOrder(Node localRoot) {
		if(localRoot!=null){
			postOrder(localRoot.leftChild);
			postOrder(localRoot.rightChild);
			System.out.println(localRoot.iData+" ");
		}
	}

	// 显示树
	public void displayTree() {

	}
}

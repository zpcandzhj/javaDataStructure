package java234tree;

/*
 *2-3-4树是一种多叉树(multiway tree)，它的每个节点最多有四个子节点和3个数据项，2-3-4 树在是阶为4 的B树。
 *B树是另一种平衡的多叉树，专门用在外部存储中来组织数据(通常是指磁盘驱动器)。B树中的节点可以有几时或几百个。
 *2-3-4树名字中的2、3、4的含义是指一个节点可能含有的子节点数。
 *有1个数据项的节点总是有2个子节点
 *有2个数据项的节点总是有3个子节点
 *有3个数据项的节点总是有4个子节点
 *简言之，非叶子节点的子节点数总是比它含有的数据项多1
 *在2-3-4树中不允许一个节点只有一个链接,这与传统的二叉树不同。
 *
 *在数学上,红-黑树与2-3-4树是同构的.2-3-4树中用节点的分裂保持平衡
 *红-黑树中保持平衡的方法是颜色交换和旋转(注意红黑树一定是棵二叉树,而2-3-4树没有这个限制)
 *在所有节点都满的情况下,2-3-4树的高度大概是红黑树的一半(不过他不可能是满的)
 *因此减少2-3-4树的高度可以使它的查找时间比红-黑树短
 *另一方面,每个节点的数据项就更多了,这会增加在节点中搜索数据项的时间(这是线性搜索)
 *可以通过增加数据项的数量减少树的高度
 *
 *通常认为红黑树的存储效率比2-3-4树高,2-3-4树空间存在浪费
 *Java中,存储对象的引用而不是对象本身,因此在2-3-4树和红黑树之间的这个差异并不重要(2-3-4树编程更容易些)
 *在不是用保存引用这种方法的编程语言中,2-3-4树和红-黑树之间存储差异可能就显著了
 */
public class Tree234 {
	private Node root = new Node();// 根节点

	// -----------寻找关键字项-----------
	public int find(long key) {
		Node curNode = root;
		int childNumber;
		while (true) {
			if ((childNumber = curNode.findItem(key)) != -1)
				return childNumber;
			else if (curNode.isLeaf())
				return -1;
			else
				curNode = getNextChild(curNode, key);
		}
	}

	// -----------insert a DataItem----------------
	public void insert(long dValue) {
		Node curNode = root;
		DataItem tempItem = new DataItem(dValue);
		// 注意到在2-3-4树中插入数据项总是发生在叶节点中
		while (true) {
			if (curNode.isFull())// 遇到满节点,就执行分裂(这和B树不同,B树和2-3树只有当新的数据项插入到一个满的节点时才需要分裂)
			{
				split(curNode);
				curNode = curNode.getParent();
				curNode = getNextChild(curNode, dValue);
			} else if (curNode.isLeaf()) {
				break;// 遇到叶节点，可以直接插入数据项
			} else {
				// 既不满，也不是叶节点，只能继续向下寻找
				curNode = getNextChild(curNode, dValue);
			}
		}
		// 执行插入操作
		curNode.insertItem(tempItem);
	}

	// -----------分裂一个节点-------------
	public void split(Node thisNode) {
		// 假设节点已满
		DataItem itemB, itemC;
		Node parent, child2, child3;
		int itemIndex;
		// 把分裂节点的最右两个数据项从该节点删除,暂存,分别放到新节点里和上升到父节点
		itemC = thisNode.removeItem();
		itemB = thisNode.removeItem();
		// 断开分裂节点的子节点(裂变节点的2、3子节点要重新接),到时候重新接上
		child2 = thisNode.disConnectChild(2);
		child3 = thisNode.disConnectChild(3);
		Node newRight = new Node();// 创建一个新的节点

		if (thisNode == root) {
			root = new Node();
			parent = root;
			root.connectChild(0, thisNode);
		} else {
			parent = thisNode.getParent();
		}

		// 处理父节点
		itemIndex = parent.insertItem(itemB);
		int n = parent.getNumItems();
		for (int j = n - 1; j > itemIndex; j--) {
			Node temp = parent.disConnectChild(j);
			parent.connectChild(j + 1, temp);
		}
		// 把新的右节点连到parent上
		parent.connectChild(itemIndex + 1, newRight);
		// 处理newRight
		newRight.insertItem(itemC);
		newRight.connectChild(0, child2);
		newRight.connectChild(1, child3);
	}

	// ------------用于在查找和插入关键字项的过程中寻找合适的节点----------------
	private Node getNextChild(Node theNode, long theValue) {
		// 假设节点不空、不满、不是叶子
		int j;
		int numItems = theNode.getNumItems();
		for (j = 0; j < numItems; j++) {
			if (theValue < theNode.getItem(j).dData)
				return theNode.getChild(j);
		}
		return theNode.getChild(j);// 返回最右边的节点
	}

	public void displayTree() {
		recDisplayTree(root, 0, 0);
	}

	//递归显示方法
	private void recDisplayTree(Node thisNode, int level, int childNumber) {
		System.out.print("level=" + level + " child=" + childNumber + " ");
		thisNode.displayNode(); // display this node

		// call ourselves for each child of this node
		int numItems = thisNode.getNumItems();
		for (int j = 0; j < numItems + 1; j++) {
			Node nextNode = thisNode.getChild(j);
			if (nextNode != null)
				recDisplayTree(nextNode, level + 1, j);
			else
				return;
		}
	}
}

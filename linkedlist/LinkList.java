package linkedlist;

/*
 * 单链表效率分析：
 * 在表头插入删除都很快,仅需要改变一两个引用值,所以花费O(1)时间
 * 平均起来,查找、删除关键字结点、在指定连接点后面插入都要搜索链表中一半的结点
 * 但是仍然比数组要快，因为链表中插入删除不需要移动任何东西
 * 另外一个优点就是链表需要多少内存就可以用多少，并且可以扩展到所有可用内存， 理论上链表是不会满的！
 */
public class LinkList {
	private Link first;

	public LinkList() {
		first = null;
	}

	//在表头插入结点
	public void insert(int i, double d) {
		Link node = new Link(i, d);
		node.next = first;
		first = node;
	}

	public boolean isEmpty() {
		return (first == null);
	}

	// 在表头删除结点,主程序中调用remove方法要判断链表是否为空
	public Link remove() {
		Link temp = first;
		first = first.next;
		return temp;
	}

	//查找关键词结点
	public Link find(int key) {
		Link current = first;
		while (current.iData != key) {
			if (current.next == null)
				return null;
			else
				current = current.next;
		}
		return current;
	}

	//删除关键词结点,分两步,第一步找到该结点,第二步'删除'该节点
	public Link delete(int key){
		Link current=first;//用来不断移动到结点
		Link previous=first;//用于删除结点,毕竟不是双向链表，知道前一个结点位置的唯一方法是拥有一个对它的引用
		//第一步：找
		while(current.iData!=key){
			if (current.next == null)
				return null;//没有找到关键词结点
			else{
				previous=current;
				current = current.next;}
		}
		//第二步：删
		if(current==first){
			//第一个点就是关键词结点，要调整头指针
			first=first.next;
		}else {
			previous.next=current.next;
		}
		//第三步：返回
		return current;
	}
	
	//遍历链表元素
	public void displayList() {
		System.out.println("List(first-->last):");
		Link current = first;
		while (current != null) {
			current.displayLink();
			current = current.next;
		}
	}
}

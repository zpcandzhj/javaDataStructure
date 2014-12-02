package firstlastlinkedlist;

/*
 * 实现一个双端链表
 */
public class FirstLastList {
	private Link first;// 指向表头的引用
	private Link last;// 指向表尾的引用

	public FirstLastList() {
		first = null;
		last = null;
	}

	public boolean isEmpty() {
		return first == null;
	}

	// 从双端链表的表头开始插入
	public void insertFirst(long key) {
		Link newLink = new Link(key);
		// 如果是空链表的话要特别指出尾指针也要指向初始节点
		if (isEmpty()) {
			last = newLink;
		}
		newLink.next = first;
		first = newLink;
	}

	// 从双端链表的表尾开始插入
	public void insertLast(long key) {
		Link newLink = new Link(key);
		// 如果是空链表的话要特别指出头指针也要指向初始节点
		if (isEmpty()) {
			first = newLink;
		} else {
			last.next = newLink;
		}
		last = newLink;
	}

	// 从表头删除元素
	public Link deleteFirst() {
		Link temp = first;
		// 如果只有一个元素,那么要把尾指针处理好,即指向null
		if (isEmpty())
			last = null;
		first = first.next;
		return temp;
	}

	// 无法从表尾删除元素
	/*
	 * public Link deleteLast(){
	 * 
	 * }
	 */
	public void displayList() {
		System.out.println("List(first-->last):");
		Link current = first;
		while (current != null) {
			current.display();
			current = current.next;
		}
	}
}

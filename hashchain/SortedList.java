package hashchain;

/*
 * 哈希表中存储数据项的有序链表
 */
public class SortedList {

	private Link first;

	public SortedList() {
		first = null;
	}
	//----------------------插入关键字项-------------------
	public void insert(Link DataItem) {
		int key = DataItem.getKey();// 用来在链表内部寻找插入位置
		Link current = first;
		Link previous = null;
		while (current != null && current.getKey() < key) {// val在表尾的时候会遇到current=null
			previous = current;
			current = current.next;
		}
		// 如果是空表或者插入元素在表头
		if (previous == null) {
			first = DataItem;
		} else {
			previous.next = DataItem;
		}
		DataItem.next = current;
	}

	// -------删除关键词结点,分两步,第一步找到该结点,第二步'删除'该节点------
	public boolean delete(int key) {
		Link previous = null;
		Link current = first;
		while (current != null && current.getKey() != key) {
			if (current.next == null)
				return false;// 没有找到关键词结点
			else {
				previous = current;
				current = current.next;
			}
		}
		if (previous == null) {
			first = first.next;// 第一个元素就是需要的
		} else {
			previous.next = current.next;
		}
		return true;
	}

	//------------------查找关键字项----------------
	public Link find(int key){
		Link current=first;
		//由于是有序的链表,current.getKey()<=key时就不要找了,节省了时间
		while(current!=null&&current.getKey()<=key){
			if(current.getKey()==key)
				return current;
			current=current.next;
		}
		return null;
	}
	
	
	public void displayList() {
		System.out.print("List(first-->last):");
		Link current = first;
		while (current != null) {
			current.display();
			current = current.next;
		}
		System.out.println("");
	}
}

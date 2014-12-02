package doublyLinkedList;

/*
 * 双向链表的实现
 */
public class DoublyLinkedList {
	private Link first;
	private Link last;// 采用双端链表的形式

	public DoublyLinkedList() {
		first = null;
		last = null;
	}

	public boolean isEmpty() {
		return first == null;
	}

	//从表头插入元素
	public void insertFirst(long dd) {
		Link newLink=new Link(dd);
		if(isEmpty()){
			last=newLink;//原来是空表的情况,要给last指定一个归属
		}else{
			first.previous=newLink;
		}
		newLink.next=first;
		first=newLink;
	}

	//从表尾插入元素
	public void insertLast(long dd) {
		Link newLink=new Link(dd);
		if(isEmpty()){
			first=newLink;//原来是空表的情况,要给first指定一个归属
		}else{
			newLink.previous=last;
			last.next=newLink;
		}
		last=newLink;
	}

	// 在指定节点后面插入元素
	public boolean insertAfter(long key, long dd) {
		Link current=first;
		while(current.dData!=key){
			current=current.next;
			if(current==null)return false;//找到表尾都没找到指定结点
		}
		Link newLink=new Link(dd);
		if(current==last){
			//指定结点是尾结点,要调整last指向
			newLink.next=null;
			last=newLink;
		}else{
			newLink.next=current.next;
			current.next.previous=newLink;
		}
		newLink.previous=current;
		current.next=newLink;
		return true;
	}

	// 从表头删除
	public Link deleteFirst() {
		Link temp=first;
		//如果只有一个元素,删除结点后要调整last
		if(first.next==null){
			last=null;
		}else{
			first.next.previous=null;//原表不止一个元素,删除操作后要使第一个元素的previous=null
		}
		first=first.next;
		return temp;
	}

	// 从表尾删除
	public Link deleteLast() {
		Link temp=last;
		//如果只有一个元素,删除结点后要调整first
		if(first.next==null){
			first=null;
		}else{
			last.previous.next=null;
		}
		last=last.previous;
		return temp;
	}

	// 删除关键字节点
	public Link deleteKey(long key) {
		Link current=first;
		while(current.dData!=key){
			current=current.next;
			if(current==null){
				return null;
			}
		}
		
		//删除的正好是第一个结点
		if(current==first){
			first=current.next;
		}else{
			current.previous.next=current.next;
		}
		
		//删除的是最后一个结点
		if(current==last){
			last=current.previous;
		}else{
			current.next.previous=current.previous;
		}
		
		return current;
	}

	// 从表头向表尾遍历元素
	public void displayForward() {
		System.out.println("List(first-->last)：");
		Link current=first;
		while(current!=null){
			current.display();
			current=current.next;
		}
		System.out.println("");
	}

	// 从表尾向表头遍历元素
	public void displayBackward() {
		System.out.println("List(last-->first)");
		Link current=last;
		while(current!=null){
			current.display();
			current=current.previous;
		}
		System.out.println("");
	}
}

package doublyLinkedList;
/*
 * 双向链表的结点构成
 */
public class Link {

	public long dData;
	public Link next;
	public Link previous;
	public Link(long d){
		dData=d;
		next=null;
	}
	
	public void display(){
		System.out.print(" "+dData);
	}
}

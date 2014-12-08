package sortedList;

/*
 * 实现一个有序链表,链表结点类
 */
public class Link {
	public long dData;
	public Link next;
	public Link(long d){
		dData=d;
		next=null;
	}
	
	public void display(){
		System.out.print(" "+dData);
	}
}
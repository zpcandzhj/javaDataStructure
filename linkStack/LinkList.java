package linkStack;
/*
 * 为用链表实现栈这种抽象的数据结构而做准备
 */
public class LinkList {
	private Link first;
	public LinkList(){
		first=null;
	}
	
	public boolean isEmpty(){
		return first==null;
	}
	
	//为入栈操作铺垫
	public void insertFirst(long dd){
		Link temp=new Link(dd);
		temp.next=first;
		first=temp;
	}
	
	//为出栈操作铺垫
	public long deleteFirst(){
		Link temp=first;
		long value=temp.dData;
		first=first.next;
		return value;
	}
	
	//为遍历栈的内容铺垫
	public void displayList(){
		Link current=first;
		while(current!=null){
			current.display();
			current=current.next;
		}
		System.out.println(" ");
	}
}

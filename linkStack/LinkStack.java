package linkStack;
/*
 * 用链表实现的栈结构
 */
public class LinkStack {
	private LinkList theList;
	public LinkStack(){
		theList=new LinkList();
	}
	
	public void push(long j){
		theList.insertFirst(j);
	}
	
	public long pop(){
		return theList.deleteFirst();
	}
	
	public boolean isEmpty(){
		return theList.isEmpty();
	}
	
	public void displayStack(){
		System.out.println("Stack(top-->bottom):");
		theList.displayList();
	}
}

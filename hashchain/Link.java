package hashchain;

/*
 * 链表结点类,链表结点即实际应用中的数据项对象(比如一个人、一条数据库记录)
 */
public class Link {
	public int iData;//作为key
	public Link next;
	public Link(int d){
		iData=d;
		next=null;
	}
	
	public int getKey(){
		return iData;
	}
	public void display(){
		System.out.print(" "+iData);
	}
}
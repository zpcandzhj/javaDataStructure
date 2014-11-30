package listInsertionSort;
/*
 * 利用有序链表实现对数组的高效排序
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

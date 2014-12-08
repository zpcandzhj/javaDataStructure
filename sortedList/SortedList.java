package sortedList;
/*
 * 有序链表
 */
public class SortedList {

	private Link first;
	
	public SortedList(){
		first=null;
	}
	
	public boolean isEmpty(){
		return first==null;
	}
	
	public void insert(long val){
		Link newLink=new Link(val);
		Link current=first;
		Link previous=null;
		while(current!=null&&current.dData<val){//val在表尾的时候会遇到current=null
			previous=current;
			current=current.next;
		}
		//如果是空表或者插入元素在表头
		if(previous==null){
			first=newLink;
		}else{
			previous.next=newLink;
		}
		newLink.next=current;
	}
	
	//删除表头元素
	public Link remove(){
		Link temp=first;
		first=first.next;
		return temp;
	}
	
	public void displayList(){
		System.out.println("List(first-->last):");
		Link current = first;
		while (current != null) {
			current.display();
			current = current.next;
		}
	}
}

package heap;
/*
 * 堆中的元素，包含数据项域
 * 实际应用中可以是任意的数据对象
 * (比如一条数据库记录、一个Person对象)
 */
public class Node {
	private int iData;
	public Node(int key){
		iData=key;
	}
	public int getKey(){
		return iData;
	}
	public void setKey(int id){
		iData=id;
	}
}

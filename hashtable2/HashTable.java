package hashtable2;
/*
 * 此哈希表通过再哈希处理冲突
 * 移位步长由关键字的哈希值决定
 * 本例并不能删除和查找重复元素(只能对重复值的第一个进行操作)
 * 哈希函数hashFunc()的目的是得到关键字值的范围,把它用一种方式转化成数组的下标值,
 * 这种方法应该使关键字值尽可能随机地分布在整个哈希表中
 */
public class HashTable {
	private DataItem[] hashArray;//基于数组存储的哈希表
	private DataItem nonItem;//for delete items
	private int arraySize;
	
	public HashTable(int size){
		this.arraySize=size;
		hashArray=new DataItem[arraySize];
		nonItem=new DataItem(-1);//标记被删除的位置
	}
	//--------------------------
	public void displayTable(){
		System.out.println("Table:");
		for(int i=0;i<arraySize;i++){
			if(hashArray[i]!=null)
				System.out.print(hashArray[i].getKey()+" ");
			else
				System.out.print("** ");
		}
		System.out.println("");
	}
	//--------------------------
	public int hashFunc1(int key){
		return key%arraySize;
	}
	public int hashFunc2(int key){
		return 5-key%5;
	}
	//--------------------------
	public void insert(DataItem item){
		int key=item.getKey();
		int hashVal=hashFunc1(key);
		int stepSize=hashFunc2(key);
		while(hashArray[hashVal]!=null&&hashArray[hashVal].getKey()!=-1){
			hashVal+=stepSize;
			hashVal%=arraySize;//控制hashVal无止境地加,循环起来(所以arraySize取质数比较靠谱,防止被hashVal整除)
		}
		hashArray[hashVal]=item;
	}
	//----------------------------
	public DataItem delete(int key){
		int hashVal=hashFunc1(key);
		int stepSize=hashFunc2(key);
		while(hashArray[hashVal]!=null){//直到遇到空元素项才停止寻找
			if(hashArray[hashVal].getKey()==key)
			{
				DataItem temp=hashArray[hashVal];
				hashArray[hashVal]=nonItem;
				return temp;
			}
			hashVal+=stepSize;
			hashVal%=arraySize;
		}
		return null;
	}
	//----------------------------
	public DataItem find(int key){
		int hashVal=hashFunc1(key);
		int stepSize=hashFunc2(key);
		while(hashArray[hashVal]!=null){//直到遇到空元素项才停止寻找
			if(hashArray[hashVal].getKey()==key)
			{
				return hashArray[hashVal];
			}
			hashVal+=stepSize;
			hashVal%=arraySize;
		}
		return null;
	}
}















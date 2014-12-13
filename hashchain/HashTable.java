package hashchain;

/*
 * 基于链地址的哈希表
 * 哈希表的长度是arraySize,那么就得创建arraySize个SortedList来存储
 * 哈希函数hashFunc()的目的是得到关键字值的范围,把它用一种方式转化成数组的下标值,
 * 这种方法应该使关键字值尽可能随机地分布在整个哈希表中
 */
public class HashTable {
	private SortedList[] hashArray;
	private int arraySize;

	public HashTable(int size) {
		arraySize = size;
		hashArray = new SortedList[arraySize];
		// 为SortedList赋值,即创建arraySize个SortedList
		for (int i = 0; i < arraySize; i++) {
			hashArray[i] = new SortedList();
		}
	}

	// ---------遍历哈希表,显示所有元素----------
	public void displayTable() {
		for (int j = 0; j < arraySize; j++) {
			System.out.print(j+". ");
			hashArray[j].displayList();
		}
	}
	//---------哈希函数---------
	public int hashFunc(int key){
		return key%arraySize;
	}
	//--------插入函数,数据元素实际是插到哈希表中的链表中--------
	public void insert(Link DataItem){
		int key=DataItem.getKey();
		int hashValue=hashFunc(key);
		hashArray[hashValue].insert(DataItem);
	}
	//------------查找包含关键字的数据项-------------
	public Link find(int key){
		int hashValue=hashFunc(key);
		Link theLink=hashArray[hashValue].find(key);
		return theLink;
	}
	//-------------删除包含关键字的数据项------------
	public boolean delete(int key){
		int hashValue=hashFunc(key);
		return hashArray[hashValue].delete(key);
	}
}
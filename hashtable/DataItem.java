package hashtable;
/*
 * 要存到哈希表中的数据项
 * 可以是任意的java对象
 * 本例只封装了一个iData,作为关键字
 */
public class DataItem {
	private int iData;
	public DataItem(int i){
		iData=i;
	}
	public int getKey(){
		return iData;
	}
}

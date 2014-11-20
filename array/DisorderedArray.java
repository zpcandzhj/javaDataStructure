package array;

/*disorderedArray类封装数组存储数据
 * 并完成数据插入、删除、查找、遍历功能
 */
public class DisorderedArray {
	private long[] a;
	private int nums;

	public DisorderedArray(int max) {
		a = new long[max];
		nums = 0;
	}

	public int find(long value) {
		int pos = 0;
		int i = 0;
		for (; i < nums; i++) {
			if (a[i] == value) {
				pos = i;
				break;
			}
		}
		if (i == nums) {
			return -1;// 代表未找到
		}
		return pos;
	}

	public void insert(long value) {
		a[nums] = value;
		nums++;
	}

	public boolean delete(long value) {
		int i;
		for (i = 0; i < nums; i++) {
			if (a[i] == value)
				break;
		}
		if (i == nums) {
			return false;
		} else {
			for (int j = i; j < nums; j++) {
				a[j] = a[j + 1];
			}
			nums--;
			return true;
		}
	}
	
	//返回最大的关键词，并将其从数组中删除
	public long getMax(){
		long max;
		int j=0;//j是标记位，标记当前最大值得下标
		if(nums==0){return -1;}
		else max=a[0];
		for(int i=1;i<nums;i++){
			if(a[i]>max){max=a[i];j=i;}
		}
		delete(a[j]);
		return max;
	}
	
	public void display() {
		for(int i=0;i<nums;i++){
			System.out.println("a["+i+"]:"+a[i]);
		}
	}
}


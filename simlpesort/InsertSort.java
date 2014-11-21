package simlpesort;
/*
 * 一般来讲插入排序是三种基本排序里面效果最好的(三种算法的时间级都是O(N^2))
 * 特别是对于基本有序的数据来说，插入排序效果要好的多，因为while总是假,这种情况下时间级为O(N)
 * 插入排序一边比较一边复制(注意没有交换的过程)
 * 复制的次数大致等于比较的次数，然而一次复制和一次交换的时间耗费不同
 * 所以相对于随机数据,这个算法比冒泡排序快一倍,比选择排序略快
 */
public class InsertSort {
	private long[] a;
	private int nums;
	public InsertSort(int max){
		a=new long[max];
		nums=0;
	}
	
	public void insert(long value) {
		a[nums] = value;
		nums++;
	}
	public void display() {
		for(int i=0;i<nums;i++){
			System.out.println("a["+i+"]:"+a[i]);
		}
	}
	
	public void insertSort(){
		int out;
		int in;
		for(out=1;out<nums;out++){
			long temp=a[out];//temp临时存储空出的那一位
			in=out;
			//while寻找插入位置
			while(in>0&&a[in-1]>temp){
				a[in]=a[in-1];
				--in;
			}
			a[in]=temp;
		}
	}
}

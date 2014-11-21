package simlpesort;
/*
 * 选择排序和冒泡排序执行了相同的比较次数
 * 但是选择排序交换的次数不超过N，在大数据环境下更快
 */
public class SelectSort {
	private long[] a;
	private int nums;
	public SelectSort(int max){
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
	
	public void secletSort(){
		int out;
		int in;
		int min=0;
		for(out=0;out<nums-1;out++){
			min=out;
			for(in=out+1;in<nums;in++){
				if(a[in]<a[min]){
					min=in;
				}
			}
			swap(out,min);
		}
	}
	
	public void swap(int one,int two){
		long temp=a[one];
		a[one]=a[two];
		a[two]=temp;
	}
}

package simlpesort;

public class BubbleSort {
	private long a[];
	private int nums;
	public BubbleSort(int max){
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
	
	public void bubbleSort(){
		int out;//控制外循环次数(n-1次)
		int in;//控制内循环次数
		//从小到大排序
		for(out=nums-1;out>=1;out--){
			int flag=0;//设置一个标记位，判断是否要继续下一轮冒泡
			for(in=0;in<out;in++){
				if(a[in]>a[in+1]){
					swap(in,in+1);
					flag=1;
				}
			}
			if(flag==0){System.out.println("排序只进行了"+(nums-out)+"趟。");break;}
		}
	}
	
	public void swap(int one,int two){
		long temp=a[one];
		a[one]=a[two];
		a[two]=temp;
	}
}

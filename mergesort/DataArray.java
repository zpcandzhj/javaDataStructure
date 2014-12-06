package mergesort;

/*
 * 对一个数据数组进行归并排序
 * 基于递归的归并排序
 * 归并排序的效率是O(N*logN)
 */
public class DataArray {
	private long[] theArray;
	private int nums;
	private int count=0;//用来计数，控制打印格式的
	public DataArray(int max) {
		theArray = new long[max];
		nums = 0;
	}

	public void insert(long value) {
		theArray[nums] = value;
		nums++;
	}

	public void display() {
		for (int i = 0; i < nums; i++) {
			System.out.print(theArray[i] + " ");
		}
		System.out.println("");
	}

	// 客户端用户只需要知道有归并排序这个接口
	public void mergeSort() {
		long[] workSpace = new long[nums];//创建一个临时数组
		recMergeSort(workSpace, 0, nums - 1);
	}
	// 基于递归的归并排序主算法
	private void recMergeSort(long[] workSpace, int lowerBound, int upperBound) {
		if (lowerBound == upperBound) {
			return;
		}// 基值是1的时候看做有序,无需排序
		else {
			int mid=(lowerBound+upperBound)/2;//找到中点
			recMergeSort(workSpace,lowerBound,mid);//对左半部排序
			recMergeSort(workSpace,mid+1,upperBound);//对右半部排序
			//执行归并操作
			count--;
			merge(workSpace,lowerBound,mid+1,upperBound);
		}
	}
	
	private void merge(long[] workSpace,int lowPtr,int highPtr,int upperBound){
		int j=0;
		int lowerBound=lowPtr;//lowPtr后面要自增,先用lowerBound保存
		int mid=highPtr-1;//highPtr后面要自增,先用mid保存
		int n=upperBound-lowerBound+1;
		
		while(lowPtr<=mid&&highPtr<=upperBound){
			if(theArray[lowPtr]<theArray[highPtr]){
				workSpace[j++]=theArray[lowPtr++];
			}else{
				workSpace[j++]=theArray[highPtr++];
			}
		}
		
		//某个半部还有剩余项
		while(lowPtr<=mid){
			workSpace[j++]=theArray[lowPtr++];
		}
		
		while(highPtr<=upperBound){
			workSpace[j++]=theArray[highPtr++];
		}
		
		//把各个分支排序后填回原数组
		for(j=0;j<n;j++){
			theArray[lowerBound+j]=workSpace[j];
		}
	}

}

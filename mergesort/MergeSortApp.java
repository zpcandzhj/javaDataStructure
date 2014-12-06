package mergesort;

/* 归并排序合并两个有序数组
 * 一个基于非递归的归并排序
 * 目的在于理解归并排序的过程
 */
public class MergeSortApp {
	public static void main(String[] args) {
		int[] arrayA={12,13,24,52,63,88};
		int[] arrayB={9,13,42,78};
		int[] arrayC=new int[10];
		merge(arrayA,arrayB,arrayC);
		display(arrayC);
		//System.out.println(1/2);
	}
	
	public static void merge(int[] arrayA,int[] arrayB,int[] arrayC){
		int sizeA=arrayA.length;
		int sizeB=arrayB.length;
		int i=0,j=0,k=0;
		while(i!=sizeA&&j!=sizeB){
			if(arrayA[i]<arrayB[j])arrayC[k++]=arrayA[i++];
			else arrayC[k++]=arrayB[j++];
		}
		
		//倘若此时A还有剩余元素,直接将剩余元素加入C
		while(i!=sizeA){
			arrayC[k++]=arrayA[i++];
		}
		//倘若此时B还有剩余元素,直接将剩余元素加入C
		while(j!=sizeB){
			arrayC[k++]=arrayB[j++];
		}
		
	}
	public static void display(int[] theArray){
		for (int i=0;i<theArray.length;i++){
			System.out.println("["+i+"] "+theArray[i]);
		}
	}
}

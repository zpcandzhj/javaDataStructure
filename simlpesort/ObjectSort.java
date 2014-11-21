package simlpesort;
/*
 * 对象排序的Java代码
 * Person对象以lastname(姓)来排序
 */
public class ObjectSort {
	private Person[] a;
	private int nums;
	public ObjectSort(int max){
		a=new Person[max];
		nums=0;
	}

	public void insert(String last,String first,int age) {
		a[nums]=new Person(last, first, age);
		nums++;
	}
	public void display() {
		for(int i=0;i<nums;i++){
			System.out.print("a["+i+"] ");
			a[i].displayPerson();
		}
	}

	public void sortObject(){
		int out;
		int in;
		for(out=1;out<nums;out++){
			Person temp=a[out];
			in=out;
			while(in>0&&a[in-1].getLast().compareTo(temp.getLast())>0){
				a[in]=a[in-1];
				--in;
			}
			a[in]=temp;
		}
	}
	
}

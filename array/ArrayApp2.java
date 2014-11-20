package array;

public class ArrayApp2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OrderedArray array=new OrderedArray(20);
		array.display();
		array.insert1(21);
		array.insert1(121);
		array.insert1(34);
		array.insert1(216);
		array.insert1(43);
		array.insert1(57);
		array.insert1(78);
		array.insert1(33);
		array.display();
		System.out.println("array.find(111):"+array.find(111));
		System.out.println("array.find(57):"+array.find(57));
		long value=34;
		array.delete(value);
		System.out.println("============after delete "+value+"===========");
		array.display();
		array.insert1(1);
		array.insert1(111);
		array.insert1(222);
		array.insert1(333);
		System.out.println("============after insert2()===========");
		array.display();
	}

}

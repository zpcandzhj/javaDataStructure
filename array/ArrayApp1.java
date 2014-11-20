package array;

class ArrayApp1{
	public static void main(String[] args) {
		int maxSize=100;
		DisorderedArray array=new DisorderedArray(maxSize);
		array.insert(12);
		array.insert(212);
		array.insert(32);
		array.insert(532);
		array.insert(133);
		array.insert(42);
		array.insert(14);
		array.insert(112);
		array.insert(73);
		array.insert(52);
		array.display();
		System.out.println("===============");
		array.delete(34);
		array.display();
		System.out.println("===============");
		array.delete(212);
		array.display();
		long searchKey=1312;
		int i=array.find(searchKey);
		if(i!=-1)System.out.println("找到"+searchKey+",位置："+"a["+i+"]");
		else System.out.println("未找到 "+searchKey);
		long max=array.getMax();
		System.out.println("最大值："+max);
		System.out.println("===============");
		array.display();
	}
	
}


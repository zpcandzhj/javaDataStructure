package recursion;

public class BinarySearchApp {
	public static void main(String[] args) {
		int max = 10;
		BinarySearchArray theArray = new BinarySearchArray(max);
		theArray.insert(121);
		theArray.insert(122);
		theArray.insert(123);
		theArray.insert(124);
		theArray.insert(126);
		theArray.insert(125);
		theArray.insert(127);
		theArray.insert(128);
		theArray.insert(129);
		theArray.insert(120);
		theArray.display();
		long key=120;
		int res=theArray.find(key);
		if(res!=theArray.size()){
			System.out.println("找到了"+key+"！下标是"+res);
		}else{
			System.out.println("未找到"+key+"！");
		}
	}
}

package doublyLinkedList;

public class DoublyLinkedListApp {
	public static void main(String[] args) {
		DoublyLinkedList theList = new DoublyLinkedList();
		System.out.println("theList.isEmpty():" + theList.isEmpty());
		theList.insertFirst(11);
		theList.insertFirst(22);
		theList.insertFirst(33);
		theList.insertFirst(333);
		theList.insertFirst(44);
		theList.insertLast(55);
		theList.insertLast(66);
		theList.insertLast(77);
		theList.insertLast(88);
		System.out.println("theList.displayBackward():");
		theList.displayBackward();
		System.out.println("theList.displayForward():");
		theList.displayForward();

		theList.deleteLast();
		System.out.println("after deleteLast;theList.displayForward():");
		theList.displayForward();
		theList.deleteFirst();
		System.out.println("after deleteFirst;theList.displayForward():");
		theList.displayForward();
		long key = 333;
		if ((theList.deleteKey(key)) == null)
			System.out.println("delete " + key + " unsuccessfully,result is:！");
		else
			System.out.println("delete " + key + " successfully,result is:！");
		theList.displayForward();
		long key2 = 33;
		long key3 = 30003;
		if (theList.insertAfter(key2, key3) != false) {
			System.out
					.println("after insertAfter("+key2+","+key3+");theList.displayForward():");
			theList.displayForward();
		}else{
			System.out.println("insertAfter("+key2+","+key3+")失败！");
		}
	}
}

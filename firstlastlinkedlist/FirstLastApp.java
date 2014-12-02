package firstlastlinkedlist;

public class FirstLastApp {
	public static void main(String[] args) {
		FirstLastList flList = new FirstLastList();
		System.out.println("flList.isEmpty():" + flList.isEmpty());
		flList.insertLast(888);
		flList.insertFirst(122);
		flList.insertFirst(132);
		flList.insertFirst(142);
		flList.insertFirst(152);
		System.out
				.println("==============flList.displayList()================");
		flList.displayList();
		flList.insertLast(1222);
		flList.insertLast(1322);
		flList.insertLast(1422);
		flList.insertLast(1522);
		System.out
				.println("\n==============flList.displayList()================");
		flList.displayList();
		while (!flList.isEmpty()) {
			flList.deleteFirst();
		}
		System.out
				.println("\n==============after delete from first=============");
		flList.displayList();
		System.out.println("flList.isEmpty():" + flList.isEmpty());
		flList.insertLast(1222);
		flList.insertLast(1333);
		flList.insertLast(1444);
		flList.insertFirst(1555);
		flList.insertFirst(1666);
		flList.insertLast(1888);
		flList.displayList();
	}
}

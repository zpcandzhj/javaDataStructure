package sortedList;

public class SortedListApp {
	public static void main(String[] args) {
		SortedList theList=new SortedList();
		System.out.println("theList.isEmpty():"+theList.isEmpty());
		theList.insert(243);
		theList.insert(233);
		theList.insert(263);
		theList.insert(253);
		theList.insert(273);
		theList.insert(293);
		theList.insert(203);
		theList.displayList();
		theList.remove();
		System.out.println("");
		theList.displayList();
	}
}

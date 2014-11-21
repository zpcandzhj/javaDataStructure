package simlpesort;

public class PersonSortApp {
	public static void main(String[] args) {
		ObjectSort objarray=new ObjectSort(20);
		objarray.insert("zhou", "pengcheng", 24);
		objarray.insert("ma", "jian", 24);
		objarray.insert("heng", "jun", 23);
		objarray.insert("liu", "yang", 23);
		objarray.insert("cao", "nima", 25);
		objarray.insert("cao", "jie", 55);
		objarray.insert("chang", "lijun", 25);
		objarray.insert("周", "鹏程", 24);
		objarray.insert("马", "健", 23);
		objarray.insert("衡", "俊", 23);
		objarray.insert("草", "尼玛", 26);
		objarray.display();
		objarray.sortObject();
		System.out.println("+++++++++++  after sort  ++++++++++++");
		objarray.display();
		
	}

}

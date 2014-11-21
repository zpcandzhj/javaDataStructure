package simlpesort;

public class Person {
	private String lastname;
	private String firstname;
	private int age;
	public Person(String last,String first,int age){
		lastname=last;
		firstname=first;
		age=age;
	}
	
	public void displayPerson(){
		System.out.print("lastname: "+lastname+"\t");
		System.out.print("firstname: "+firstname);
		System.out.println("age: "+age);
	}
	//lastname作为排序准则
	public String getLast(){return lastname;}
}

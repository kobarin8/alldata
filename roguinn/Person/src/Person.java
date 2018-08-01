
public class Person {
	
	public Person(){}
	
	public Person(String name, int age){
		this.name=name;
		this.age=age;
	}
	
	public Person(String name){
		this.name=name;
		this.age=0;
	}
	
	public Person(int age){
		this.name="名前なし";
		this.age=age;
	}
	
	public Person(int age, String name){
		this.name=name;
		this.age=age;
	}
	
	

	public String name = null;
	public int age=0;
	public String phoneNumber = null;
	public String address = null;
	
	public void talk(){
		System.out.println(this.name+"が話す");
	}
	public void walk(){
		System.out.println(this.name+"が歩く");
	}
	public void run(){
		System.out.println(this.name+"が走る");
	}
}

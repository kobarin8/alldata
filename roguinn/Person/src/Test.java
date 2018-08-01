
public class Test {
	
	public static void main(String[]args){
	
		
		
		Person taro = new Person();
		taro.name="taro";
		taro.age=18;
		System.out.println(taro.name);
		System.out.println(taro.age);
		
		Person jiro = new Person("jiro",20);
		System.out.println(jiro.name);
		System.out.println(jiro.age);
		
		Person saburo = new Person("saburo");
		System.out.println(saburo.name);
		System.out.println(saburo.age);
		
		Person nanasi = new Person(25);
		System.out.println(nanasi.name);
		System.out.println(nanasi.age);
		
		Person hanakosan = new Person("hanako",17);
		System.out.println(hanakosan.name);
		System.out.println(hanakosan.age);
		
		
		
		Person kimura =new Person();
		
		kimura.name="木村次郎";
		kimura.age=18;
		kimura.phoneNumber="03-9999-2324";
		kimura.address="東京";
		kimura.talk();
		kimura.walk();
		kimura.run();
		
		System.out.print(kimura.name+"、");
		System.out.print(kimura.age);
		System.out.print(kimura.phoneNumber);
		System.out.println(kimura.address);
		
		Person hanako =new Person();
		
		hanako.name="鈴木花子";
		hanako.age=16;
		hanako.phoneNumber="03-4242-2300";
		hanako.address="函館";
		hanako.talk();
		hanako.walk();
		hanako.run();
		
		System.out.print(hanako.name+"、");
		System.out.print(hanako.age);
		System.out.print(hanako.phoneNumber);
		System.out.println(hanako.address);
		
		Robot aibo =new Robot();
		Robot asimo =new Robot();
		Robot pepper =new Robot();
		Robot doraemon =new Robot();
		aibo.name="aibo";
		asimo.name="asimo";
		pepper.name="pepper";
		doraemon.name="doraemon";
		
		
		aibo.talk();
		aibo.walk();
		aibo.run();
		
		asimo.talk();
		asimo.walk();
		asimo.run();
		
		pepper.talk();
		pepper.walk();
		pepper.run();
		
		doraemon.talk();
		doraemon.walk();
		doraemon.run();
		
		
		
		
		
	}

}

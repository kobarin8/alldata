package note;

public class note1 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
System.out.println("あなたの運勢を占います");

int fortune = new java.util.Random().nextInt(4)+1;

switch(fortune){

case 1: System.out.println("大吉"); break;
case 2: System.out.println("中吉"); break;
case 3: System.out.println("小吉"); break;
case 4: System.out.println("凶"); break;

}


	}
}

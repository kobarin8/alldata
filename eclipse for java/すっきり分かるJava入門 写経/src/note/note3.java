package note;

public class note3 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

int[][] score = {{10,20,30,},{40,50,60,70,}};

int[] points = new int[4];
double[] weights = new double[5];
boolean[] answers = new boolean[3];
String[] names = new String[3];

int[] moneylist ={121902,8302,55100};

for(int i=0; i<moneylist.length; i++){
	System.out.println("moneylist[i]");
}

for(int values:moneylist){
	System.out.println(values);
}

int[] number = new int[]{3,4,9};
System.out.println("画面に一桁の数字を入力してください");
while(true){



int input = new java.util.Scanner(System.in).nextInt();


if(input == number[0] || input== number[1] || input== number[2]){
	
	System.out.println("あたりだよ！"); break;
}
else{System.out.println("はずれ！");}


}
}

}



package setter;

public class Execute {

public static void main(String[] args) {

test1 honto = new test1();

honto.zenbu();
System.out.println(honto.getreal());

System.out.println(honto.setreal2("お台場"));
System.out.println(honto.setreal3("石油王な"));
System.out.println(honto.settest("高級バッグ",28));

System.out.println(honto.buy("バナナ"));
}
}

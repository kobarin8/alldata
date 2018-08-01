public class Test{


public static void main(String[] args){


Person taro = new Person();

taro.name="山田太郎";
taro.age=41;
System.out.println(taro.name);
System.out.println(taro.age);

taro.talk();
taro.walk();
taro.run();


}

}
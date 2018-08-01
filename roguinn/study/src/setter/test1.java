package setter;

public class test1 {

	public String uso = "今日は家でゆっくり家事";
	public String uso2 = "だから今日は家ですごしてたの";
	private String naisho = "ほんとはへそくり貯金で日帰りツアーにいってきたんだけどね";

	public void zenbu(){System.out.println(this.uso+this.uso2);}
	public String getreal(){return this.naisho;}

	private String place;
	private String looks;
	private String buyitem;
	private int buynum;

	private String testgoods;

	public String setreal2(String setplace){
	this.place=setplace;
	return this.naisho="すいません、うそです。"+this.place+"に行きました。";}

	public String setreal3(String setlooks){
	this.looks=setlooks;
	return this.naisho="それもうそです。信じてもらえないかもしれませんが、\r\nこの世に110人しかいない"+this.looks+"友人とお茶会でした。";}

	public String settest(String setbuy,int setnum){
	this.buyitem=setbuy;
	this.buynum=setnum; return this.naisho="彼に"+this.buyitem+"を買ってもらいました。"+this.buynum+"個。";}

	public String buy(String set3){return this.testgoods=set3;}

}

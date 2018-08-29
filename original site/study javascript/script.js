function answer(){
    
var num1 = document.getElementById("number1").value;

var num2 = document.getElementById("number2").value;

var num3 = document.getElementById("number3").value;

var sum = parseInt(num1, 10) + parseInt(num2, 10);
    
var answersheet = document.getElementById("answer");

var hanteisheet = document.getElementById("hantei");
    
if(parseInt(num3, 10) === sum){
answersheet.innerHTML　=　num1+"+"+num2+"="+sum
hanteisheet.innerHTML ="正解です！"
}
else{hanteisheet.innerHTML ="不正解だぞ！"}


}
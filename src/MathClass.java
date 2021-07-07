public class MathClass {

    public static double number = 1234.56789;

    //올림
    public void setRoundUpNumber(){
        System.out.println(Math.ceil(number/10)*10); // 1240.0
        System.out.println(Math.ceil(number/100)*100); // 1300.0
        System.out.println(Math.ceil(number)); //1235.0
        System.out.println(Math.ceil(number*10)/10.0); //1234.6
        System.out.println(Math.ceil(number*100)/100.0); //1234.57
    }


    //버림
    public void setRoundDownNumber(){
        System.out.println(Math.floor(number/10)*10); //1230.0
        System.out.println(Math.floor(number/100)*100); //1200.0
        System.out.println(Math.floor(number)); //1234.0
        System.out.println(Math.floor(number*10)/10.0); //1234.5
        System.out.println(Math.floor(number*100)/100.0); //1234.56
    }


    //반올림
    public void setRoundOffNumber(){

        System.out.println(Math.round(number/10)*10); //1230
        System.out.println(Math.round(number/100)*100); //1200
        System.out.println(Math.round(number)); //1235
        System.out.println(Math.round(number*10)/10); //1234
        System.out.println(Math.round(number*100)/100.0); //1234.57
        System.out.println(Math.round(number*1000)/1000.0); // 1234.568

    }





}

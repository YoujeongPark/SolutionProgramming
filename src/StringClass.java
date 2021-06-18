import java.util.StringTokenizer;

public class StringClass {

    public void StringBuilderCFunc(){
        StringBuilder sb = new StringBuilder("Rosy");
        sb.append("Park");
        System.out.println(sb); //RosyPark
        System.out.println(sb.length()); //8
    }


    public void StringTokenizerCFunc() {
        String sb2 = "Biden finds his comfort/zone";
        StringTokenizer stk = new StringTokenizer(sb2);
        System.out.println(stk); //java.util.StringTokenizer@119d7047
        System.out.println(stk.countTokens());
        while(stk.hasMoreTokens()){
            System.out.println(stk.nextToken()); //단어출력...
        }

        String sb3 = "Biden finds his comfort/zone";
        StringTokenizer stk2 = new StringTokenizer(sb2,"/");
        System.out.println(stk2);
        System.out.println(stk2.countTokens()); //2
        while(stk2.hasMoreTokens()){
            System.out.println(stk2.nextToken()); //단어출력...
        }


    }
}




public class CastingClass {
    public int StringToInteger(String string){
        return Integer.parseInt(string);
    }

    public double StringToDouble(String string){
        return Double.valueOf(string);
    }


    public float StringToFloat(String string){
        return Float.valueOf(string);
    }

    public String IntegerToString(int number){
        return Integer.toString(number);
    }

    public String FloatToString(float number){
        return Float.toString(number);
    }

    public int FloatToInteger(float number){
        return (int)number;
    }

    public float IntegerToFloat(int number){
        return (float)number;
    }

}

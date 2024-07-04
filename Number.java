//Esmail Keshtkar

public class Number {//creates a Number class
    protected double real;
    
    public Number()//default constructer
    {
        real = 0;
    }
    
    public Number(double num)//overloaded constructor
    {
        real = num;
    }
    
    public void setRealNum(double newNum)//sets the real number
    {
        real = newNum;
    }
    
    public double getRealNum()//gets the real number
    {
        return real;
    }
    
    @Override
    public String toString(){//overrides the toString method and returns a string of a double rounded to two decimal places
        String r = String.format("%.2f", real);
        return String.valueOf(r);
    }
    
    @Override
    public boolean equals(Object o){//overrides the equals method and checks to see if the real numbers are equal to eachother
        if(o == this)
            return true;
        if(!(o instanceof Number))
            return false;
        
        //checks to see if the reals are equal to eachother
        Number n = (Number) o;
        if(n.real == real)
            return true;
        
        return false;
        
    }
}

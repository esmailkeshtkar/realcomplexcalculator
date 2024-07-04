//Esmail Keshtkar

public class Complex extends Number{//creates a Complex class that is a child of the Number class
    //this class has inherited the double real variable and the setRealNum and getRealNum methods
    protected double imaginary;
    
    public Complex(){//default constructor
        real = 0;
        imaginary = 0;
    }
    
    public Complex(double num1, double num2)//overloaded constructor that sets the real and imaginary Numbers
    {
        super(num1);
        imaginary = num2;
    }
    
    public void setImaginaryNum(double newNum)//sets the imaginary number
    {
        imaginary = newNum;
    }
    
    public double getImaginaryNum()//gets the imaginary number
    {
        return imaginary;
    }
    
    @Override
    public String toString(){//overrides the tostring method 
        String r = String.format("%.2f", real);//formats the real number to two decimal places
        String i = String.format("%.2f", imaginary);//formats imaginary number to 2 decimal places
        if (imaginary >0)//if the imaginary number is positive then it outputs A+Bi or Bi if the real is 0
            if(real != 0 )
                return String.valueOf(r+"+"+i+"i");
            else
                return String.valueOf(i+"i");
        else if (imaginary == 0)//if the imaginary number is 0 then it outputs A
            return String.valueOf(r);
        else//if the imaginary number is negative then it outputs A-Bi or Bi if the real is 0
        {
            if(real != 0)
                return String.valueOf(r+""+i+"i");
            else
                return String.valueOf(i+"i");
        }
        
    }
    
    @Override
    public boolean equals(Object o){//overrides the equals method and checks to see if the objects are equal
        if(o == this)
            return true;
        if(!(o instanceof Complex))
            return false;
        
        Complex c = (Complex) o;//casts the object as a complex
        
        if(c.real == real && c.imaginary == imaginary)//checks to see if the imaginary and real variables are equal to eachother
            return true;
        return false;
    }
}

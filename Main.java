//Esmail Keshtkar
import java.io.*;
import java.util.*;


/*This program is a calculator that involves real, imaginary, and complex numbers, it will read through a file specified by a user
and evaluate the expressions in the file line and output the result in another text file. It will add, subtract, multiply, divide, 
and compare real and complex numbers. If the expression on the line in the input file is invalid then it will skip that line and proceed 
to the next.
*/
public class Main {
    
    //addNums takes in two objects and performs addition based on the type of object they are (complex or real)
    //casts the object based on what they are an instanceof, complex or real
    //returns a string after the computation has been completed
    public static String addNums(Object o1, Object o2)
    {
        //if the first object is a complex number
        if(o1 instanceof Complex)
        {
           Complex c1 = (Complex)o1;
           Complex result = new Complex();
           //if the second object is a complex number
           if(o2 instanceof Complex)
           {
               //adds the complex number's real and imaginary parts together
               Complex c2 = (Complex)o2;
               Double sumReal = c1.real+c2.real;
               Double sumImag = c1.imaginary+c2.imaginary;
               result = new Complex(sumReal, sumImag);
               return result.toString();
           }
           else
           {
               //if the second number isn't complex then it adds the real numbers together while maintaining the imaginary number
               Number n2 = (Number)o2;
               Double sumReal = c1.real+n2.real;
               Double sumImag = c1.imaginary;
               result = new Complex(sumReal, sumImag);
               return result.toString();
           }
        }
        else//otherwise the first object is a real number
        {
            Number n1 = ((Number)o1);
            if(o2 instanceof Complex)//performs addition if the second object is a complex number
            {
               Complex result = new Complex();
               Complex c2 = (Complex)o2;
               Double sumReal = n1.real+c2.real;
               Double sumImag = c2.imaginary;
               result = new Complex(sumReal, sumImag);
               return result.toString();
            }
            else//otherwise performs addition if the second object is also a real number
            {
               Number result = new Number();
               Number n2 = (Number)o2;
               Double sumReal = n1.real+n2.real;
               result = new Number(sumReal);
               return result.toString();
            }
        }
    }
    
    //takes in two objects and performs subtraction based on the object they are (complex or real)
    //returns a string after the calculations are completed
    public static String subtractNums(Object o1, Object o2)
    {
        //checks if the first object is a complex number
        if(o1 instanceof Complex)
        {
           Complex c1 = (Complex)o1;
           Complex result = new Complex();
           if(o2 instanceof Complex)//checks if the second object is a complex number and then performs subtraction with their real/imaginary parts
           {
               Complex c2 = (Complex)o2;
               Double sumReal = c1.real-c2.real;
               Double sumImag = c1.imaginary-c2.imaginary;
               result = new Complex(sumReal, sumImag);
               return result.toString();
           }
           else//otherwise the second object will be a real number and only the reals will be subtracted
           {
               Number n2 = (Number)o2;
               Double sumReal = c1.real-n2.real;
               Double sumImag = c1.imaginary;
               result = new Complex(sumReal, sumImag);
               return result.toString();
           }
        }
        else//if the first object isn't complex then it is real and performs subtraction based on that
        {
            Number n1 = (Number)o1;
            if(o2 instanceof Complex)//checks to see if the second object is complex and performs subtraction
            {
               Complex result = new Complex();
               Complex c2 = (Complex)o2;
               Double sumReal = n1.real-c2.real;
               Double sumImag = -c2.imaginary;//subtraction of the imaginary from 0
               result = new Complex(sumReal, sumImag);
               return result.toString();
            }
            else//otherwise the second number is real and then addition of two real numbers is performed
            {
               Number result = new Number();
               Number n2 = (Number)o2;
               Double sumReal = n1.real-n2.real;
               result = new Number(sumReal);
               return result.toString();
            }
        }
    }
    
    //this function takes two objects and multiplys them and then returns string
    public static String multiplyNums(Object o1, Object o2)
    {
        //checks if the first object is complex or real
        if(o1 instanceof Complex)
        {
           Complex c1 = (Complex)o1;
           Complex result = new Complex();
           if(o2 instanceof Complex)
           {
               //if the second object is also complex then we must FOIL them
               //essentially a + bi * c + di will be
               //a*c + a*di + c*bi + bi*di
               Complex c2 = (Complex)o2;
               Double productReal = c1.real*c2.real;
               productReal -= (c1.imaginary*c2.imaginary);//when two imaginary numbers are multiplied it becomes ni^2 which becomes -n
               Double productImag = c1.imaginary*c2.real;
               productImag += c1.real*c2.imaginary;
               result = new Complex(productReal, productImag);
               return result.toString();
           }
           else
           {
               //if the second object is a real number then it just multiplies the imaginary and real parts together
               Number n2 = (Number)o2;
               Double productReal = c1.real*n2.real;
               Double productImag = c1.imaginary*n2.real;
               result = new Complex(productReal, productImag);
               return result.toString();
           }
        }
        else//otherwise the first object is real
        {
            Number n1 = (Number)o1;
            if(o2 instanceof Complex)
            {
               //if second object is complex then multiplies the imaginary and real parts together
               Complex result = new Complex();
               Complex c2 = ((Complex)o2);
               Double productReal = n1.real*c2.real;
               Double productImag = n1.real*c2.imaginary;
               result = new Complex(productReal, productImag);
               return result.toString();
            }
            else
            {
               //multiplies two real numbers together
               Number result = new Number();
               Number n2 = (Number)o2;
               Double sumReal = n1.real*n2.real;
               result = new Number(sumReal);
               return result.toString();
            }
        }
    }
    
    //this function divides two complex or real numbers and returns a string
    public static String divideNums(Object o1, Object o2)
    {
        if(o1 instanceof Complex)//if the first object is a complex number
        {
           Complex c1 = (Complex)o1;
           Complex result = new Complex();
           if(o2 instanceof Complex)
           {
               //if the second object is a complex number then we must multiply by the conjugate and perform the mathematical function that way
               Complex c2 = (Complex)o2;
               Complex conjugate = new Complex(c2.real, -(c2.imaginary));//creates a complex conjugate object of what we are dividing by i.e (3+2i) becomes (3-2i)
               //we do this in order to get rid of the imaginary numbers in the denominator so that dividing is possible
               double numeratorReals = c1.real*conjugate.real+(-(conjugate.imaginary*c1.imaginary));//FOILS the numerator with the conjgugate
               double numeratorImaginarys = c1.imaginary*conjugate.real+c1.real*conjugate.imaginary;//FOILS the numerator with the conjugate
               double denominatorReals = c2.real*conjugate.real+(-(conjugate.imaginary*c2.imaginary));//FOILS the denominator with the conjugate
               double quotientReal = numeratorReals/denominatorReals;//divides the reals in the numerator by the reals in the denominator
               double quotientImag = numeratorImaginarys/denominatorReals;//divides the imaginaries in the numerator by the imaginaries in the denominator
               result = new Complex(quotientReal, quotientImag);
               return result.toString();
           }
           else
           {
               //otherwise if the second object is real then we just divide the real and imaginary parts by the real number
               Number n2 = (Number)o2;
               Double quotientReal = c1.real/n2.real;
               Double quotientImag = c1.imaginary/n2.real;
               result = new Complex(quotientReal, quotientImag);
               return result.toString();
           }
        }
        else//otherwise the first object is a real number
        {
            Number n1 = (Number)o1;
            if(o2 instanceof Complex)
            {
                //if the second object is complex then we divide the real number by the real and imaginaries of the complex numbre
               Complex result = new Complex();
               Complex c2 = (Complex)o2;
               Double quotientReal = n1.real/c2.real;
               Double quotientImag = n1.real/c2.imaginary;
               result = new Complex(quotientReal, quotientImag);
               return result.toString();
            }
            else
            {
                //if the second object is a real then we just divide like a normal real number
               Number result = new Number();
               Number n2 = (Number)o2;
               Double quotientReal = n1.real/n2.real;
               result = new Number(quotientReal);
               return result.toString();
            }
        }
    }
    
    //this function compares the two objects passed in and sees if the sign is representative or not
    public static boolean compareNums(Object o1, Object o2, String compareSign)
    {
        String realComparison = "";//default value for comparison
        
        if(o1 instanceof Complex)
        {
           Complex c1 = (Complex)o1;
           if(o2 instanceof Complex)//compares a complex and a complex number
           {
               Complex c2 = (Complex)o2;
               if(c1.equals(c2))//calls the equals function to see if they are equal
                   realComparison = "=";
               else
               {
                  //if they are not equal then it compares the magnitudes of the two complex numbers
                  //for example 3+4i magnitude is sqrt(3^2+4^2) = 5
                  double magnitude1 = Math.sqrt((c1.real*c1.real)+(c1.imaginary*c1.imaginary));
                  double magnitude2 = Math.sqrt((c2.real*c2.real)+(c2.imaginary*c2.imaginary));
                  if(magnitude1 > magnitude2)
                      realComparison = ">";//if the magnitude of the first is greater then the sign is >
                  else if(magnitude1 < magnitude2)
                      realComparison = "<";//if the magnitude of the second is greater then the sign is <
               }
               
           }
           else
           {
               //compares a complex number and a real number
               Number n2 = (Number)o2;
               double magnitudeComplex = Math.sqrt((c1.real*c1.real)+(c1.imaginary*c1.imaginary));
               //compares the complex number's magnitude with the real number and stores the valid sign
               if(magnitudeComplex > n2.real)
                   realComparison = ">";
               else if (magnitudeComplex < n2.real)
                   realComparison = "<";
           }
        }
        else
        {
            //compares a real number with a complex or a real number
            Number n1 = (Number)o1;
            if(o2 instanceof Complex)
            {
                Complex c2 = (Complex) o2;
               //compares the complex number's magnitude with the real number and stores the valid sign
                double magnitudeComplex = Math.sqrt((c2.real*c2.real)+(c2.imaginary*c2.imaginary));
                if(n1.real > magnitudeComplex)
                    realComparison = ">";
                else if (n1.real < magnitudeComplex)
                    realComparison = "<";
            }
            else
            {
               //compares two real numbers
               Number n2 = (Number)o2;
               if(n1.equals(n2))//calls the equals function to see if they are equal
                   realComparison = "=";
               //otherwise it compares to see if they are less than or greater than
               else if (n1.real > n2.real)
                   realComparison = ">";
               else if (n1.real<n2.real)
                   realComparison  ="<";
            }
        }
        
        //if the sign that is stated is equivalent to the actual valid sign then it returns true, otherwise it returns false
        if(compareSign.equals(realComparison))
            return true;
        else
            return false;
    }
    
    //this function serves to call the other operation functions such as adding, dividing, etc. in order to output the 
    //valid results 
    public static void doOperation(Object o1, Object o2, String operand, String s, PrintWriter out)
    {
        
        //checks to see what the operand is and then calls the appropriate function in order to calculate results
        if(operand.equals("+"))//addition
        {
            System.out.printf(s+"\t"+addNums(o1,o2)+"\n");//outputs to the console
            out.printf(s+"\t"+addNums(o1,o2)+"\n");//outputs to the file
        }
        else if(operand.equals("-"))//subtraction
        {
            System.out.printf(s+"\t"+subtractNums(o1,o2)+"\n");
            out.printf(s+"\t"+subtractNums(o1,o2)+"\n");
        }
        else if(operand.equals("*"))//multiplication
        {
            System.out.printf(s+"\t"+multiplyNums(o1,o2)+"\n");
            out.printf(s+"\t"+multiplyNums(o1,o2)+"\n");
        }
        else if(operand.equals("/"))//division
        {
            System.out.printf(s+"\t"+divideNums(o1,o2)+"\n");
            out.printf(s+"\t"+divideNums(o1,o2)+"\n");
        }
        else if(operand.equals("<") || operand.equals(">") || operand.equals("="))//comparison
        {
            System.out.printf(s+"\t"+compareNums(o1,o2, operand)+"\n");
            out.printf(s+"\t"+compareNums(o1,o2, operand)+"\n");
        }
    }
    
    //this function checks to make sure the line is valid
    public static boolean lineValidity(String s)
    {
        
        //uses a regular expression checker to make sure the line follows a specific format otherwise it will skip the line
        if(s.matches("^[-]{0,1}\\d+(\\.\\d+)?[i]{0,1}\\s[\\>\\<\\=\\+\\-\\*\\/]\\s[-]{0,1}\\d*(\\.\\d+)?[i]{0,1}$")//format of double[i] (operand) double[i]
        || s.matches("^[-]{0,1}\\d+(\\.\\d+)?[+\\-]\\d+(\\.\\d+)?[i]\\s[\\>\\<\\=\\+\\-\\*\\/]\\s[-]{0,1}\\d+(\\.\\d+)?[+\\-]\\d+(\\.\\d+)?[i]$")//format of double(+-)doublei (operand) double(+-)doublei
        || s.matches("^[-]{0,1}\\d+(\\.\\d+)?[+\\-]\\d+(\\.\\d+)?[i]\\s[\\>\\<\\=\\+\\-\\*\\/]\\s[-]{0,1}\\d+(\\.\\d+)?[i]{0,1}$")//format of double(+-)doublei (operand) double
        || s.matches("^[-]{0,1}\\d+(\\.\\d+)?[i]{0,1}\\s[\\>\\<\\=\\+\\-\\*\\/]\\s[-]{0,1}\\d+[\\.]?\\d*[+\\-]\\d+(\\.\\d+)?[i]$"))//format of double (operand) double(+-)doublei      
        {
            return true;
        }
        //if the expression in the line is not to proper format then the line will be skipped 
        return false;
    }
    
    public static void main(String[] args) throws IOException {
        
        //create and initialize variables
        Scanner kb = new Scanner(System.in);//used for user input
        Scanner input;
        PrintWriter output;
        String fileName;
        
        //asks the user for the name of the file
        System.out.println("Please enter the name of the file containing the data.");
        fileName = kb.nextLine();
        java.io.File file = new java.io.File(fileName);
        
        //checks to see if the file is readable and exists
        if(file.exists() && file.canRead())
        {
            //creates a scanner based on the inputted file name and an output file called results.txt
            input = new Scanner(new File(fileName));
            output = new PrintWriter(new File("results.txt"));
            
            //loops until there are no more lines in the input file
            //inside the while loop we will check if the line is valid and assign values to the first and second half of the expression
            //and then call a function in order to do the mathematical operation
            //if the line is invalid then it will skip that line and go to the next line
            while(input.hasNextLine())
            {
                String thisLine = input.nextLine();
                if(lineValidity(thisLine))//calls the lineValidity function to see if this line is valid
                {
                    int firstSpace = thisLine.indexOf(" ")+1;//finds the position of the first space in order to find the part of the equation
                    String operand = thisLine.substring(firstSpace, firstSpace+1);//finds the operand
                    String firstExpression = thisLine.substring(0,firstSpace-1);//creates the first expression
                    String secondExpression = thisLine.substring(firstSpace+2);//creates the second expression
                    int firstIsNegative = 1;//used to see if the first value in the first expression is negative
                    int secondIsNegative = 1;//used to see if the first value int he second expression is negative
                    
                    //checks if the first value in the first expression is negative
                    if(firstExpression.charAt(0) == '-')
                    {
                        firstExpression = firstExpression.substring(1);
                        firstIsNegative = -1;
                    }
                    
                    //checks if the first value in the second expression is negative
                    //if it is then it assigns firstIsNegative a value of -1
                    if(secondExpression.charAt(0) == '-')
                    {
                         secondIsNegative = -1;
                         secondExpression = secondExpression.substring(1);
                    }
                    
                    //the following if else statements are used to check whether the expression is complex or not
                    // and assign the appropriate values to the object
                    //checks if the first expression contains an imaginary number
                    //if it is then it assigns firstIsNegative a value of -1
                    if(firstExpression.contains("i"))
                    {
                        Complex complex1 = new Complex();
                        Double real;
                        Double imag;
                        //checks if the first expression is in the form a-bi
                        if(firstExpression.contains("-"))
                        {
                            real = Double.parseDouble(firstExpression.substring(0,firstExpression.indexOf("-")));//reads the first part of the string and assigns it to the real number
                            real*= firstIsNegative;
                            imag = Double.parseDouble(firstExpression.substring(firstExpression.indexOf("-"), firstExpression.indexOf("i")));//reads the second part of the string and assigns it to the imaginary number
                            complex1 = new Complex(real, imag);//creates a new complex number with a real and imaginary number
                        }
                        //checks if the first expression is in the form a+bi
                        else if(firstExpression.contains("+"))
                        {
                            real = firstIsNegative*Double.parseDouble(firstExpression.substring(0,firstExpression.indexOf("+")));
                            real *= firstIsNegative;
                            imag = Double.parseDouble(firstExpression.substring(firstExpression.indexOf("+")+1, firstExpression.indexOf("i")));
                            complex1 = new Complex(real, imag);
                        }
                        else//otherwise the number is a lone imaginary numbber
                        {
                            real = 0.0;
                            imag = Double.parseDouble(firstExpression.substring(0, firstExpression.indexOf("i")));
                            imag *= firstIsNegative;
                            complex1 = new Complex(real, imag);
                        }
                        
                        //checks the second part of the equation expression and creates the appropriate object, similar to the first expression
                        if(secondExpression.contains("i"))
                        {
                            Complex complex2 = new Complex();
                            if(secondExpression.contains("-"))
                            {
                                real = Double.parseDouble(secondExpression.substring(0,secondExpression.indexOf("-")));
                                real *= secondIsNegative;
                                imag = Double.parseDouble(secondExpression.substring(secondExpression.indexOf("-"), secondExpression.indexOf("i")));
                                complex2 = new Complex(real, imag);//creates the second complex number
                            }
                            else if(secondExpression.contains("+"))
                            {
                                real = Double.parseDouble(secondExpression.substring(0,secondExpression.indexOf("+")));
                                real *= secondIsNegative;
                                imag = Double.parseDouble(secondExpression.substring(secondExpression.indexOf("+")+1, secondExpression.indexOf("i")));
                                complex2 = new Complex(real, imag);
                            }
                            else
                            {
                                real = 0.0;
                                imag = Double.parseDouble(secondExpression.substring(0, secondExpression.indexOf("i")));
                                imag *= secondIsNegative;
                                complex2 = new Complex(real, imag);
                            }
                            doOperation(complex1, complex2, operand, thisLine, output);//calls the doOperation function to do the calculation for this line
                        }
                        else
                        {
                            //if the second expression isn't complex then it creates a regular number object
                            Number number2 = new Number();
                            real = Double.parseDouble(secondExpression);
                            real *= secondIsNegative;
                            number2 = new Number(real);
                            doOperation(complex1, number2, operand, thisLine, output);//calls the doOperation function
                        }
                    }
                    else//if the first statement is not a complex number then it is a real number
                    {
                        //if the first expression isn't a complex number then it must be a real number
                        Double real;
                        Double imag;
                        Number number1 = new Number();//creates a real number
                        real = Double.parseDouble(firstExpression);
                        real*= firstIsNegative;
                        number1 = new Number(real);
                        //checks the second expression and creates the second object and performs operations like the previous if statements
                        if(secondExpression.contains("i"))
                        {
                            Complex complex2 = new Complex();
                            if(secondExpression.contains("-"))
                            {
                                real = Double.parseDouble(secondExpression.substring(0,secondExpression.indexOf("-")));
                                real *= secondIsNegative;
                                imag = Double.parseDouble(secondExpression.substring(secondExpression.indexOf("-"), secondExpression.indexOf("i")));
                                complex2 = new Complex(real, imag);
                            }
                            else if(secondExpression.contains("+"))
                            {
                                real = Double.parseDouble(secondExpression.substring(0,secondExpression.indexOf("+")));
                                real *= secondIsNegative;
                                imag = Double.parseDouble(secondExpression.substring(secondExpression.indexOf("+")+1, secondExpression.indexOf("i")));
                                complex2 = new Complex(real, imag);
                            }
                            else
                            {
                                real = 0.0;
                                imag = Double.parseDouble(secondExpression.substring(0, secondExpression.indexOf("i")));
                                imag *= secondIsNegative;
                                complex2 = new Complex(real, imag);
                            }
                            doOperation(number1, complex2, operand, thisLine, output);//calls the doOperation function
                        }
                        else
                        {
                            Number number2 = new Number();
                            real = Double.parseDouble(secondExpression);
                            real *= secondIsNegative;
                            number2 = new Number(real);
                            doOperation(number1, number2, operand, thisLine, output);//calls the doOperation function
                        }
                    }
                }
            }
            output.close();//closes the output file
            input.close();//closes in the input file
        }
    }
}

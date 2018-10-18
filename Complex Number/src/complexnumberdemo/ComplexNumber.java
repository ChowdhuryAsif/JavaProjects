
package complexnumberdemo;


public class ComplexNumber {
    
    private double a;
    private double b;
    
    //constructor for new Complex Number
    public ComplexNumber(double a, double b){
        this.a = a;
        this.b = b;
    }
    
    //Complex Number Addition
    public ComplexNumber add(ComplexNumber that){
        double p = this.a + that.a;
        double q = this.b + that.b;
        
        return new ComplexNumber(p, q);
    }
    
    //Complex Number Subtraction
    public ComplexNumber subtract(ComplexNumber that){
        double p = this.a - that.a;
        double q = this.b - that.b;
        
        return new ComplexNumber(p, q);
    }
    
    //Complex Number Multiplication
    public ComplexNumber multiply(ComplexNumber that){
        double p = (this.a * that.a) - (this.b * that.b);
        double q = (this.a * that.b) + (this.b * that.a);
        
        return new ComplexNumber(p, q);
    }
    
    //Complex Number Division
    public ComplexNumber divide(ComplexNumber that){
        if(Math.abs(that.a) < 0.000001 && Math.abs(that.b) < 0.000001){
            System.err.println("Division by zero error");
            return null;
        }
        
        ComplexNumber conjugate = new ComplexNumber(that.a, (that.b * -1));
        ComplexNumber numerator = this.multiply(conjugate);
        /**
         * for the denominator in division of complex number
         * let the denominator of complex number is (c+d*i)
         * then we have to multiply numerator & denominator by (c-d*i)
         * so in denominator (c+d*i) * (c-d*i)
         * it will c^2 - (d^2 * i^2) == c^2 + d^2;
         * if the complex number (c-d*i)
         * then in denominator (c-d*i) * (c+d*i)
         * it will also c^2 - (d^2 * i^2) == c^2 + d^2; 
         */
        double denominator = Math.pow(that.a, 2) + Math.pow(that.b, 2);
        
        double p = numerator.a / denominator;
        double q = numerator.b / denominator;
        
        return new ComplexNumber(p, q);
    }
    
    public void Print(){
        if(this.b < 0.0)
            System.out.printf("%.4f - %.4fi\n", this.a, (this.b * -1) );
        else
            System.out.printf("%.4f + %.4fi\n", this.a, this.b);
    }
    
    @Override
    public boolean equals(Object obj){
        ComplexNumber that = (ComplexNumber) obj;
        
        if(Math.abs(this.a - that.a) < 0.000001 && Math.abs(this.b - that.b) < 0.000001)
            return true;
        else
            return false;
    }

}

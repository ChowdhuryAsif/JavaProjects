
package complexnumberdemo;


public class ComplexNumberDemo {

    
    public static void main(String[] args) {
        ComplexNumber a = new ComplexNumber(4, 2);
        ComplexNumber b = new ComplexNumber(5, 3);
        
        System.out.printf("a = ");
        a.Print();
        System.out.printf("b = ");
        b.Print();
        System.out.println("=============================");
        
        System.out.printf("a + b = ");
        a.add(b).Print();
        
        System.out.printf("a - b = ");
        a.subtract(b).Print();
        
        System.out.printf("a * b = ");
        a.multiply(b).Print();
        
        System.out.printf("a / b = ");
        a.divide(b).Print();
        
        System.out.println("=============================");
               
    }
    
}

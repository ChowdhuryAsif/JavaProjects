/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complexnumberdemo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class ComplexNumberTest {
    
    public ComplexNumberTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of add method, of class ComplexNumber.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        ComplexNumber p2 = new ComplexNumber(5, -2);
        ComplexNumber p1 = new ComplexNumber(-2, 5);
        ComplexNumber expResult = new ComplexNumber(3, 3);
        ComplexNumber result = p1.add(p2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of subtract method, of class ComplexNumber.
     */
    @Test
    public void testSubtract() {
        System.out.println("subtract");
        ComplexNumber p2 = new ComplexNumber(2, 2);
        ComplexNumber p1 = new ComplexNumber(5, 7);
        ComplexNumber expResult = new ComplexNumber(3, 5);
        ComplexNumber result = p1.subtract(p2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of multiply method, of class ComplexNumber.
     */
    @Test
    public void testMultiply() {
        System.out.println("multiply");
        ComplexNumber p2 = new ComplexNumber(3, 4);
        ComplexNumber p1 = new ComplexNumber(2, 1);
        ComplexNumber expResult = new ComplexNumber(2, 11);
        ComplexNumber result = p1.multiply(p2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testMultiply1() { 
        System.out.println("multiply");
        ComplexNumber p2 = new ComplexNumber(3, 4);
        ComplexNumber p1 = new ComplexNumber(2, -1);
        ComplexNumber expResult = new ComplexNumber(10, 5);
        ComplexNumber result = p1.multiply(p2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of divide method, of class ComplexNumber.
     */
    @Test
    public void testDivide() {
        System.out.println("divide");
        ComplexNumber p2 = new ComplexNumber(4, -3);
        ComplexNumber p1 = new ComplexNumber(3, 2);
        ComplexNumber expResult = new ComplexNumber(0.24, 0.68);
        ComplexNumber result = p1.divide(p2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testDivide1() {
        System.out.println("divide");
        ComplexNumber p2 = new ComplexNumber(2, 6);
        ComplexNumber p1 = new ComplexNumber(4, 5);
        ComplexNumber expResult = new ComplexNumber(0.95, -0.35);
        ComplexNumber result = p1.divide(p2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testDivide2() {
        System.out.println("divide");
        ComplexNumber p2 = new ComplexNumber(0, 0);
        ComplexNumber p1 = new ComplexNumber(2, 2);
        ComplexNumber expResult = null;
        ComplexNumber result = p1.divide(p2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    @Test
    public void testDivide3() {
        System.out.println("divide");
        ComplexNumber p2 = new ComplexNumber(10, 20);
        ComplexNumber p1 = new ComplexNumber(0, 2);
        ComplexNumber expResult = new ComplexNumber(0.08, 0.04);
        ComplexNumber result = p1.divide(p2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testDivide4() {
        System.out.println("divide");
        ComplexNumber p2 = new ComplexNumber(-3, 6);
        ComplexNumber p1 = new ComplexNumber(2, -1);
        ComplexNumber expResult = new ComplexNumber(-0.26667, -0.2);
        ComplexNumber result = p1.divide(p2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}

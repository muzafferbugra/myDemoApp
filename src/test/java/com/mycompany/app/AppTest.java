package com.mycompany.app;
import java.util.ArrayList;
import java.util.Arrays;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }



	public void testFound() {
      ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
      assertTrue(new App().search(array, 4));
    }

    public void testNotFound() {
      ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
      assertFalse(new App().search(array, 5));
    }

    public void testEmptyArray() {
      ArrayList<Integer> array = new ArrayList<>();
      assertFalse(new App().search(array, 1));
    }

    public void testNull() {
      assertFalse(new App().search(null, 1));
    }
    public void testInput() { //App sınıfındaki search2 metodunu kontrol eder! 

      ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1,2,3,4));

	ArrayList<Integer> array1 = new ArrayList<>(Arrays.asList(4,5,6,7));

	assertTrue(new App().search2(array,array1, 1, 2));	//iki array de ortak elemen varsa true döner!

	ArrayList<Integer> array3 = new ArrayList<>();

	ArrayList<Integer> array4 = new ArrayList<>();	

	assertFalse(new App().search2(array3,array4,1,2));	 //arraylerin ikisi de boşsa false döner!

	assertTrue(new App().search2(array,array1, 3 ,3));	 //array sizeları eşitse true döner!
	}
}

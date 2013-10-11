
/** 
 * @author Aditya Mahajan <aditya.mahajan@mcgill.ca>
 * @version 2013.10.06
 * Unit Testing Temperature class
 */

import org.junit.*;
import static org.junit.Assert.*;

public class TemperatureTest {

  @Test
  public void testGetUnits(){
	  
	  Temperature celsius = new Temperature(15, Temperature.Units.CELSIUS);
	  Temperature fahrenheit = new Temperature(15, Temperature.Units.FAHRENHEIT);
	  Temperature kelvin = new Temperature(15, Temperature.Units.FAHRENHEIT);
	  
	  assertTrue("Units should be Celsius", celsius.getUnits() == Temperature.Units.CELSIUS); 
	  //test case for Fahrenheit
	  //test case for Kelvin
 
  }

  @Test
  public void testGetValue(){
	  
	  final double THRESHOLD = 1e-6; // maximum allowable error
	  
	  // Celsius
	  Temperature belowMinTemp = new Temperature(-273.16, Temperature.Units.CELSIUS);
	  Temperature minimumTemp = new Temperature(-273.15, Temperature.Units.CELSIUS);
	  Temperature averageTemp = new Temperature(0, Temperature.Units.CELSIUS);
	  
	  assertTrue("Minimum Celsius should be -273.15", minimumTemp.getValue() == -273.15);
	  
	  // Fahrenheit
	  // Kelvin
	  
  }
  
  @Test
  public void testChangeUnits(){
	  //TODO test all six conversions
	  
	  // Celsius to Kelvin
	  Temperature cToK = new Temperature(15, Temperature.Units.CELSIUS);
	  cToK.changeUnits(Temperature.Units.KELVIN);
	  assertTrue(cToK.getUnits() == Temperature.Units.KELVIN);
	  
	  // Celsius to Fahrenheit
	  
	  // Fahrenheit to Kelvin
	  // Fahrenheit to Celsius
	  
	  // Kelvin to Celsius
	  // Kelvin to Fahrenheit
  }
}

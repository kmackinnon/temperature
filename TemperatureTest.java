/** 
 * @author Aditya Mahajan <aditya.mahajan@mcgill.ca>
 * @version 2013.10.06
 * Unit Testing Temperature class
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TemperatureTest {

	@Test
	public void testGetUnits() {

		Temperature celsius = new Temperature(15, Temperature.Units.CELSIUS);
		Temperature fahrenheit = new Temperature(15,
				Temperature.Units.FAHRENHEIT);
		Temperature kelvin = new Temperature(15, Temperature.Units.FAHRENHEIT);

		assertTrue("Units should be Celsius",
				celsius.getUnits() == Temperature.Units.CELSIUS);
		assertTrue("Units should be Fahrenheit",
				fahrenheit.getUnits() == Temperature.Units.FAHRENHEIT);
		assertTrue("Units should be Kelvin",
				kelvin.getUnits() == Temperature.Units.FAHRENHEIT);

	}

	@Test
	public void testGetValue() {

		/*
		 * My test data tests the lower boundary conditions of each temperature
		 * scale as well as a value somewhere in the middle. 1. Test a
		 * temperature below the minimum temperature. 2. Test the minimum
		 * temperature. 3. Test an average temperature.
		 */

		Temperature belowMinTemp;
		Temperature minimumTemp;
		Temperature averageTemp;

		final double THRESHOLD = 1e-6; // maximum allowable error

		// Celsius
		try {
			belowMinTemp = new Temperature(-273.16, Temperature.Units.CELSIUS);
		} catch (IllegalArgumentException ex) {
			assertTrue("Cannot have celsius lower than -273.15",
					ex instanceof IllegalArgumentException);
		}
		minimumTemp = new Temperature(-273.15, Temperature.Units.CELSIUS);
		averageTemp = new Temperature(33.3333, Temperature.Units.CELSIUS);

		assertTrue("Minimum Celsius should be -273.15",
				minimumTemp.getValue() == -273.15);
		assertEquals("An average temperature in Celsius", 33.3333,
				averageTemp.getValue(), THRESHOLD);

		// Fahrenheit
		try {
			belowMinTemp = new Temperature(-459.68,
					Temperature.Units.FAHRENHEIT);
		} catch (IllegalArgumentException ex) {
			assertTrue("Cannot have fahrenheit below -459.67",
					ex instanceof IllegalArgumentException);
		}
		minimumTemp = new Temperature(-459.67, Temperature.Units.FAHRENHEIT);
		averageTemp = new Temperature(99.9999, Temperature.Units.FAHRENHEIT);

		assertTrue("Minimum Fahrenheit should be -459.67",
				minimumTemp.getValue() == -459.67);
		assertEquals("An average temperature in Celsius", 99.9999,
				averageTemp.getValue(), THRESHOLD);

		// Kelvin
		try {
			belowMinTemp = new Temperature(-0.00001, Temperature.Units.KELVIN);
		} catch (IllegalArgumentException ex) {
			assertTrue("Cannot have negative kelvin",
					ex instanceof IllegalArgumentException);
		}
		minimumTemp = new Temperature(0, Temperature.Units.KELVIN);
		averageTemp = new Temperature(300, Temperature.Units.KELVIN);

		assertTrue("Minimum Kelvin should be zero", minimumTemp.getValue() == 0);
		assertEquals("An average temperature in Kelvin", 300,
				averageTemp.getValue(), THRESHOLD);

	}

	@Test
	public void testChangeUnits() {

		// Celsius to Kelvin
		Temperature cToK = new Temperature(15, Temperature.Units.CELSIUS);
		cToK.changeUnits(Temperature.Units.KELVIN);
		assertTrue(cToK.getUnits() == Temperature.Units.KELVIN);

		// Celsius to Fahrenheit
		Temperature cToF = new Temperature(15, Temperature.Units.CELSIUS);
		cToF.changeUnits(Temperature.Units.FAHRENHEIT);
		assertTrue(cToF.getUnits() == Temperature.Units.FAHRENHEIT);

		// Fahrenheit to Kelvin
		Temperature fToK = new Temperature(15, Temperature.Units.FAHRENHEIT);
		fToK.changeUnits(Temperature.Units.KELVIN);
		assertTrue(fToK.getUnits() == Temperature.Units.KELVIN);

		// Fahrenheit to Celsius
		Temperature fToC = new Temperature(15, Temperature.Units.FAHRENHEIT);
		fToC.changeUnits(Temperature.Units.CELSIUS);
		assertTrue(fToC.getUnits() == Temperature.Units.CELSIUS);

		// Kelvin to Celsius
		Temperature kToC = new Temperature(15, Temperature.Units.KELVIN);
		kToC.changeUnits(Temperature.Units.CELSIUS);
		assertTrue(kToC.getUnits() == Temperature.Units.CELSIUS);

		// Kelvin to Fahrenheit
		Temperature kToF = new Temperature(15, Temperature.Units.KELVIN);
		kToF.changeUnits(Temperature.Units.FAHRENHEIT);
		assertTrue(kToF.getUnits() == Temperature.Units.FAHRENHEIT);

	}
}

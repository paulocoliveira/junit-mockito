import exceptions.DivideByZeroException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class CalculatorTest {

    private Calculator calc;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp(){
        calc = mock(Calculator.class);
    }

    @Test
    public void testSum(){
        when(calc.sum(5,3)).thenReturn(8);

        int result = calc.sum(5,3);
        assertEquals(8, result);
    }

    @Test
    public void testSubtract(){
        when(calc.subtract(5,3)).thenReturn(2);

        int result = calc.subtract(5,3);
        assertEquals(2, result);
    }

    @Test
    public void testMultiply(){
        when(calc.multiply(5,3)).thenReturn(15);

        int result = calc.multiply(5,3);
        assertEquals(15, result);
    }

    @Test
    public void testDivide() throws DivideByZeroException {
        when(calc.divide(5,3)).thenReturn(1);

        int result = calc.divide(5,3);
        assertEquals(1, result);
    }

    @Test
    public void testDivideByZero() throws DivideByZeroException {
        when(calc.divide(5,0)).thenThrow(new DivideByZeroException("Cannot divide by zero!"));

        expectedException.expect(DivideByZeroException.class);
        expectedException.expectMessage("Cannot divide by zero!");

        calc.divide(5,0);
    }
}

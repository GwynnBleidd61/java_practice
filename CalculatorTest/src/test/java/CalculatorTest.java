import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }


    @Test
    void WhenAddTenToFiveThenResultFifteen() {
        int expected = 15;
        int result = calculator.add(10, 5);
        assertEquals(expected, result);
    }

    @Test
    public void when5AddTo10AsStringThenResult15() {
        int expected = 15;
        int result = calculator.add("10", "5");
        assertEquals(expected, result);
    }

    @Test()
    public void whenInputIncorrectValueThenThrowException() {
        NumberFormatException thrown = Assertions.assertThrows(NumberFormatException.class, () -> {
            calculator.add("sd", "15");
        });
    }


    @Test
    void add() {
        int expected = 150;
        int result = calculator.add(100, 50);
        assertEquals(expected, result);
    }


    @Test
    void multiply() {
        double expected = 240;
        double result = calculator.multiply(12.0, 20);
        assertEquals(expected, result, 0.001);
    }

    @Test
    void divide() {
        double expected = 5;
        double result = calculator.divide(10.0, 2);
        assertEquals(expected, result, 0.001);
    }

    @AfterEach
    public void close() {
        calculator = null;
    }
}
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class MathUtilsTest {
    private MathUtils math;
    private int a;
    private int b;
    private int zero;
    private int negative;

    @BeforeEach
    void setUp() {
        math = new MathUtils();
        a = 2;
        b = 5;
        zero = 0;
        negative = -1;
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testAdd() {
        assertEquals(7, math.add(a, b));
        assertEquals(2, math.add(a, zero));
        assertEquals(1, math.add(a, negative));
    }

    @Test
    void testSubtract() {
        assertEquals(-3, math.subtract(a, b));
        assertEquals(2, math.subtract(a, zero));
        assertEquals(3, math.subtract(a, negative));
    }

    @Test
    void testMultiply() {
        assertEquals(10, math.multiply(a, b));
        assertEquals(0, math.multiply(a, zero));
        assertEquals(-2, math.multiply(a, negative));
    }

    @Test
    void testDivide() {
        assertEquals(0.4, math.divide(a, b));
        assertEquals(-2.0, math.divide(a, negative));
        assertEquals(-1.0, math.divide(a, zero));
    }
}
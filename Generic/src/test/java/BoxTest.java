import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BoxTest {

    @Test
    public void testBox() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(14);
        numbers.add(1123);
        List<Number> numbers2 = new ArrayList<>();
        Box.transfer(numbers, numbers2);
        assertEquals(numbers.size(), 0);
        assertEquals(3, numbers2.size());
    }
}
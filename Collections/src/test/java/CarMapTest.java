import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarMapTest {

    private CarMap<CarOwner, Car> map;

    @BeforeEach
    void setUp() {
        map = new CarHashMap<CarOwner, Car>();
    }

    @Test
    public void whenPut100ElementsThenSizeBecome100() {
        for (int i = 0; i < 100; i++) {
            map.put(new CarOwner(i, "Name" + i, "LastName" + i),
                    new Car("Brand" + i, i));
        }
        assertEquals(100, map.size());
    }

    @Test
    public void whenPut100ElementsWith10DifferentKeysThenSize10() {
        for (int i = 0; i < 100; i++) {
            int index = i % 10;
            map.put(new CarOwner(index, "Name" + index, "LastName" + index),
                    new Car("Brand" + index, index));
        }
        assertEquals(10, map.size());
    }

    @Test
    public void removeReturnTrueOnlyOnce() {
        for (int i = 0; i < 10; i++) {
            map.put(new CarOwner(i, "Name" + i, "LastName" + i),
                    new Car("Brand" + i, i));
        }
        assertEquals(10, map.size());

        CarOwner elementForDeleting = new CarOwner(5, "Name5", "LastName5");
        assertTrue(map.remove(elementForDeleting));
        assertEquals(9, map.size());
        assertFalse(map.remove(elementForDeleting));
    }

    @Test
    public void countOfKeysMustBeEqualsToCountOfValues() {
        for (int i = 0; i < 100; i++) {
            map.put(new CarOwner(i, "Name" + i, "LastName" + i),
                    new Car("Brand" + i, i));
        }
        assertEquals(100, map.size());
        assertEquals(map.keySet().size(), 100);
        assertEquals(100, map.values().size());
    }

    @Test
    public void methodGetMustReturnRightValue() {
        for (int i = 0; i < 100; i++) {
            map.put(new CarOwner(i, "Name" + i, "LastName" + i),
                    new Car("Brand" + i, i));
        }
        CarOwner key = new CarOwner(50, "Name50", "LastName50");
        Car value = map.get(key);
        String expectedCarBrand = "Brand50";
        assertEquals(expectedCarBrand, value.getBrand());
    }
}
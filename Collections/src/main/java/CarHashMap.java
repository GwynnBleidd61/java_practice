import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarHashMap<K, V> implements CarMap<K, V> {

    private static final int INITIAL_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;
    private int size = 0;

    private Object[] array = new Object[INITIAL_CAPACITY];

    @Override
    public void put(K key, V value) {
        if (size >= array.length * LOAD_FACTOR) {
            increaseArray();
        }
        boolean added = put(key, value, array);
        if (added) { 
            size++;
        }
    }

    private boolean put(K key, V value, Object[] dst) {
        int position = getElementPosition(key, dst.length);
        if (dst[position] == null) {
            Entry entry = new Entry(value, key, null);
            dst[position] = entry;
            return true;
        } else {
            Entry existedElement = (Entry) dst[position];
            while (true) {
                if (existedElement.key.equals(key)) {
                    existedElement.value = value;
                    return false;
                } else if (existedElement.next == null) {
                    existedElement.next = new Entry(value, key, null);
                    return true;
                } else {
                    existedElement = existedElement.next;
                }
            }
        }
    }

    @Override
    public boolean remove(K key) {
        int position = getElementPosition(key, array.length);
        if (array[position] == null) {
            return false;
        }
        Entry secondLast = (Entry) array[position];
        Entry last = secondLast.next;
        if (secondLast.key.equals(key)) {
            array[position] = last;
            size--;
            return true;
        }
        while (last != null) {
            if (last.key.equals(key)) {
                secondLast.next = last.next;
                size--;
                return true;
            } else {
                secondLast = last;
                last = last.next;
            }
        }
        return false;
    }

    @Override
    public Set<K> keySet() {
        Set<K> result = new HashSet<>();
        for (Object entry : array) {
            Entry existedElement = (Entry) entry;
            while (existedElement != null) {
                result.add(existedElement.key);
                existedElement = existedElement.next;
            }
        }
        return result;
    }

    @Override
    public List<V> values() {
        List<V> result = new ArrayList<>();
        for (Object entry : array) {
            Entry existedElement = (Entry) entry;
            while (existedElement != null) {
                result.add(existedElement.value);
                existedElement = existedElement.next;
            }
        }
        return result;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        array = new Object[INITIAL_CAPACITY];
        size = 0;
    }


    private void increaseArray() {
        Object[] newArray = new Object[array.length * 2];
        for (Object entry : array) {
            Entry existedElement = (Entry) entry;
            while (existedElement != null) {
                put(existedElement.key, existedElement.value, newArray);
                existedElement = existedElement.next;
            }
        }
        array = newArray;
    }

    private int getElementPosition(K key, int arrayLength) {
        return Math.abs(key.hashCode()) % arrayLength;
    }

    private class Entry {
        private V value;
        private K key;
        private Entry next;

        public Entry(V value, K key, Entry next) {
            this.value = value;
            this.key = key;
            this.next = next;
        }
    }

    @Override
    public V get(K key) {
        int position = getElementPosition(key, array.length);
        Entry existedElement = (Entry) array[position];
        while (existedElement != null) {
            if (existedElement.key.equals(key)) {
                return existedElement.value;
            } else {
                existedElement = existedElement.next;
            }
        }
        return null;
    }
}

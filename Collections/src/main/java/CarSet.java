public interface CarSet extends CarCollection{
    boolean add(Car car);
    boolean remove(Car car);
    boolean contains(Car car);
    int size();
    void clear();
}

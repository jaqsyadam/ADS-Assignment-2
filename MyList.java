public interface MyList<E> {
    void add(E element);
    void add(int index, E element);
    E remove(int index);
    E get(int index);
    int size();
}

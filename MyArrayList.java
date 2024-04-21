public class MyArrayList<E> implements MyList<E> {
    private Object[] elements;
    private int size;
    private static final int default_capacity = 15;

    public MyArrayList() {
        elements = new Object[default_capacity];
        size = 0;
    }
}
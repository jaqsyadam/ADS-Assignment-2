public class MyArrayList<E> implements MyList<E> {
    private Object[] elements;
    private int size;
    private static final int default_capacity = 15;

    public MyArrayList() {
        elements = new Object[default_capacity];
        size = 0;
    }
    private void capacityCheck(int minCapacity) {
        if (minCapacity > elements.length) {
            int newCapacity = Math.max(minCapacity, elements.length * 2);
            Object[] newElements = new Object[newCapacity];
            System.arraycopy(elements, 0, newElements, 0, size);
            elements = newElements;
        }
    }
}
public class MyArrayList<E> implements MyList<E> {
    private Object[] elements;
    private int size;
    private static final int default_capacity = 15;

    public MyArrayList() { //initialize array
        elements = new Object[default_capacity];
        size = 0;
    }
    private void capacityCheck(int minCapacity) { //func for increase capacity of array by multiplying initial capacity to 2
        if (minCapacity > elements.length) {
            int newCapacity = Math.max(minCapacity, elements.length * 2);
            Object[] newElements = new Object[newCapacity];
            System.arraycopy(elements, 0, newElements, 0, size);
            elements = newElements;
        }
    }
    public void add(E element) { //Add new element at the end of Array
        capacityCheck(size + 1); //this func will increase array capacity to add new element
        elements[size++] = element;
    }

    @Override
    public void add(int index, E element) { //add new element to specific index
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        capacityCheck(size + 1);
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    @Override
    public E get(int index) { //return element in e type
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return (E) elements[index];
    }

    @Override
    public E remove(int index) { //remove element
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        E removedElement = (E) elements[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--size] = null;
        return removedElement;
    }

    @Override
    public int size() { //return size, it is important to control size of array
        return size;
    }
}
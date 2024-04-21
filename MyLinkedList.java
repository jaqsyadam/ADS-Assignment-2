public class MyLinkedList<E> implements MyList<E> {
    private static class MyNode<E> {
        E element;
        MyNode<E> next;
        MyNode<E> prev;

        MyNode(E element, MyNode<E> prev, MyNode<E> next) { //node constructor
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
    }

    private MyNode<E> head;
    private MyNode<E> tail;
    private int size;

    public MyLinkedList() { //initialize head and tail which are null by default
        head = null;
        tail = null;
        size = 0;
    }
    private MyNode<E> getNode(int index) { //to get current node
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        MyNode<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }
    private void unlink(MyNode<E> node) { //to remove connection of element with node
        MyNode<E> pred = node.prev;
        MyNode<E> succ = node.next;

        if (pred == null) {
            head = succ;
        } else {
            pred.next = succ;
            node.prev = null;
        }

        if (succ == null) {
            tail = pred;
        } else {
            succ.prev = pred;
            node.next = null;
        }

        node.element = null;
        size--;
    }

    @Override
    public void add(E element) {
        add(size, element);
    }

    @Override
    public void add(int index, E element) { //add new element to specific index by creating new node
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (index == size) {
            addLast(element);
        } else {
            MyNode<E> succ = getNode(index);
            MyNode<E> pred = succ.prev;
            MyNode<E> newNode = new MyNode<>(element, pred, succ);
            succ.prev = newNode;
            if (pred == null) {
                head = newNode;
            } else {
                pred.next = newNode;
            }
            size++;
        }
    }

    private void addLast(E element) { //add element to the end of list
        MyNode<E> newNode = new MyNode<>(element, tail, null);
        if (tail == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    @Override
    public E get(int index) {
        return getNode(index).element;
    }

    @Override
    public E remove(int index) { //use unlink func to disable node and delete element of list
        MyNode<E> nodeToRemove = getNode(index);
        unlink(nodeToRemove);
        return nodeToRemove.element;
    }

    @Override
    public int size() { //list size
        return size;
    }
}
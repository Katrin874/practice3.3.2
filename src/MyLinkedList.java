import java.awt.*;
import java.util.NoSuchElementException;
import java.util.Objects;

public class MyLinkedList<T> {
    static class Node<T> {
        T element;
        Node<T> next;

        public Node(T element) {
            this.element = element;
        }
    }

    private Node<T> last;
    private Node<T> first;
    private int size;

    public void add(T element) {
        Node<T> newNode = new Node<>(element);
        if (size == 0) {
            first = last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        size++;
    }
        public void addFirst(T element){
        Node<T> newNode = new Node<>(element);
        if(size==0){
            first = last = newNode;
        } else{
            first.next=first;
            first = newNode;
        }
        size++;
    }

    public void add(T element, int index) {
        Objects.checkIndex(index, size + 1);
        Node<T> newNode = new Node<>(element);
        if (size == 0) {
            first = last = newNode;
        } else if (index == 0) {
            newNode.next = first;
            first = newNode;
        } else if (index == size) {
            last.next = newNode;
            last = newNode;
        } else {
            Node<T> previous = getNodeByIndex(index - 1);
            newNode.next = previous.next;
            previous.next = newNode;
        }
        size++;
    }
    private Node<T> getNodeByIndex(int index) {
        Node<T> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    public void set(int index, T element) {
        Objects.checkIndex(index, size);
        Node<T> node = getNodeByIndex(index);
        node.element = element;
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        return getNodeByIndex(index).element;
    }
    public void displayList(MyLinkedList<T>list){
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        for (int i =0; i<list.size;i++){
            System.out.println(list.get(i));
        }
    }
    public T getFirst() {
        return get(0);
    }

    private boolean isEmpty() {
        if (first == null) {
            return true;
        } else return false;
    }

    public T getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return get(size - 1);
    }

    public T remove(int index) {
        Objects.checkIndex(index, size);
        T removedElement;
        if (index == 0) {
            removedElement = first.element;
            first = first.next;
            if (first == null) {
                last = null;
            }
        } else {
            Node<T> previous = getNodeByIndex(index - 1);
            removedElement = previous.next.element;
            previous.next = previous.next.next;
            if (index == size - 1) {
                last = previous;
            }
        }
        size--;
        return removedElement;
    }
    public T removeFirst(){
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T removedElement = first.element;
        first = first.next;
        if(first == null){
            last = null;
        }
        size--;
        return removedElement;
    }
    public T removeLast(){
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Node<T> previous = getNodeByIndex(size-2);
        T removedElement = last.element;
        previous.next = null;
        last = previous;
        size--;
        return removedElement;

    }

    public boolean contains(T element) {
        Node<T> current = first;
        for (int i = 0; i < size; i++) {
            if (current.element.equals(element)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    public int getSize(){
        return size;
    }
    public void clear(){
        first=last=null;
        size=0;
    }

}

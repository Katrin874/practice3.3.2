public class MyStack<T> {
    MyLinkedList<T>myLinkedList=new MyLinkedList<>();
    public void push(T e) {
        myLinkedList.addFirst(e);
    }

    public T pop() {
        return myLinkedList.removeFirst();
    }
}

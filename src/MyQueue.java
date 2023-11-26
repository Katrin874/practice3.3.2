public class MyQueue<T> {
    MyLinkedList<T>  myLinkedList = new MyLinkedList<>();
    public void offer(T e){
        myLinkedList.add(e);
    }
    public T peek(){
        return myLinkedList.getFirst();
    }
    public T poll(int index){
        return myLinkedList.remove(index);
    }
}

import java.util.Iterator;

/** LinkedListDeque is a Deque implements Linked List. It has pointers pointing both its previous and next */
public class LinkedListDeque<T> implements LIstDeque<T>,Iterable<T> {
    /**the sentinel has three parts, its head pints to previous item, body contains objest and
     * tail points to next item*/
    private static class Node<T>{
        public Node head;
        public T body;
        public Node tail;
        public Node(Node h,T b, Node t){
            head = h;
            body = b;
            tail = t;
        }
    }
    /**last item is at sentinel.head, first item is at sentinel.tail*/
    private Node sentinel;
    private int size;
    public LinkedListDeque(){
       sentinel = new Node(null, null, null);
        sentinel.head = sentinel;
        sentinel.tail = sentinel;
        size = 0;

    }
    public SSiterator<T> iterator(){
        return new SSiterator();
    }
    private class SSiterator<T> implements Iterator<T>{
        public Node cursor;
        public int howbig;

        public SSiterator(){
            cursor = sentinel.tail;
            howbig = size;

        }
        @Override
        public boolean hasNext(){
            return cursor.body!= null && howbig != 0;

        }

        @Override
        public T next(){
            T item = (T)cursor.body;
            cursor = cursor.tail;
            howbig -= 1;
            return item;
        }
    }
    /**add item T to first position that is pointed by sentinel.tail
     * @param item*/
    @Override
    public void addFirst(T item) {
        size += 1;
        Node newFirst = new Node(sentinel, item, sentinel.tail);
        sentinel.tail.head = newFirst;
        sentinel.tail = newFirst;
    }
    /**add item T to last position that is pointed by sentinel.head*/
    public void addLast(T item) {
        size += 1;
        Node newLast = new Node(sentinel.head, item, sentinel);
        sentinel.head.tail = newLast;
        sentinel.head = newLast;

    }
    /**return true is list is empty */
    public boolean isEmpty(){
        return size == 0;
    }

    /**return list size*/
    public int size(){
        return size;
    }
    /**print all the items in the list by iteration*/
    public void printDeque() {
//        for (int i = 0; i < size; i++) {
//            System.out.print(get(i) + " ");
//        }
//        System.out.println();
        for (Node n =sentinel.tail; n.tail != sentinel.tail; n = n.tail){
            System.out.print(n.body + " ");
        }

        System.out.println();

    }
    /**remove the first item and return item T*/
    public T removeFirst() {
        size -= 1;
        T item = (T)sentinel.tail.body;
        sentinel.tail = sentinel.tail.tail;
        sentinel.tail.head = sentinel;
        return item;

    }
    /**return the last item and return item T*/
    public T removeLast() {
        size -= 1;
        T item = (T)sentinel.head.body;
        sentinel.head = sentinel.head.head;
        sentinel.head.tail = sentinel;
        return item;

    }
    /**get the item in position indexed*/
    public T get(int index) {
        Node P = sentinel.tail;
        while(index > size) {
            index -= size;
        }
        for (int i = 0; i< index; i++){
            P = P.tail;
        }
        return (T)P.body;
    }
    /**recursive get (index) method*/
    public T getRecursive(int index) {
        return GetRecursive(index,sentinel.tail);

    }
    /**helper method for GetRecursive*/
    private T GetRecursive(int index, Node S) {
        if(index == 0) {
            return (T)S.body;
        }
        return GetRecursive(index - 1, S.tail);
    }

    public static void main(String[] args){
        LinkedListDeque<String> w = new LinkedListDeque<>();
        String array[] = new String[]{"a","b","c","d","e","f","g","h","i","j","k"};
        for (int i = 0; i< array.length; i++) {
            w.addLast(array[i]);
        }
        for(String a:w){
            System.out.println(a);
        }

    }

}

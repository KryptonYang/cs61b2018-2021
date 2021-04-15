package synthesizer;

public interface BoundedQueue<T> extends Iterable<T> {
    /**return the size of the buffer*/
    int capacity();
    /**return number of items currently in the buffer*/
    int fillCount();
    /** add item x to the end */
    void enqueue(T x);
    /** delete and return the item from front */
    T dequeue();
    /**return but do not delete the item from the front */
    T peek();


    default boolean isEmpty() {
        return fillCount() == 0;
    }

    default boolean isFull() {
        return fillCount() == capacity();
    }

}

package synthesizer;
import java.util.Iterator;


public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> implements Iterable<T> {
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        // TODO: Create new array with capacity elements.
        //       first, last, and fillCount should all be set to 0.
        //       this.capacity should be set appropriately. Note that the local variable
        //       here shadows the field we inherit from AbstractBoundedQueue, so
        //       you'll need to use this.capacity to set the capacity.
        Capacity = capacity;
        fillCount = 0;
        first = capacity/2;
        last = first;
        rb = (T[])new Object[capacity];
    }


    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    @Override
    public void enqueue(T x) {
        if(fillCount == Capacity){
            throw new RuntimeException("Ring buffer overflow");
        }
        rb[last] = x;
        last += 1;
        if(last == Capacity){
            last = last - Capacity;
        }
        fillCount += 1;
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    @Override
    public T dequeue() {
        // TODO: Dequeue the first item. Don't forget to decrease fillCount and update
        if(fillCount == 0) {
            throw new RuntimeException("Ring buffer underflow");
        }
        T firstItem = rb[first];
        rb[first] = null;
        first += 1;
        if(first == Capacity){
            first = first - Capacity;
        }
        fillCount -= 1;
        return firstItem;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    @Override
    public T peek() {
        return rb[first];
        // TODO: Return the first item. None of your instance variables should change.
    }

    @Override
    public Iterator<T> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator<T> implements Iterator<T>{
        int widpiont;
        int size;
        public QueueIterator(){
            widpiont = first;
            size = fillCount;
        }
        @Override
        public boolean hasNext() {
            return size != 0;
        }

        @Override
        public T next() {
            T next = (T) rb[widpiont];
            widpiont += 1;
            size -= 1;
            if(widpiont == Capacity ){
                widpiont -= Capacity;
            }
            return next;
        }



    }

    // TODO: When you get to part 5, implement the needed code to support iteration.

}

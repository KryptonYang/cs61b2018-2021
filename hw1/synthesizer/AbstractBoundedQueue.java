package synthesizer;

public abstract class AbstractBoundedQueue<T> implements BoundedQueue<T>{
  protected int fillCount;
  protected  int Capacity;
  public int capacity(){
    return Capacity;
  }
  public int fillCount(){
      return fillCount;
  }
  //public boolean isEmpty()
  //public boolean isFull()

  public abstract T peek();
  public abstract T dequeue();
  public abstract void enqueue(T x);




}

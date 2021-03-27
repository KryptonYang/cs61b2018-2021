/**implements Deque with ArrayList*/
public class ArrayDeque<T> implements Deque<T>{
    T[] items;
    int size;               //changes whether add or remove
    int nextLast;           //nestLast only changes when call addLast/removeLast
    int nextFirst;          //nextFirst only changes when call addFirst/removeFirst
    int capability;

   public ArrayDeque(){
        size = 0;
        nextLast = 4;
        nextFirst = 3;
        capability = 8;
        items = (T[]) new Object[capability];

    }
    /** helper method to reposition nestLast/nextFirst, to avoid null pointer*/
    private int reposition(int next, int capability) {
        if(next >= capability) {
            next -= capability;
        }
        if (next < 0) {
            next += capability;
        }
        return next;
    }
    @Override
    public void addFirst(T item) {
        if(capacityRatio() > 0.6){
            upSize();}
        items[nextFirst] = item;
        nextFirst = reposition(nextFirst - 1, capability);
        size += 1;

    }
    @Override
    public void addLast(T item) {
        if(capacityRatio() > 0.6){
            upSize();}
        items[nextLast] = item;
        nextLast = reposition(nextLast + 1, capability);
        size += 1;

    }
    @Override
    public boolean isEmpty(){
        return size == 0;

    }
    @Override
    public int size(){
        return size;

    }
    @Override
    public void printDeque() {
        int currentFirst = reposition(nextFirst + 1,capability);
        for(int  s = 0; s < size; s++ ){
            currentFirst = reposition(currentFirst,capability);
            System.out.print(items[currentFirst] + " ");
            currentFirst++;
        }
        System.out.println();
//        int i = currentFirst;
//        for(int s = 0; s < size; s++ ){
//            i = reposition(i,capability);
//            newArray[s] = items[i];
//            i++;
        //}
//        for (int i = 0; i < size; i++) {
//            System.out.print(get(i) + " ");
//        }
//        System.out.println();
    }
    @Override
    public T removeFirst() {
        if (capacityRatio() < 0.3 && capability > 8){
            downSize();
        }
        int currentFirst = reposition((nextFirst + 1), capability);
        T item = items[currentFirst];
        nextFirst = currentFirst;
        size -= 1;

        return item;
    }
    @Override
    public T removeLast() {
        if (capacityRatio() < 0.3 && capability > 8){
            downSize();
        }
        int currentLast = reposition((nextLast - 1), capability);
        T item = items[currentLast];
        nextLast = currentLast;
        size -= 1;

        return item;
    }
    @Override
    public T get(int index) {
        int targetIndex = reposition((nextFirst + 1 + index ), capability);
        return items[targetIndex];
    }
    /**private helper method to check if array needs to be resized.*/
    private double capacityRatio(){
        double Size = size;
        double Capacity = capability;
        double ratio = Size/Capacity;
        return ratio;
    }
    /**resize the t[] to make sure size/capacity keeps about 25% usage, copy original array to new sized array*/
    private void resize(int NewCapability){

        int currentFirst = reposition(nextFirst + 1, capability);
        T[] newArray = (T[])new Object[NewCapability];
        for(int s = 0; s < size; s++ ){
            currentFirst = reposition(currentFirst,capability);
            newArray[s] = items[currentFirst];
            currentFirst++;
            }
        items = newArray;
        capability = NewCapability;
        nextFirst = capability - 1;
        nextLast = size;

    }
    /**increase the size by two times*/
    private void upSize(){
        resize(capability*2);
    }
    /**cut the size by half */
    private void downSize() {
        resize(capability/2);
    }

    public static void main(String[] args) {
        ArrayDeque<String> w = new ArrayDeque<>();
        String array[] = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k","l","m","n","o","p","q"};
        for (int i = 0; i < array.length; i++) {
            w.addLast(array[i]);
        }
        w.printDeque();
    }
}

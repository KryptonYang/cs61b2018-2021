import org.junit.Test;
import org.junit.Assert;

/**test LIstDque using Junit test */
public class TestLIstDeque {
    @Test
    public void TestAddLast(){
        LIstDeque a = new ArrayListDeque();
        String[] input = {"I", "love", "you", "for", "a", "thousand"};
        for(String i:input){
            a.addLast(i);
        }
        String[] output = new String[a.size()];
        for(int i = 0; i<a.size(); i++) {
            output[i] = (String)a.get(i);
        }
        Assert.assertArrayEquals(input,output);

    }
    @Test
    public void TestAddFirst() {
        LIstDeque a = new ArrayListDeque();
        int[] input = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21};
        for(int i:input){
            a.addFirst(i);
        }
        int[] output = new int[a.size()];
        for(int i = 0; i<a.size(); i++) {
            output[i] = (int)a.get(i);
        }
        int[] expected = {21,20,19,18,17,16,15,14,13,12,11,10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        Assert.assertArrayEquals(output,expected);
    }
    @Test
    public void TestRemoveFirst(){
        LIstDeque a = new ArrayListDeque();
        int[] input = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21};
        for(int i:input){
            a.addLast(i);
        }
        int size = a.size();
        int[] output = new int[size];
        for(int i = 0; i<size; i++) {
            output[i] = (int)a.removeFirst();
        }
        Assert.assertArrayEquals(input,output);
    }
    @Test
    public void TestRemoveLast() {
        LIstDeque a = new ArrayListDeque();
        int[] input ={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21};
        for (int i : input) {
            a.addLast(i);
        }
        int size = a.size();
        int[] output = new int[size];
        for (int i = 0; i < size; i++) {
            output[i] = (int) a.removeLast();
        }
        int[] expected = {21,20,19,18,17,16,15,14,13,12,11,10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        Assert.assertArrayEquals(output, expected);
        for(int i: expected) {
            a.addFirst(i);
        }
        Assert.assertEquals(21,a.size());
    }
    @Test
    public void TestRecursiveGet() {
        LinkedListDeque a = new LinkedListDeque();
        String[] input = {"I", "love", "you", "for", "a", "thousand"};
        for(String i:input){
            a.addLast(i);
        }
        for(int i = 0; i < a.size(); i++) {
            Assert.assertSame( a.get(i), a.getRecursive(i));
        }

    }

}
